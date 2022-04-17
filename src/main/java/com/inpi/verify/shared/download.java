package com.inpi.verify.shared;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class download {
    public static void dowloadFile(String numeroRevista) throws IOException {

        URL url = new URL("http://revistas.inpi.gov.br/txt/RM" + numeroRevista + ".zip");
        File file = new File("C:\\Users\\ander\\Desktop\\" + numeroRevista + ".zip");

        FileUtils.copyURLToFile(url, file);
    }

}
