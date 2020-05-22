package io.lenur.configuration.parser;

import io.lenur.configuration.util.FileLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ParserDetectorTest {
    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void detectParser() {
        File file = fileLoader.getFileFromResources("application.properties");
        Assert.assertNotNull(file);

        Parsable parser = ParserDetector.detect(file);

        Assert.assertNotNull(parser);
        Assert.assertEquals(PropertiesParser.class, parser.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void detectWrongParser() {
        File file = fileLoader.getFileFromResources("application");
        Assert.assertNotNull(file);

        ParserDetector.detect(file);
    }
}
