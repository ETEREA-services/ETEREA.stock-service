package eterea.stock.service.client;

import eterea.stock.service.model.ArticuloBarraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core-service/api/core/articulobarra")
public interface ArticuloBarraClient {

    @GetMapping("/{codigobarras}")
    ArticuloBarraDto findByCodigoBarras(@PathVariable String codigobarras);

}
