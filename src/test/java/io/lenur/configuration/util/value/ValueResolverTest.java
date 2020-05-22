package io.lenur.configuration.util.value;

import org.junit.Assert;
import org.junit.Test;

public class ValueResolverTest {
    private static final String TEXT_WITHOUT_WILDCARD = "text to resolve";
    private static final String TEXT_WITH_WILDCARD = "text${env:CONF_TEST_ENV_RESOLVER}to${env:CONF_TEST_ENV_RESOLVER}resolve";

    @Test
    public void resolveString() {
        String resolved = EnvVarResolver.resolve(TEXT_WITHOUT_WILDCARD);
        Assert.assertEquals(TEXT_WITHOUT_WILDCARD, resolved);
    }

    @Test
    public void resolveStringWithWild() {
        String resolved = EnvVarResolver.resolve(TEXT_WITH_WILDCARD);
        Assert.assertEquals("text_to_resolve", resolved);
    }
}
