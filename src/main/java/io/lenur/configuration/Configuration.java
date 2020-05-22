package io.lenur.configuration;

import io.lenur.configuration.parser.Parsable;
import io.lenur.configuration.parser.ParserDetector;
import io.lenur.configuration.util.FileLoader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private static final Map<String, Map<String, String>> properties = new HashMap<>();
    private final String fileName;

    public Configuration(String fileName) {
        this.fileName = fileName;

        if (!properties.containsKey(fileName)) {
            init();
        }
    }

    public String get(String key) {
        Map<String, String> fileConfig = properties.get(fileName);

        return fileConfig.get(key);
    }

    private void init() {
        FileLoader loader = new FileLoader();
        File file = loader.getFileFromResources(fileName);
        Parsable parser = ParserDetector.detect(file);
        properties.put(fileName, parser.load(file));
    }
}
