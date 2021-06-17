package org.example.Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement searchNik = driver.findElement(By.id("username"));
    public WebElement searchPassword = driver.findElement(By.id("pass"));
    public WebElement buttonLogg = driver.findElement(By.id("login_button"));


    public void enterNik(String Login){
        searchNik.sendKeys(Login);
    }

    public void enterPassword(String Password){
        searchPassword.sendKeys(Password);
    }

    public void checkSignIn(){
        boolean successSignIn = driver.findElement(By.xpath("//*[text()='Account Overview']")).isDisplayed();
        Assert.assertTrue(successSignIn);
        System.out.println("Login is passed");
    }

    public void checkIncorrectData(){
        boolean failedSignIn = driver.findElement(By.xpath("//*[text()='Login is not correct. Try again.']")).isDisplayed();
        Assert.assertTrue(failedSignIn);
    }


}
