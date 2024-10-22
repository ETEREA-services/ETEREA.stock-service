package eterea.stock.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class StockMovimientoDto {

    private Long stockMovimientoId;
    private Integer comprobanteId;
    private Long numeroComprobanteInterno = 0L;
    private Integer negocioId;
    private Integer negocioIdDesde;
    private Integer centroStockIdDesde;
    private Integer negocioIdHasta;
    private Integer centroStockIdHasta;
    private String centroStockIdHastaNombre = "";
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaRegistro;
    private Long proveedorId;
    private Long clienteId;
    private Long legajo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaComprobante;
    private Integer comprobanteIdFactura;
    private Integer prefijoFactura;
    private Long numeroComprobanteFactura;
    private BigDecimal importe = BigDecimal.ZERO;
    private String letraComanda;
    private String observaciones;
    private Long cierreCajaId;
    private Long cierreRestaurantId;
    private Integer nivel = 0;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaContable;
    private Integer ordenContable;
    private Integer negocioIdOtro;
    private Byte generacionAutomatica = 0;
    private Byte pendiente = 0;
    private Byte rechazada = 0;
    private Byte facturaProveedor = 0;
    private BigDecimal netoFactura = BigDecimal.ZERO;
    private BigDecimal netoRegistrado = BigDecimal.ZERO;

}
