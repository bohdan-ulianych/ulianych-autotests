package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    String Password = "test1";

    public Tests(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://windscribe.com/");
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        searchPassword.click();
        searchNik.sendKeys("andersenTEST");
        searchPassword.sendKeys(Password);
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        buttonLogg.click();
        try {
            WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentification error");
        }
        System.out.println("LogIn is passed");
        driver.quit();
    }

    public void changePassword() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://windscribe.com/");
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        searchPassword.click();
        searchNik.sendKeys("andersenTEST");
        searchPassword.sendKeys(Password);
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        buttonLogg.click();
        try {
            WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        } catch (Exception e) {
            throw new Exception("Authentification error");
        }
        System.out.println("LogIn for change password is passed");
        WebElement buttonEditPassword = driver.findElement(By.xpath("//*[@id=\"myaccountpage\"]/div[4]/span/i"));
        buttonEditPassword.click();
        WebElement searchInputOldPassword = driver.findElement(By.id("old_pass_input"));
        searchInputOldPassword.click();
        searchInputOldPassword.sendKeys(Password);
        WebElement searchInputNewPassword = driver.findElement(By.id("new_pass_input"));
//        byte[] array = new byte[9]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String newPassword = new String(array, Charset.forName("UTF-8"));
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
            driver.quit();
            throw new Exception("Error to change password");
        }
        System.out.println("Password is changed. New password is: " + newPassword);
        Password = newPassword;
        driver.quit();
    }


    public void printReferalLink() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://windscribe.com/");
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Log In']"))));
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        searchPassword.click();
        searchNik.sendKeys("andersenTEST");
        searchPassword.sendKeys(Password);
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        buttonLogg.click();
        try {
            WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        } catch (Exception e) {
            throw new Exception("Authentification error");
        }
        System.out.println("LogIn for print referal link  is passed");
        WebElement refLink = driver.findElement(By.id("ma_friend_url"));
        System.out.println("Link for your friends: " + refLink.getText());
        driver.quit();
    }


}