package org.example.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    public WebElement inputNik;

    @FindBy(id = "pass")
    public WebElement inputPassword;

    @FindBy(id = "login_button")
    public WebElement buttonLogg;

    @FindBy(xpath = "//*[text()='Login is not correct. Try again.']")
    WebElement failedSignIn;

    public  LoginPage enterNik(String Login){
        inputNik.sendKeys(Login);
        return this;
    }

    public LoginPage enterPassword(String Password){
        inputPassword.sendKeys(Password);
        return this;
    }

    public LoginPage clickLog(){
        buttonLogg.click();
        return this;
    }

    public void checkIncorrectData(){
        Assert.assertTrue(failedSignIn.isDisplayed());
        System.out.println("Russian localization is available");
    }


}
