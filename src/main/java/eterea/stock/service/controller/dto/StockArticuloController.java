package eterea.stock.service.controller.dto;

import eterea.stock.service.model.dto.ArticuloStockDto;
import eterea.stock.service.service.dto.StockArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock/stockarticulo")
public class StockArticuloController {

    private final StockArticuloService service;

    public StockArticuloController(StockArticuloService service) {
        this.service = service;
    }

    @GetMapping("/getarticulo/{codigo}")
    public ResponseEntity<ArticuloStockDto> getStockArticulo(@PathVariable String codigo) {
        return ResponseEntity.ok(service.getStockArticulo(codigo));
    }

}
