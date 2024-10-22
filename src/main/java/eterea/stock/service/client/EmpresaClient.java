package eterea.stock.service.client;

import eterea.stock.service.model.EmpresaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "core-service/api/core/empresa")
public interface EmpresaClient {

    @GetMapping("/top")
    EmpresaDto findTop();

}
