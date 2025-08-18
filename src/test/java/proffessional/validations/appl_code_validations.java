package proffessional.validations;

import org.testng.Assert;

public class appl_code_validations {
    public static void validateEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateContains(String actual, String expectedPart, String message) {
        Assert.assertTrue(actual != null && actual.contains(expectedPart), message + " | Actual: " + actual);
    }
}
