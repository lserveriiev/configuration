package io.lenur.configuration;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ConfigurationTest {
    private static final Configuration configuration = new Configuration("application.properties");

    @Test(expected = IllegalArgumentException.class)
    public void initWrongConfiguration() {
        new Configuration("application");
    }

    @Test
    public void initConfiguration() {
        Assert.assertEquals("com.mysql.cj.jdbc.Driver", configuration.get("database.driver-class-name"));
        Assert.assertEquals("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC",
                configuration.get("database.url"));
        Assert.assertEquals("test", configuration.get("database.username"));
        Assert.assertEquals("test", configuration.get("database.password"));
    }

    @Test
    public void getConfiguration() {
        Assert.assertEquals("JAVA|SPRING|HIBERNATE", configuration.get("technology.stack"));
    }

    @Test
    public void getConfigurationAsArray() {
        String[] values = configuration.getAsStringArray("technology.stack");
        Assert.assertEquals(3, values.length);

        List<String> stacks = Arrays.asList(values);
        Assert.assertTrue(stacks.contains("JAVA"));
        Assert.assertTrue(stacks.contains("SPRING"));
        Assert.assertTrue(stacks.contains("HIBERNATE"));
    }

    @Test
    public void getConfigurationAsArrayWithRegex() {
        String[] values = configuration.getAsStringArray("technology.stack.regex", ",");
        Assert.assertEquals(3, values.length);

        List<String> stacks = Arrays.asList(values);
        Assert.assertTrue(stacks.contains("JAVA"));
        Assert.assertTrue(stacks.contains("SPRING"));
        Assert.assertTrue(stacks.contains("HIBERNATE"));
    }
}
