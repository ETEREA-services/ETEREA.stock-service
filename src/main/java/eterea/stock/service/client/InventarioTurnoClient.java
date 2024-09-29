package eterea.stock.service.client;

import eterea.stock.service.model.InventarioTurnoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "core-service/api/core/inventarioturno")
public interface InventarioTurnoClient {

    @GetMapping("/")
    List<InventarioTurnoDto> findAll();

    @GetMapping("/{inventarioTurnoId}")
    InventarioTurnoDto findByInventarioTurnoId(@PathVariable Integer inventarioTurnoId);

    @GetMapping("/last")
    InventarioTurnoDto findLast();

    @PostMapping("/")
    InventarioTurnoDto create(@RequestBody InventarioTurnoDto inventarioTurno);

    @PutMapping("/{inventarioTurnoId}")
    InventarioTurnoDto update(@PathVariable Integer inventarioTurnoId, @RequestBody InventarioTurnoDto inventarioTurno);

}
