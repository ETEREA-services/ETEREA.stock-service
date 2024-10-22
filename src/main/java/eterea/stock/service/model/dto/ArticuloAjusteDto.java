package eterea.stock.service.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticuloAjusteDto {

    private String articuloId;
    private String descripcion;
    private BigDecimal inventario;
    private BigDecimal stock;
    private BigDecimal diferencia;

}
