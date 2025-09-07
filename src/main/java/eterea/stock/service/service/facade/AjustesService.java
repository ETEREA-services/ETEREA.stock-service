package eterea.stock.service.service.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import eterea.stock.service.client.ArticuloClient;
import eterea.stock.service.client.EmpresaClient;
import eterea.stock.service.client.StockClient;
import eterea.stock.service.model.ArticuloMovimientoDto;
import eterea.stock.service.model.StockMovimientoDto;
import eterea.stock.service.model.dto.*;
import eterea.stock.service.util.Tool;
import eterea.stock.service.util.transfer.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AjustesService {

    private final ArticuloClient articuloClient;
    private final EmpresaClient empresaClient;
    private final StockClient stockClient;

    public AjustesService(ArticuloClient articuloClient,
                          EmpresaClient empresaClient,
                          StockClient stockClient) {
        this.articuloClient = articuloClient;
        this.empresaClient = empresaClient;
        this.stockClient = stockClient;
    }

    public StockResponseDto upload(FileInfo fileInfo, Integer centroStockId, Integer comprobanteId, OffsetDateTime fechaRegistro) {
        log.debug("Processing AjustesService.upload");
        String response = "";
        File file = Tool.writeFile(fileInfo);
        List<RubroDto> rubros = new ArrayList<>();

        // Procesa Excel
        try {
            InputStream input = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(input);

            Sheet sheet = workbook.getSheetAt(0);

            String currentRubroName = null;
            List<ArticuloAjusteDto> articulos = new ArrayList<>();

            for (Row row : sheet) {
                // Leer el nombre del rubro
                if (row.getCell(0) != null && row.getCell(1) == null) {
                    if (currentRubroName != null && !articulos.isEmpty()) {
                        var rubro = RubroDto.builder()
                                .nombre(currentRubroName)
                                .articulos(articulos)
                                .build();
                        log.debug("Rubro Leído -> {}", rubro.jsonify());
                        rubros.add(rubro);
                        articulos = new ArrayList<>();
                    }
                    String rawRubroName = row.getCell(0).getStringCellValue();
                    // Quitar "Rubro: " si está presente
                    currentRubroName = rawRubroName.replace("Rubro: ", "").trim();
                }

                // Leer las filas de artículos
                if (row.getRowNum() > 2 && row.getCell(0) != null && row.getCell(1) != null) {
                    Cell codigoCell = row.getCell(0);
                    if (codigoCell.getCellType() == CellType.STRING || codigoCell.getCellType() == CellType.NUMERIC) {
                        String codigo = codigoCell.getCellType() == CellType.STRING
                                ? codigoCell.getStringCellValue()
                                : String.valueOf((long) codigoCell.getNumericCellValue());

                        String articulo = row.getCell(1).getStringCellValue();
                        BigDecimal inventario = getBigDecimalFromCell(row.getCell(2));
                        BigDecimal stock = getBigDecimalFromCell(row.getCell(3));
                        BigDecimal diferencia = getBigDecimalFromCell(row.getCell(4));

                        if (diferencia.compareTo(BigDecimal.ZERO) != 0) {

                            var articuloAjuste = ArticuloAjusteDto.builder()
                                    .articuloId(codigo)
                                    .descripcion(articulo)
                                    .inventario(inventario)
                                    .stock(stock)
                                    .diferencia(diferencia)
                                    .build();
                            log.debug("Articulo Ajuste Leido -> {}", articuloAjuste.jsonify());
                            articulos.add(articuloAjuste);
                        }
                    }
                }
            }

            // Agregar el último rubro si queda alguno pendiente
            if (currentRubroName != null && !articulos.isEmpty()) {
                var rubro = RubroDto.builder()
                        .nombre(currentRubroName)
                        .articulos(articulos)
                        .build();
                log.debug("Rubro Leido -> {}", rubro.jsonify());
                rubros.add(rubro);
            }

            workbook.close();
            input.close();

        } catch (Exception e) {
            response = response + "Error uploading -> " + e.getMessage();
        }

        // Grabado del ajuste
        var negocioId = empresaClient.findTop().getNegocioId();
        var stockMovimiento = StockMovimientoDto.builder()
                .negocioId(negocioId)
                .negocioIdDesde(negocioId)
                .centroStockIdDesde(centroStockId)
                .comprobanteId(comprobanteId)
                .observaciones(fileInfo.getObservaciones())
                .fechaRegistro(fechaRegistro)
                .fechaContable(fechaRegistro)
                .centroStockIdHastaNombre("")
                .importe(BigDecimal.ZERO)
                .nivel(0)
                .generacionAutomatica((byte) 0)
                .pendiente((byte) 0)
                .rechazada((byte) 0)
                .facturaProveedor((byte) 0)
                .netoFactura(BigDecimal.ZERO)
                .netoRegistrado(BigDecimal.ZERO)
                .centroStockIdHasta(0)
                .proveedorId(0L)
                .clienteId(0L)
                .legajo(0L)
                .comprobanteIdFactura(0)
                .prefijoFactura(0)
                .numeroComprobanteFactura(0L)
                .letraComanda("")
                .cierreCajaId(0L)
                .cierreRestaurantId(0L)
                .ordenContable(0)
                .negocioIdHasta(0)
                .negocioIdOtro(0)
                .build();

        var articuloMovimientos = new ArrayList<ArticuloMovimientoDto>();
        var item = 0;
        for (RubroDto rubro : rubros) {
            for (ArticuloAjusteDto articuloAjuste : rubro.getArticulos()) {
                try {
                    var articulo = articuloClient.findByArticuloId(articuloAjuste.getArticuloId());
                    var articuloMovimiento = ArticuloMovimientoDto.builder()
                            .centroStockId(centroStockId)
                            .articuloId(articuloAjuste.getArticuloId())
                            .cantidad(articuloAjuste.getDiferencia())
                            .numeroCuenta(articulo.getCuentaCompras() == null ? 0L : articulo.getCuentaCompras())
                            .precioCompra(articulo.getPrecioCompra())
                            .fechaMovimiento(stockMovimiento.getFechaRegistro())
                            .centroStockId(stockMovimiento.getCentroStockIdDesde())
                            .comprobanteId(stockMovimiento.getComprobanteId())
                            .negocioId(stockMovimiento.getNegocioId())
                            .item(++item)
                            .articulo(articulo)
                            .clienteMovimientoId(0L)
                            .tenenciaMovimientoId(0L)
                            .precioUnitario(BigDecimal.ZERO)
                            .precioUnitarioSinIva(BigDecimal.ZERO)
                            .precioUnitarioConIva(BigDecimal.ZERO)
                            .iva105((byte) 0)
                            .exento((byte) 0)
                            .nivel(0)
                            .cierreCajaId(0L)
                            .cierreRestaurantId(0L)
                            .precioValuacion(BigDecimal.ZERO)
                            .mozoId(0L)
                            .comision(BigDecimal.ZERO)
                            .build();
                    articuloMovimientos.add(articuloMovimiento);
                } catch (Exception e) {
                    log.debug("No se pudo encontrar el articulo con id {}", articuloAjuste.getArticuloId());
                }
            }

        }

        var stockAndArticulos = StockAndArticulosDto.builder()
                .stockMovimiento(stockMovimiento)
                .articuloMovimientos(articuloMovimientos)
                .build();

        stockMovimiento = stockClient.addMovimiento(stockAndArticulos);
        log.debug("Stock movimiento: {}", stockMovimiento.jsonify());

        var stockResponse = StockResponseDto.builder()
                .stockMovimiento(stockMovimiento)
                .response(response)
                .build();
        log.debug("Stock response: {}", stockResponse.jsonify());

        return stockResponse;

    }

    // Método auxiliar para manejar celdas que pueden ser numéricas o texto
    private static BigDecimal getBigDecimalFromCell(Cell cell) {
        if (cell == null) {
            return BigDecimal.ZERO;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                return BigDecimal.valueOf(cell.getNumericCellValue());
            case STRING:
                try {
                    return new BigDecimal(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    // En caso de que el valor no se pueda convertir a BigDecimal
                    return BigDecimal.ZERO;
                }
            default:
                return BigDecimal.ZERO;
        }
    }

}
