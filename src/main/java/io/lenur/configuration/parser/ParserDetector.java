package io.lenur.configuration.parser;

import io.lenur.configuration.util.FileUtil;

import java.io.File;
import java.util.Objects;

public class ParserDetector {
    private static final String PROPERTIES_EXT = "properties";

    public static Parsable detect(File file) {
        String extension = FileUtil.getFileExtension(file);

        if (!Objects.equals(extension, PROPERTIES_EXT)) {
            String msg = String.format("The file %s doesn't support!", file.getName());
            throw new IllegalArgumentException(msg);
        }

        return new PropertiesParser();
    }
}
