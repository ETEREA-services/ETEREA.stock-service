package eterea.stock.service.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import eterea.stock.service.model.ArticuloDto;
import eterea.stock.service.util.Jsonifier;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloStockDto {

    private ArticuloDto articulo = null;
    private BigDecimal cantidad = BigDecimal.ZERO;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
    private OffsetDateTime fecha = null;
    private BigDecimal precio = BigDecimal.ZERO;

    public String jsonify() {
        return Jsonifier.builder(this).build();
    }
}
