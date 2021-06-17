package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void itaLocButtonClick(){
        itaLocButton.click();
    }

    public HomePage deuFlagButtonClick() {
        deuFlagButton.click();
        return this;
    }

    public void deuLocButtonClick() {
        deuLocButton.click();
    }

    public HomePage clickToFlag() {
        rusFlagButton.click();
        return this;
    }

    public void clickToChangeLoc() {
        rusLocButton.click();
    }

    public void goToLoginPage() {
        logInButton.click();
    }

}
