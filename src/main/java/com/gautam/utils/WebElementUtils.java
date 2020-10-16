package com.gautam.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.gautam.utils.DriverUtils.getDriver;


public class WebElementUtils {
    static Long timeout = Long.parseLong("25");
    static WebDriverWait wait = new WebDriverWait(getDriver(), timeout);

    public static void waitForVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForNotVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeSelected(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebElement createDynamicLocator(String xpath,String formatingString) {
        WebElement element = getDriver().findElement(By.xpath(String.format(xpath,formatingString)));
        waitForVisible(element);
        return element;
    }

    public static void hardWait(int mlsec) {
        try {
            Thread.sleep(mlsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
