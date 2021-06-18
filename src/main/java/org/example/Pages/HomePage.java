package org.example.Pages;
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

    public HomePage itaFlagButtonClick(){
        itaFlagButton.click();
        return this;
    }

    public HomePage itaLocButtonClick(){
        itaLocButton.click();
        return this;
    }

    public HomePage checkItaLoc(){
        String itaLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(itaLocConfirm.contains("https://ita.windscribe.com/"));
        System.out.println("Italiano localization is available");
        return this;
    }

    public HomePage deuFlagButtonClick() {
        deuFlagButton.click();
        return this;
    }

    public HomePage deuLocButtonClick() {
        deuLocButton.click();
        return this;
    }

    public HomePage checkDeuLoc(){
        String deuLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(deuLocConfirm.contains("https://deu.windscribe.com/"));
        System.out.println("Deutsche localization is available");
        return this;
    }

    public HomePage clickToFlag() {
        rusFlagButton.click();
        return this;
    }

    public HomePage clickToChangeLoc() {
        rusLocButton.click();
        return this;
    }

    public HomePage checkRusLoc(){
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://rus.windscribe.com/"));
        System.out.println("Russian localization is available");
        return this;
    }

    public LoginPage goToLoginPage() {
        logInButton.click();
        return new LoginPage(driver);
    }

}
