package org.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Log In']")
    public WebElement logInButton;

    @FindBy(xpath = "//*[text()='Sign Up'][1]")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[@class='language-selector-toggle']")
    public WebElement rusFlagButton;

    @FindBy(xpath = "//a[@href = 'https://rus.windscribe.com/']")
    public WebElement rusLocButton;

    @FindBy(xpath = "//*[@class='language-selector-toggle']")
    public WebElement deuFlagButton;

    @FindBy(xpath = "//a[@href = 'https://deu.windscribe.com/']")
    WebElement deuLocButton;

    @FindBy(xpath = "//*[@class='language-selector-toggle']")
    WebElement itaFlagButton;

    @FindBy(xpath = "//a[@href = 'https://ita.windscribe.com/']")
    WebElement itaLocButton;

    @Step("Click to flag change language button.")
    public HomePage itaFlagButtonClick() {
        itaFlagButton.click();
        return this;
    }

    @Step("Click to change language from English to Italiano.")
    public HomePage itaLocButtonClick() {
        itaLocButton.click();
        return this;
    }

    @Step("Checking the change to Italian localization")
    public HomePage checkItaLoc() {
        String itaLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(itaLocConfirm.contains("https://ita.windscribe.com/"));
        System.out.println("Italiano localization is available");
        return this;
    }

    @Step("Click to flag change language button.")
    public HomePage deuFlagButtonClick() {
        deuFlagButton.click();
        return this;
    }

    @Step("Click to change language from English to Dutch.")
    public HomePage deuLocButtonClick() {
        deuLocButton.click();
        return this;
    }

    @Step("Checking the change to German localization.")
    public HomePage checkDeuLoc() {
        String deuLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(deuLocConfirm.contains("https://deu.windscribe.com/"));
        System.out.println("Deutsche localization is available");
        return this;
    }

    @Step("Click to flag change language button.")
    public HomePage clickToFlag() {
        rusFlagButton.click();
        return this;
    }

    @Step("Click to change language from English to Russian")
    public HomePage clickToChangeLoc() {
        rusLocButton.click();
        return this;
    }

    @Step("Checking the change to Russian localization.")
    public HomePage checkRusLoc() {
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://rus.windscribe.com/"));
        System.out.println("Russian localization is available");
        return this;
    }

    @Step("Click to \"LogIn\" button")
    public LoginPage goToLoginPage() {
        logInButton.click();
        return new LoginPage(driver);
    }
}
