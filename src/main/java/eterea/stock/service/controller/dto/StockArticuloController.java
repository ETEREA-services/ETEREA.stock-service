package eterea.stock.service.controller.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import eterea.stock.service.model.dto.ArticuloStockDto;
import eterea.stock.service.service.dto.StockArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/stock/stockarticulo")
@Slf4j
public class StockArticuloController {

    private final StockArticuloService service;

    public StockArticuloController(StockArticuloService service) {
        this.service = service;
    }

    @GetMapping("/getarticulo/{codigo}/{fecha}")
    public ResponseEntity<ArticuloStockDto> getStockArticulo(@PathVariable String codigo,
                                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fecha) {
        var stockArticulo = service.getStockArticulo(codigo, fecha);
        try {
            log.debug("StockArticulo -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(stockArticulo));
        } catch (JsonProcessingException e) {
            log.debug("StockArticulo error -> {}", e.getMessage());
        }
        return ResponseEntity.ok(stockArticulo);
    }

}
