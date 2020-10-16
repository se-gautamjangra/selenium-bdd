package com.gautam.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.gautam.utils.ConfigUtils.getPropertyByKey;
import static com.gautam.utils.ConfigUtils.loadProperties;

public class DriverUtils {
    static WebDriver driver;
    static final Logger logger = Logger.getLogger(DriverUtils.class);

    public static void initDriver() {
        BasicConfigurator.configure();
        loadProperties();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Launching Chrome Browser.");
        driver.get(getPropertyByKey("application.url"));
    }

    public static WebDriver getDriver() {

        if (driver == null ) {
            initDriver();
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
