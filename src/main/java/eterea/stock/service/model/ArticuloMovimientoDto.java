package eterea.stock.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class ArticuloMovimientoDto {

    private Long articuloMovimientoId;
    private Long clienteMovimientoId;
    private Long stockMovimientoId = 0L;
    private Long tenenciaMovimientoId = 0L;
    private Integer centroStockId;
    private Integer comprobanteId;
    private Integer item = 0;
    private String articuloId;
    private Integer negocioId;
    private BigDecimal cantidad = BigDecimal.ZERO;
    private BigDecimal precioUnitario = BigDecimal.ZERO;
    private BigDecimal precioUnitarioSinIva = BigDecimal.ZERO;
    private BigDecimal precioUnitarioConIva = BigDecimal.ZERO;
    private Long numeroCuenta;
    private Byte iva105 = 0;
    private Byte exento = 0;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaMovimiento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaFactura;
    private Integer nivel = 0;
    private Long cierreCajaId = 0L;
    private Long cierreRestaurantId = 0L;
    private BigDecimal precioCompra = BigDecimal.ZERO;
    private BigDecimal precioValuacion = BigDecimal.ZERO;
    private Long mozoId = 0L;
    private BigDecimal comision = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private ArticuloDto articulo = null;

}
