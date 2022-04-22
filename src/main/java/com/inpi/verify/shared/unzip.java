package com.inpi.verify.shared;

import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class unzip {

    public static void unzipFile(String numeroRevista) throws IOException {

         final String UNZIPLOCATION = "target";

        String zipFilePath = "target\\" + numeroRevista + ".zip";


        if (!Files.exists(Paths.get(UNZIPLOCATION))) {
            Files.createDirectories(Paths.get(UNZIPLOCATION));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            if (Objects.nonNull(zipEntry)) {
                Path filePath = Paths.get(UNZIPLOCATION, numeroRevista + ".xml");

                if (!zipEntry.isDirectory()) {
                    unzipFiles(zipInputStream, filePath);
                } else {
                    Files.createDirectories(filePath);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private static void unzipFiles(ZipInputStream zipInputStream, Path filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath.toAbsolutePath().toString()))) {
            byte[] bytesIn = new byte[1024];
            int read = 0;
            while ((read = zipInputStream.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }


}
