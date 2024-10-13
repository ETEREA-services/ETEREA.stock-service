package eterea.stock.service.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import eterea.stock.service.model.ArticuloDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class ArticuloStockDto {

    private ArticuloDto articulo = null;
    private BigDecimal cantidad = BigDecimal.ZERO;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fecha = null;
    private BigDecimal precio = BigDecimal.ZERO;

}
