package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import driver.DriverProvider;

public class BasePage {
    WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(WebDriver.class);

    BasePage(WebDriver driver) {
        PageFactory.initElements(DriverProvider.getDriver(), this);
        this.driver = DriverProvider.getDriver();
    }
}
