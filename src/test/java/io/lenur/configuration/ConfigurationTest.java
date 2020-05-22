package io.lenur.configuration;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

    @Test(expected = IllegalArgumentException.class)
    public void initWrongConfiguration() {
        new Configuration("application");
    }

    @Test
    public void initConfiguration() {
        Configuration configuration = new Configuration("application.properties");
        Assert.assertEquals("com.mysql.cj.jdbc.Driver", configuration.get("database.driver-class-name"));
        Assert.assertEquals("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC",
                configuration.get("database.url"));
        Assert.assertEquals("test", configuration.get("database.username"));
        Assert.assertEquals("test", configuration.get("database.password"));
    }
}
