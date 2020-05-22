package io.lenur.configuration.parser;

import io.lenur.configuration.util.value.ValueResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropertiesParser implements Parsable {
    @Override
    public Map<String, String> load(File file) {
        if (file == null) {
            return null;
        }

        final Map<String, String> properties = new HashMap<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplitted = line.split("=");
                String key = lineSplitted[0];
                String value = line.replace(lineSplitted[0] + "=", "");
                properties.put(key, ValueResolver.parse(value));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return properties;
    }
}
