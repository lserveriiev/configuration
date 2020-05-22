package io.lenur.configuration.util.value;

import org.junit.Assert;
import org.junit.Test;

public class EnvVarResolverTest {
    private static final String TEXT_WITHOUT_WILDCARD = "text to parse";
    private static final String TEXT_WITH_WILDCARD = "text${env:CONF_TEST_ENV_RESOLVER}to${env:CONF_TEST_ENV_RESOLVER}parse";

    @Test
    public void parseNull() {
        Assert.assertNull(ValueResolver.parse(null));
    }

    @Test
    public void parseString() {
        String resolved = ValueResolver.parse(TEXT_WITHOUT_WILDCARD);
        Assert.assertEquals(TEXT_WITHOUT_WILDCARD, resolved);
    }

    @Test
    public void parseStringWithWildcard() {
        String resolved = ValueResolver.parse(TEXT_WITH_WILDCARD);
        Assert.assertEquals("text_to_parse", resolved);
    }
}
