package resources;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/java/resources/global.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getValue(String key){
        String prop = properties.getProperty(key);
        if(prop != null) return prop;
        else throw new RuntimeException("property value is not specified in the global.properties file");
    }



}