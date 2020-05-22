package io.lenur.configuration.util;

import java.io.File;
import java.net.URL;

public class FileLoader {
    public File getFileFromResources(final String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            String msg = String.format("File name %s is not found!", fileName);
            throw new IllegalArgumentException(msg);
        }

        return new File(resource.getFile());
    }
}
