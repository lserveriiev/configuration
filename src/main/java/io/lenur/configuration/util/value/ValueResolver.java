package io.lenur.configuration.util.value;

public class ValueResolver {
    private static final String ENV_WILDCARD = "${env";

    public static String parse(String value) {
        if (value == null) {
            return null;
        }

        if (value.contains(ENV_WILDCARD)) {
            value = EnvVarResolver.resolve(value);
        }

        return value;
    }
}
