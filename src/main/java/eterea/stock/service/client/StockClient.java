package eterea.stock.service.client;

import eterea.stock.service.model.dto.StockAndArticulosDto;
import eterea.stock.service.model.StockMovimientoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "core-service/api/core/stock")
public interface StockClient {

    @PostMapping("/add/movimiento")
    StockMovimientoDto addMovimiento(StockAndArticulosDto stockAndArticulos);

}
