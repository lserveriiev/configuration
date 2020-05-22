package io.lenur.configuration.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileLoaderTest {
    private final FileLoader fileLoader = new FileLoader();

    @Test
    public void loadFile() {
        File file = fileLoader.getFileFromResources("application.properties");
        Assert.assertNotNull(file);
        Assert.assertEquals("application.properties", file.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void loadWrongFile() {
        File file = fileLoader.getFileFromResources("application123");
    }
}
