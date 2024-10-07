package eterea.stock.service.model.dto;

import eterea.stock.service.model.ArticuloDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticuloStockDto {

    private ArticuloDto articulo = null;
    private BigDecimal cantidad = BigDecimal.ZERO;

}
