package pac1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lab12_toloadProperties {
    Properties prop;

    public Lab12_toloadProperties(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
    	return prop.getProperty(key);
    }
    }
    
