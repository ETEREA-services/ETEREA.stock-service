package eterea.stock.service.model.dto;

import eterea.stock.service.model.StockMovimientoDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockResponseDto {

    private StockMovimientoDto stockMovimiento;
    private String response;

}
