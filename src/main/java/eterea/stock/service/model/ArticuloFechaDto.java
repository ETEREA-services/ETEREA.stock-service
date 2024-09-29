package eterea.stock.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ArticuloFechaDto {

    private Long articuloFechaId;
    private String articuloId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private String fecha;
    private BigDecimal precioUsd;
    private BigDecimal precioArs;

}
