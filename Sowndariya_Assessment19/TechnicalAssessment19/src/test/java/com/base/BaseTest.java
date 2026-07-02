package com.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger log = LogManager.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {
        WebDriver dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dr.get("https://automationexercise.com");

        driver.set(dr);
        log.info("Browser launched");
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            log.info("Browser closed");
        }
    }
}