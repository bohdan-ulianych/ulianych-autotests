package org.example.Pages;

import io.qameta.allure.Step;
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

    @Step("Enter a nik in Login page")
    public LoginPage enterNik(String login) {
        inputNik.sendKeys(login);
        logger.info("Login " + login + " is entered.");

        return this;
    }

    @Step("Enter a password in Login page")
    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        logger.info("Password " + password + " is entered.");
        return this;
    }

    @Step("Click to \"LogIn\" button in Login page")
    public MyAccountPage clickLog() {
        buttonLogg.click();
        logger.info("\"LogIn\" button in Login page is clicked. Go to MyAccount page.");
        return new MyAccountPage(driver);
    }
}
