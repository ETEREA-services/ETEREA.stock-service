package eterea.stock.service.controller;

import eterea.stock.service.client.InventarioTurnoClient;
import eterea.stock.service.model.InventarioTurnoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock/inventarioturno")
public class InventarioTurnoController {

    private final InventarioTurnoClient client;

    public InventarioTurnoController(InventarioTurnoClient client) {
        this.client = client;
    }

    @GetMapping("/")
    public ResponseEntity<List<InventarioTurnoDto>> findAll() {
        return new ResponseEntity<>(client.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{inventarioTurnoId}")
    public ResponseEntity<InventarioTurnoDto> findByInventarioTurnoId(@PathVariable Integer inventarioTurnoId) {
        return new ResponseEntity<>(client.findByInventarioTurnoId(inventarioTurnoId), HttpStatus.OK);
    }

    @GetMapping("/last")
    public ResponseEntity<InventarioTurnoDto> findLast() {
        return new ResponseEntity<>(client.findLast(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<InventarioTurnoDto> create(@RequestBody InventarioTurnoDto inventarioTurno) {
        return new ResponseEntity<>(client.create(inventarioTurno), HttpStatus.CREATED);
    }

    @PutMapping("/{inventarioTurnoId}")
    public ResponseEntity<InventarioTurnoDto> update(@PathVariable Integer inventarioTurnoId, @RequestBody InventarioTurnoDto inventarioTurno) {
        return new ResponseEntity<>(client.update(inventarioTurnoId, inventarioTurno), HttpStatus.OK);
    }

}
