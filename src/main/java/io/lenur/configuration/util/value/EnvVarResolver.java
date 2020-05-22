package io.lenur.configuration.util.value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvVarResolver {
    private static final String ENV_REGEXP = "\\$\\{env:(\\w+)}";
    private static final Pattern ENV_PATTERN = Pattern.compile(ENV_REGEXP);

    public static String resolve(String value) {
        Matcher matcher = ENV_PATTERN.matcher(value);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String envName = null == matcher.group(1) ? matcher.group(2) : matcher.group(1);
            String envValue = System.getenv(envName);
            matcher.appendReplacement(sb, null == envValue ? "" : envValue);
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
