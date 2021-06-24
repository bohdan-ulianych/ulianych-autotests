package org.example;

import driver.DriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import logging.DefaultListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.PropertyHelper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
@Listeners(DefaultListener.class)
public class BaseTest {
     WebDriver driver;
    private static Logger loger = LoggerFactory.getLogger(WebDriver.class);


    private final String START_URL = PropertyHelper.getConf().startUrl();
    private final int ELEMENT_TIMEOUT = PropertyHelper.getConf().elementTimeout();

    @BeforeTest
    public void wakeUp() {
        WebDriver driver = DriverProvider.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToLinkk() {
        DriverProvider.goToLink(START_URL);
    }

    @AfterTest
    public void quit() {
        DriverProvider.tearDown();
    }
}
