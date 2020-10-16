package com.gautam.utils;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.gautam.utils.DriverUtils.getDriver;


public class AssertionUtils {
    static final Logger logger = Logger.getLogger(AssertionUtils.class);

    public static void assertPresent(WebElement element) {
        waitForVisible(element);
        Assert.assertTrue(String.format("Element %s should be displayed !!!", element.getText()), element.isDisplayed());
    }

    private static void waitForVisible(WebElement element) {
        WebElementUtils.waitForVisible(element);
    }

    public static void assertEquals(WebElement element, String actual, String expected) {
        waitForVisible(element);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", actual, expected), actual.contains(expected));
    }

    public static void assertEquals(WebElement element, String expected) {
        waitForVisible(element);
        logger.info("WebElement: Actual text is " + element.getText() + " and expected text is " + expected);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", element.getText(), expected), element.getText().contains(expected));
    }

    public static void assertPageTitle(String expected) {
        String actualTitle = getDriver().getTitle();
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", actualTitle, expected), actualTitle.contains(expected));
    }

    public static void assertEquals(String actual, String expected) {
        logger.info("Actual text is " + actual + " and expected text is " + expected);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", actual, expected), actual.equals(expected));
    }

    public static void assertTrue(String actual, String expected) {
        logger.info("Actual text is " + actual + " and expected text is " + expected);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", actual, expected),actual.contains(expected));
    }
    public static void assertEquals(int actual, int expected) {
        logger.info("Actual text is " + actual + " and expected text is " + expected);
        Assert.assertEquals(actual,expected);
    }
}
