package eterea.stock.service.controller.facade;

import eterea.stock.service.model.dto.StockResponseDto;
import eterea.stock.service.service.facade.AjustesService;
import eterea.stock.service.util.transfer.FileInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/stock/ajustes")
public class AjustesController {

    private final AjustesService service;

    public AjustesController(AjustesService service) {
        this.service = service;
    }

    @PostMapping("/upload/{centroStockId}/{comprobanteId}/{fechaRegistro}")
    public ResponseEntity<StockResponseDto> upload(@RequestBody FileInfo fileInfo,
                                                   @PathVariable Integer centroStockId,
                                                   @PathVariable Integer comprobanteId,
                                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fechaRegistro) {
        try {
            return new ResponseEntity<>(service.upload(fileInfo, centroStockId, comprobanteId, fechaRegistro), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
