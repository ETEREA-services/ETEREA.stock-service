package eterea.stock.service.client;

import eterea.stock.service.model.CentroStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("core-service/api/core/centrostock")
public interface CentroStockClient {

    @GetMapping("/")
    List<CentroStockDto> findAll();

}
