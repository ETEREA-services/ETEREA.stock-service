package eterea.stock.service.model;

import lombok.Data;

@Data
public class ArticuloBarraDto {

    private Long articuloBarraId = null;
    private String codigoBarras = null;
    private String articuloId = null;
    private ArticuloDto articulo = null;

}
