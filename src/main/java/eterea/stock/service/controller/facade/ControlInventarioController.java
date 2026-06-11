package eterea.stock.service.controller.facade;

import eterea.stock.service.model.InventarioDto;
import eterea.stock.service.service.facade.ControlInventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock/controlinventario")
@RequiredArgsConstructor
public class ControlInventarioController {

    private final ControlInventarioService service;

    @PostMapping("/add")
    public ResponseEntity<List<InventarioDto>> addControlInventario(@RequestBody List<InventarioDto> inventarios) {
        return ResponseEntity.ok(service.addControlInventario(inventarios));
    }

}
