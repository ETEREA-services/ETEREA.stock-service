package eterea.stock.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StockContextDto {

    private List<CentroStockDto> centroStocks;
    private List<InventarioTurnoDto> inventarioTurnos;

}
