package io.lenur.configuration.parser;

import io.lenur.configuration.util.FileLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class PropertiesParserTest {
    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void loadNull() {
        PropertiesParser propertiesParser = new PropertiesParser();
        Map<String, String> properties = propertiesParser.load(null);

        Assert.assertNull(properties);
    }

    @Test
    public void loadProperties() {
        File file = fileLoader.getFileFromResources("application.properties");
        Assert.assertNotNull(file);

        PropertiesParser propertiesParser = new PropertiesParser();
        Map<String, String> properties = propertiesParser.load(file);

        Assert.assertEquals("com.mysql.cj.jdbc.Driver", properties.get("database.driver-class-name"));
        Assert.assertEquals("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC",
                properties.get("database.url"));
        Assert.assertEquals("test", properties.get("database.username"));
        Assert.assertEquals("test", properties.get("database.password"));
    }
}
