package eterea.stock.service.model.dto;

import eterea.stock.service.util.Jsonifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RubroDto {

    private String nombre;
    private List<ArticuloAjusteDto> articulos;

    public String jsonify() {
        return Jsonifier.builder(this).build();
    }

}
