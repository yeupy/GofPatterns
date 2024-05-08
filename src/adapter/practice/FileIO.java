package adapter.practice;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileIO {
    void readFromFile(String filename) throws IOException;
    void writeToFile(String filename) throws IOException;
    void setValue(String key, String value);
    String getValue(String key);

    default Path getResourcePath() throws URISyntaxException {
        return Paths.get(this.getClass().getResource("").toURI());
    }

    default Path getResourcePath(String filename) throws URISyntaxException {
        return Paths.get(this.getClass().getResource(filename).toURI());
    }
}
