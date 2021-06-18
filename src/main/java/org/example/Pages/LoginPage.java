package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    public WebElement inputNik;

    @FindBy(id = "pass")
    public WebElement inputPassword;

    @FindBy(id = "login_button")
    public WebElement buttonLogg;

    public LoginPage enterNik(String login) {
        inputNik.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MyAccountPage clickLog() {
        buttonLogg.click();
        return new MyAccountPage(driver);
    }
}
