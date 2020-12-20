package com.codingchili;

import com.codingchili.Model.DataTypes;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Tests for the string-based data-type detection.
 */
public class TestDataType {

    @Test
    public void parseBoolean() {
        Assert.assertFalse(TestDataType.<Boolean>bytes("false"));
        Assert.assertTrue(TestDataType.<Boolean>bytes("true"));
    }

    @Test
    public void parseLong() {
        Assert.assertEquals(TestDataType.<Long>bytes("3000"), Long.valueOf(3000L));
    }

    @Test
    public void parseFloat() {
        Assert.assertEquals(TestDataType.<Double>bytes("1.57"), Double.valueOf(1.57));
    }

    @Test
    public void parseString() {
        Assert.assertEquals(TestDataType.<String>bytes("meow"), "meow");
    }

    @SuppressWarnings("unchecked")
    private static <T> T bytes(String string) {
        return (T) DataTypes.parseBytes(string.getBytes(StandardCharsets.UTF_8));
    }
}
