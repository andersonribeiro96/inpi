package com.inpi.verify.shared;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class download {
    public static void dowloadFile(String numeroRevista) throws IOException {

        URL url = new URL("http://revistas.inpi.gov.br/txt/RM" + numeroRevista + ".zip");
        File file = new File("target\\" + numeroRevista + ".zip");
        FileUtils.copyURLToFile(url, file);
    }

}
