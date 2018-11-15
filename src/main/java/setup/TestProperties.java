package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    String currentPropertyFile;
    Properties currentProperties = new Properties();

    protected void setPropertyFile(PropertyFile propertyFile) {
        currentPropertyFile = propertyFile.getName();
    }

    /**
     * Read set of properties
     *
     * @return
     * @throws IOException
     */
    Properties getCurrentProperties() throws IOException {
        FileInputStream in = new FileInputStream(currentPropertyFile);
        currentProperties.load(in);
        in.close();
        return currentProperties;
    }

    /**
     * Return certain property value by key
     *
     * @param propertyKey
     * @return
     * @throws IOException
     */
    protected String getProperty(String propertyKey) throws IOException {
        if (!currentProperties.containsKey(propertyKey)) {
            currentProperties = getCurrentProperties();
        }
        return currentProperties.getProperty(propertyKey, null);
    }
}
