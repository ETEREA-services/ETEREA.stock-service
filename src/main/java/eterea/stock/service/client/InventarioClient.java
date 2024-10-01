package eterea.stock.service.client;

import eterea.stock.service.model.InventarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("core-service/api/core/inventario")
public interface InventarioClient {

    @PostMapping("/all")
    List<InventarioDto> addAll(List<InventarioDto> inventarios);

}
