package eterea.stock.service.model.dto;

import eterea.stock.service.model.ArticuloMovimientoDto;
import eterea.stock.service.model.StockMovimientoDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StockAndArticulosDto {

    private StockMovimientoDto stockMovimiento;
    private List<ArticuloMovimientoDto> articuloMovimientos;

}
