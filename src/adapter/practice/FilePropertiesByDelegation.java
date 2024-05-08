package adapter.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FilePropertiesByDelegation implements FileIO {

    private final Properties properties;

    public FilePropertiesByDelegation() {
        properties = new Properties();
        try {
            Files.write(Paths.get("file.txt"), "year=1999".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(Files.newInputStream(Paths.get(filename)));
        properties.list(System.out);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        properties.store(Files.newOutputStream(Paths.get(filename)), "delegation properties");
        properties.list(System.out);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
