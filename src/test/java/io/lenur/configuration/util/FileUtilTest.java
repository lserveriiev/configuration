package io.lenur.configuration.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class FileUtilTest {
    @Test
    public void getFileExtension() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("application.properties");
        Assert.assertNotNull(resource);

        File file = new File(resource.getFile());
        String extension = FileUtil.getFileExtension(file);
        Assert.assertEquals(extension, "properties");
    }

    @Test
    public void getFileWithNoExtension() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("application");
        Assert.assertNotNull(resource);

        File file = new File(resource.getFile());
        String extension = FileUtil.getFileExtension(file);
        Assert.assertTrue(extension.isEmpty());
    }
}
