package io.lenur.configuration.parser;

import java.io.File;
import java.util.Map;

public interface Parsable {
    Map<String, String> load(File file);
}
