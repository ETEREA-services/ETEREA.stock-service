package eterea.stock.service.controller.dto;

import eterea.stock.service.model.StockContextDto;
import eterea.stock.service.service.dto.StockContextService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock/stockcontext")
public class StockContextController {

    private final StockContextService service;

    public StockContextController(StockContextService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<StockContextDto> findContext() {
        return ResponseEntity.ok(service.findContext());
    }

}
