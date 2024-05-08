package adapter.practice;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FilePropertiesByInheritance extends Properties implements FileIO {

    public FilePropertiesByInheritance() {
        try {
//            Files.write(Paths.get("file.txt"), "year=2000".getBytes());
            Files.write(this.getResourcePath().resolve("file.txt"), "year=2000".getBytes());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile(String filename) throws IOException {
//        super.load(Files.newBufferedReader(Paths.get("file.txt")));
        try {
            super.load(Files.newBufferedReader(this.getResourcePath(filename)));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        super.list(System.out);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
//        super.store(Files.newBufferedWriter(Paths.get("newfile.txt")), "inheritance properties");
        try {
            super.store(Files.newBufferedWriter(this.getResourcePath().resolve(filename)), "inheritance properties");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        super.list(System.out);
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return super.getProperty(key);
    }
}
