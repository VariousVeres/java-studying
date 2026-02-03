package xamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

public class PropertiesLoader {

    private static final Properties prop = new Properties();



    public static Properties loadProperties(String properties) {

        try (InputStream is = new FileInputStream(properties)) {
            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
