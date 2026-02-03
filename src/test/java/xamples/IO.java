package xamples;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class IO {
    @Test
    public void test() throws Exception {
        Properties prop = PropertiesLoader.loadProperties("prop.properties");

        Path baseDir = Paths.get(
                System.getProperty("user.dir"),
                prop.getProperty("project.resources")
        );

        Path outputFile = baseDir.resolve("File.doc");
        System.out.println("Output file: " + outputFile);
        File file = new File(outputFile.toString());
        String text = "666";
        if (!file.exists()) {
            try (OutputStream os = Files.newOutputStream(outputFile, StandardOpenOption.CREATE_NEW)) {
                os.write(text.getBytes(StandardCharsets.UTF_8)); // щоб файл реально створився

            }
        }

        System.out.println(file.getName());
//        Files.delete(outputFile);

    }
}
