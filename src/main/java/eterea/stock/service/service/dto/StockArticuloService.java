package eterea.stock.service.service.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import eterea.stock.service.client.ArticuloBarraClient;
import eterea.stock.service.client.ArticuloClient;
import eterea.stock.service.model.dto.ArticuloStockDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Slf4j
public class StockArticuloService {

    private final ArticuloClient articuloClient;
    private final ArticuloBarraClient articuloBarraClient;

    public StockArticuloService(ArticuloClient articuloClient, ArticuloBarraClient articuloBarraClient) {
        this.articuloClient = articuloClient;
        this.articuloBarraClient = articuloBarraClient;
    }

    public ArticuloStockDto getStockArticulo(String codigo) {

        log.debug("Trying Articulo Nativo -> {}", codigo);
        try {
            // Verifica si el código enviado es nativo
            var articulo = articuloClient.findByArticuloId(codigo);
            try {
                log.debug("Articulo Nativo -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articulo));
            } catch (JsonProcessingException e) {
                log.debug("Articulo Nativo -> {}", e.getMessage());
            }
            return ArticuloStockDto.builder()
                    .articulo(articulo)
                    .cantidad(BigDecimal.ZERO)
                    .build();
        } catch (Exception e) {
            log.debug("Código no corresponde a Artículo");
        }

        log.debug("Trying Código Barras Completo -> {}", codigo);
        try {
            // Verifica si es un código de barras completo
            var articuloBarra = articuloBarraClient.findByCodigoBarras(codigo);
            try {
                log.debug("Articulo de Barras -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(articuloBarra));
            } catch (JsonProcessingException e) {
                log.debug("Articulo de Barras -> {}", e.getMessage());
            }
            return ArticuloStockDto.builder()
                    .articulo(articuloBarra.getArticulo())
                    .cantidad(BigDecimal.ZERO)
                    .build();
        } catch (Exception e) {
            log.debug("Código no corresponde a Artículo de Barras");
        }

        // Verifica si es un código de barras de Carnes de mi campo
        if (codigo.length() == 13) {
            String codigoPropInicial = codigo.substring(0, 2);
            String codigoPropCodigo = codigo.substring(2, 7);
            String codigoPropPeso = codigo.substring(7, 12);
            String codigoPropValidador = codigo.substring(12, 13);

            // Verifica si es un código de barras propio
            if (codigoPropInicial.equals("25")) {
                var articuloId = Integer.parseInt(codigoPropCodigo);
                BigDecimal peso = new BigDecimal(codigoPropPeso).divide(new BigDecimal(1000), RoundingMode.HALF_UP);
                try {
                    return ArticuloStockDto.builder()
                            .articulo(articuloClient.findByArticuloId(articuloId + ""))
                            .cantidad(peso)
                            .build();
                } catch (Exception e) {
                    log.debug("Código no comienza con 25");
                }
                try {
                    return ArticuloStockDto.builder()
                            .articulo(articuloClient.findByMascaraBalanza(codigoPropCodigo))
                            .cantidad(peso)
                            .build();
                } catch (Exception e) {
                    log.debug("Código no entra por máscara de balanza");
                }
            }

            // Verifica si es un código de carnes de mi campo
            if (!(codigoPropInicial.equals("20") || codigoPropInicial.equals("23"))) {
                return ArticuloStockDto.builder()
                        .cantidad(BigDecimal.ZERO)
                        .build();
            }

            try {
                var peso = BigDecimal.ZERO;
                if (codigoPropInicial.equals("23")) {
                    peso = new BigDecimal(codigoPropPeso).divide(new BigDecimal(100), RoundingMode.HALF_UP);
                }
                if (codigoPropInicial.equals("20")) {
                    peso = new BigDecimal(codigoPropPeso).divide(new BigDecimal(1000), RoundingMode.HALF_UP);
                }
                return ArticuloStockDto.builder()
                        .articulo(articuloBarraClient.findByCodigoBarras(codigoPropCodigo).getArticulo())
                        .cantidad(peso)
                        .build();
            } catch (Exception e) {
                log.debug("Código no entra por carnes de mi campo");
            }
        }

        return ArticuloStockDto.builder()
                .cantidad(BigDecimal.ZERO)
                .build();

    }

}
