package eterea.stock.service.util.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo implements Serializable {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 203015754036659479L;

    private String filename;
    private String observaciones;
    private String base64;

}