package eterea.stock.service.model.dto;

import eterea.stock.service.model.ArticuloMovimientoDto;
import eterea.stock.service.model.StockMovimientoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockAndArticulosDto {

    private StockMovimientoDto stockMovimiento;
    private List<ArticuloMovimientoDto> articuloMovimientos;

}
