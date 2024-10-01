package eterea.stock.service.service.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import eterea.stock.service.client.InventarioClient;
import eterea.stock.service.model.InventarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ControlInventarioService {

    private final InventarioClient inventarioClient;

    public ControlInventarioService(InventarioClient inventarioClient) {
        this.inventarioClient = inventarioClient;
    }

    public List<InventarioDto> addControlInventario(List<InventarioDto> inventarios) {
        try {
            log.debug("Inventarios -> {}", JsonMapper.builder().findAndAddModules().build().writerWithDefaultPrettyPrinter().writeValueAsString(inventarios));
        } catch (JsonProcessingException e) {
            log.debug("Inventarios error -> {}", e.getMessage());
        }
        return inventarioClient.addAll(inventarios);
    }

}
