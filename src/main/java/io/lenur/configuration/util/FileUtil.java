package io.lenur.configuration.util;

import java.io.File;

public class FileUtil {
    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }

        return name.substring(lastIndexOf + 1);
    }
}
