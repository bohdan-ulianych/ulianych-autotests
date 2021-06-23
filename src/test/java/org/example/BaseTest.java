package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.PropertyHelper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    private static Logger loger = LoggerFactory.getLogger(WebDriver.class);


    private final String START_URL = PropertyHelper.getConf().startUrl();
    private final int ELEMENT_TIMEOUT = PropertyHelper.getConf().elementTimeout();

    @BeforeTest
    public void wakeUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToLink() {
        driver.get(START_URL);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
