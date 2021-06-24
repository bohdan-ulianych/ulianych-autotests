package org.example.Pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Slf4j
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

    @Step("Enter a nik in Login page")
    public LoginPage enterNik(String login) {
        inputNik.sendKeys(login);

        return this;
    }

    @Step("Enter a password in Login page")
    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Click to \"LogIn\" button in Login page")
    public MyAccountPage clickLog() {
        buttonLogg.click();
        return new MyAccountPage(driver);
    }
}
