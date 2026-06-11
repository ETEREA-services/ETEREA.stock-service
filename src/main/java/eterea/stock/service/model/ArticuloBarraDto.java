package eterea.stock.service.model;

import eterea.stock.service.util.Jsonifier;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloBarraDto {

    private Long articuloBarraId = null;
    private String codigoBarras = null;
    private String articuloId = null;
    private ArticuloDto articulo = null;

    public String jsonify() {
        return Jsonifier.builder(this).build();
    }
}
