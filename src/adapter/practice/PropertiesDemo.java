package adapter.practice;

import com.sun.webkit.network.URLs;
import interator.practice.phone.Person;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesDemo {

    protected static final String PROP_NAME = "config.properties";
    protected static final Logger log = Logger.getGlobal();

    @Test
    public void prepareConfigFile() throws URISyntaxException, IOException {
        Class<? extends PropertiesDemo> clazz = this.getClass();
        URL configFile = clazz.getResource(PROP_NAME);
        if(configFile == null) {
            Path configPath = Paths.get(clazz.getResource("").toURI()).resolve(PROP_NAME);
            Files.createFile(configPath);
            log.info("A new config.properties created.");
        } else {
            log.info("config.properties already exists.");
        }
    }

    @Test
    public void readWriteProperties() throws IOException, URISyntaxException {
        Class<? extends PropertiesDemo> clazz = this.getClass();
        Properties properties = new Properties();
//        properties.load(new FileInputStream(clazz.getResource(PROP_NAME).toURI().getPath()));
        properties.load(clazz.getResourceAsStream(PROP_NAME));
        properties.list(System.out);
        properties.setProperty("newKey", "newValue");
//        properties.store(new FileOutputStream(clazz.getResource(PROP_NAME).toURI().getPath()), "test store");
        properties.store(new FileOutputStream(clazz.getResource(PROP_NAME).toURI().getPath()), "test store");
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Properties properties = new Properties();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String classPath = PropertiesDemo.class.getResource("/").getPath(); //getClassLoader().getResource("").toURI().getPath();

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println(rootPath);
        System.out.println(classPath);

       /* new FileInputStream(classPath + "config.properties");

        File file = new File(rootPath + "config.properties");
        if (!file.exists()) {
            file.createNewFile();
        }*/
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.getPath());

        /*try (OutputStream output = new FileOutputStream("config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "mkyong");
            prop.setProperty("db.password", "password");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }*/
    }
}
