package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
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

public class LoginTests extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;
    public String ValidLogin = "andersenTEST";
    public String ValidPassword = "test11";
    public String InvalidLogin = "jjvkfjnvdfd";
    public String InvalidPassword = "jjvf51665";


    @Test(description = "Успешный вход на сайт")
    public void test1() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.goToLoginPage();
        loginPage.enterNik(ValidLogin);
        loginPage.enterPassword(ValidPassword);
        loginPage.buttonLogg.click();
        loginPage.checkSignIn();
    }

    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
    public void test2() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.goToLoginPage();
        loginPage.enterNik(InvalidLogin);
        loginPage.enterPassword(ValidPassword);
        loginPage.buttonLogg.click();
        loginPage.checkIncorrectData();
    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    public void test3() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.goToLoginPage();
        loginPage.enterNik(ValidLogin);
        loginPage.enterPassword(InvalidPassword);
        loginPage.buttonLogg.click();
        loginPage.checkIncorrectData();
    }
}

//    @Test(description = "Валидный вход на сайт")
//    public void test1() {
//        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
//        buttonLog.click();
//        WebElement searchNik = driver.findElement(By.id("username"));
//        WebElement searchPassword = driver.findElement(By.id("pass"));
//        WebElement buttonLogg = driver.findElement(By.id("login_button"));
//        new Actions(driver)
//                .sendKeys(searchNik, Login)
//                .sendKeys(searchPassword, Password)
//                .click(buttonLogg)
//                .build()
//                .perform();
//        WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
//        Assert.assertTrue(confirmLogin.isDisplayed());
//        System.out.println("Login is passed");
//    }
//
//
//    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
//    public void test2() {
//        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
//        buttonLog.click();
//        WebElement searchNik = driver.findElement(By.id("username"));
//        WebElement searchPassword = driver.findElement(By.id("pass"));
//        WebElement buttonLogg = driver.findElement(By.id("login_button"));
//        new Actions(driver)
//                .sendKeys(searchNik, Login + "test")
//                .sendKeys(searchPassword, Password)
//                .click(buttonLogg)
//                .build()
//                .perform();
//        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Login is not correct. Try again.']"));
//        Assert.assertTrue(errorMessage.isDisplayed());
//        System.out.println("Validation is passed");
//    }
//
//    @Test(description = "Вход на сайт с валидным логином и некорректным паролем")
//    public void test3() {
//        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
//        buttonLog.click();
//        WebElement searchNik = driver.findElement(By.id("username"));
//        WebElement searchPassword = driver.findElement(By.id("pass"));
//        WebElement buttonLogg = driver.findElement(By.id("login_button"));
//        new Actions(driver)
//                .sendKeys(searchNik, Login)
//                .sendKeys(searchPassword, Password + "test")
//                .click(buttonLogg)
//                .build()
//                .perform();
//        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Login is not correct. Try again.']"));
//        Assert.assertTrue(errorMessage.isDisplayed());
//        System.out.println("Validation is passed");
//    }

}