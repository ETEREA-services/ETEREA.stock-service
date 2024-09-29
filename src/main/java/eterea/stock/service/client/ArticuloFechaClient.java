package eterea.stock.service.client;

import eterea.stock.service.model.ArticuloFechaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@FeignClient(name = "core-service/api/core/articulofecha")
public interface ArticuloFechaClient {

    @GetMapping("/unique/{articuloId}/{fecha}")
    ArticuloFechaDto getByUnique(@PathVariable String articuloId,
                                 @PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) OffsetDateTime fecha);

    @PostMapping("/")
    ArticuloFechaDto add(@RequestBody ArticuloFechaDto articulofecha);

    @PutMapping("/{articuloFechaId}")
    ArticuloFechaDto update(@RequestBody ArticuloFechaDto articulofecha,
                         @PathVariable Long articuloFechaId);
}