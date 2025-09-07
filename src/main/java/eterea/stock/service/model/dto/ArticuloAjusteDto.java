package eterea.stock.service.model.dto;

import eterea.stock.service.util.Jsonifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloAjusteDto {

    private String articuloId;
    private String descripcion;
    private BigDecimal inventario;
    private BigDecimal stock;
    private BigDecimal diferencia;

    public String jsonify() {
        return Jsonifier.builder(this).build();
    }

}
