package eterea.stock.service.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RubroDto {

    private String nombre;
    private List<ArticuloAjusteDto> articulos;

}
