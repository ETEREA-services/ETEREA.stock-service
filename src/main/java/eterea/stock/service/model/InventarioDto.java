package eterea.stock.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class InventarioDto {

    private Long inventarioId = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fecha = null;

    private Integer inventarioTurnoId = null;
    private Integer centroStockId = null;
    private String articuloId = null;
    private BigDecimal cantidad = BigDecimal.ZERO;
    private BigDecimal stock = BigDecimal.ZERO;

    private InventarioTurnoDto inventarioTurno = null;
    private CentroStockDto centroStock = null;
    private ArticuloDto articulo = null;

}
