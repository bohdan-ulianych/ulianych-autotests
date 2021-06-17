package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
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
public class MyAccountTests  extends BaseTest{
    ChromeDriver driver;
    String Login = "andersenTEST";
    String Password = "test11";
    String Email = "test15@gmvvf.co11";

    @BeforeMethod
    public void wakeUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://windscribe.com/");
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        new Actions(driver)
                .sendKeys(searchNik, Login)
                .sendKeys(searchPassword, Password)
                .click(buttonLogg)
                .build()
                .perform();
        WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        Assert.assertTrue(confirmLogin.isDisplayed());
        System.out.println("Login is passed");
    }

    @Test(description = "Валижная смена пароля пользователя. НЕ ЗАБЫТЬ ПОМЕНЯТЬ ПАРОЛЬ В ОСТАЛЬНЫХ ПЕРЕМЕННЫХ Password")
    public void test1() throws Exception {
        WebElement buttonEditPassword = driver.findElement(By.xpath("//*[@id=\"myaccountpage\"]/div[4]/span/i"));
        buttonEditPassword.click();
        WebElement searchInputOldPassword = driver.findElement(By.id("old_pass_input"));
        searchInputOldPassword.click();
        searchInputOldPassword.sendKeys(Password);
        WebElement searchInputNewPassword = driver.findElement(By.id("new_pass_input"));
        String newPassword = Password + "1";
        System.out.println("Generate new password: " + newPassword);
        searchInputNewPassword.sendKeys(newPassword);
        WebElement searchInputConfirmPassword = driver.findElement(By.id("confirm_pass_input"));
        searchInputConfirmPassword.sendKeys(newPassword);
        WebElement buttonConfirmChangesPass = driver.findElement(By.id("pass_change_submit"));
        buttonConfirmChangesPass.click();
        try {
            WebElement confirmChanges = driver.findElement(By.xpath("//span[text()='Your password has been changed']"));
        } catch (Exception e) {
            throw new Exception("Error to change password");
        }
        System.out.println("Password is changed. New password is: " + newPassword);
        Password = newPassword;
    }

    @Test(description = "Вывод реферальной ссылки")
    public void test2(){
        WebElement refLink = driver.findElement(By.id("ma_friend_url"));
        if(refLink != null ){
            System.out.println("Link for your friends: " + refLink.getText());
        } else {
            System.out.println("Error to find referral link");
        }
    }

    @Test(description = "Валидная смена електронной почты. НЕ ЗАБЫТЬ СМЕНИТЬ ПОМЕНЯТЬ ПЕРЕМЕННУЮ Email")
    void test3() throws Exception {
        WebElement buttonEditEmail = driver.findElement(By.xpath("//*[@id=\"myaccountpage\"]/div[3]/span/i"));
        buttonEditEmail.click();
        WebElement searchInputNewEmail = driver.findElement(By.id("new_email_input"));
        searchInputNewEmail.click();
        searchInputNewEmail.clear();
        String newEmail = Email + "1";
        searchInputNewEmail.sendKeys(newEmail);
        WebElement searchInputConfirmPassword = driver.findElement(By.id("new_email_pass_input"));
        searchInputConfirmPassword.click();
        searchInputConfirmPassword.clear();
        searchInputConfirmPassword.sendKeys(Password);
        WebElement buttonConfirmChangeEmail = driver.findElement(By.id("email_change_submit"));
        buttonConfirmChangeEmail.click();
        try {
            WebElement confirmChangeEmail = driver.findElement(By.xpath("//span[text()='Great, now check your Inbox (or Spam folder) for a confirmation email.']"));
        } catch (Exception e) {
            throw new Exception("Error change email");
        }
        System.out.println("Email is changed. New Email is: " + newEmail);
        newEmail = Email;
    }

    @AfterMethod
    public void quit() {
        driver.quit();


    }}