package com.gautam.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import static com.gautam.utils.DriverUtils.getDriver;
import static com.gautam.utils.WebElementUtils.hardWait;
import static com.gautam.utils.WebElementUtils.waitForVisible;

public class CommonUtils {
    static final Logger logger = Logger.getLogger(CommonUtils.class);

    public static void clickOnElement(WebElement element) {
        logger.info("Clicking on element - " + element);
        scrollToElement(element);
        waitForVisible(element);
        element.click();
        hardWait(1000);
//        waitForPageLoad();
    }

    public static void sendKeysTo(WebElement element, String text){
        logger.info("Setting text to element - " + element);
        waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String readFileFromResources(String filename) {
        URL resource = CommonUtils.class.getClassLoader().getResource(filename);
        if (resource == null)
            throw new IllegalArgumentException("file is not found!");

        StringBuilder fileContent = new StringBuilder();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(resource.getFile())));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContent.toString();
    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) getDriver()).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }
}
