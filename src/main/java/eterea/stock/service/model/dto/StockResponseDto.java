package eterea.stock.service.model.dto;

import eterea.stock.service.model.StockMovimientoDto;
import eterea.stock.service.util.Jsonifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockResponseDto {

    private StockMovimientoDto stockMovimiento;
    private String response;

    public String jsonify() {
        return Jsonifier.builder(this).build();
    }

}
