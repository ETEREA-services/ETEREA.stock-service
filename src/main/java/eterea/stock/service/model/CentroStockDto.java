package eterea.stock.service.model;

import lombok.Data;

@Data
public class CentroStockDto {

    private Integer centroStockId;
    private String descripcion;
    private Integer negocioId;
    private Long numeroCuenta;
    private Byte controlaStock;
    private Integer tipo;

}
