package eterea.stock.service.client;

import eterea.stock.service.model.ArticuloDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "core-service/api/core/articulo")
public interface ArticuloClient {

    @GetMapping("/")
    List<ArticuloDto> findAll();

    @GetMapping("/search/{chain}")
    List<ArticuloDto> findAllBySearch(@PathVariable String chain);

    @GetMapping("/{articuloId}")
    ArticuloDto findByArticuloId(@PathVariable String articuloId);

    @GetMapping("/autonumerico/{autonumerico}")
    ArticuloDto findByAutonumerico(@PathVariable Long autonumerico);

    @GetMapping("/mascaraBalanza/{mascaraBalanza}")
    ArticuloDto findByMascaraBalanza(@PathVariable String mascaraBalanza);

}