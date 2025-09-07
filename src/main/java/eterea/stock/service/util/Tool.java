package eterea.stock.service.util;

import eterea.stock.service.util.transfer.FileInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

@Slf4j
public class Tool {

    public static File writeFile(FileInfo fileinfo) {
        log.debug("Processing Tool.writeFile");
        // Reescribe archivo
        String filename = fileinfo.getFilename();
        filename = filename.replace('\\', '/');
        filename = filename.substring(filename.lastIndexOf('/') + 1);
        log.debug("Filename -> " + filename);
        File file = new File(filename);
        byte[] bytes = Base64.getDecoder().decode(fileinfo.getBase64());
        try {
            OutputStream output = new FileOutputStream(file);
            output.write(bytes);
            output.close();
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
        return file;
    }

}
