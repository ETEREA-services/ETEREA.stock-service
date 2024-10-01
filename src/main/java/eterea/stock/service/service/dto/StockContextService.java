package eterea.stock.service.service.dto;

import eterea.stock.service.client.CentroStockClient;
import eterea.stock.service.client.InventarioTurnoClient;
import eterea.stock.service.model.StockContextDto;
import org.springframework.stereotype.Service;

@Service
public class StockContextService {

    private final InventarioTurnoClient inventarioTurnoClient;
    private final CentroStockClient centroStockClient;

    public StockContextService(InventarioTurnoClient inventarioTurnoClient, CentroStockClient centroStockClient) {
        this.inventarioTurnoClient = inventarioTurnoClient;
        this.centroStockClient = centroStockClient;
    }

    public StockContextDto findContext() {
        return StockContextDto.builder()
                .centroStocks(centroStockClient.findAll())
                .inventarioTurnos(inventarioTurnoClient.findAll())
                .build();
    }

}
