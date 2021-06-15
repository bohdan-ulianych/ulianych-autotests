package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    String Password;
    String Login;

    public Tests(WebDriver driver, String login, String password) {
        this.driver = driver;
        Password = password;
        Login = login;
    }

    public void logIneJSExecutor() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://windscribe.com/");
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        JavascriptExecutor clickToButton = (JavascriptExecutor) driver;
        clickToButton.executeScript("arguments[0].click();", buttonLog);
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        JavascriptExecutor enterNik = (JavascriptExecutor) driver;
        enterNik.executeScript("arguments[0].value = 'andersenTEST'",searchNik);
//        searchNik.sendKeys("andersenTEST");
        JavascriptExecutor enterPass = (JavascriptExecutor) driver;
        enterNik.executeScript("arguments[0].value = 'test1'",searchPassword);
//        searchPassword.sendKeys(Password);
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        JavascriptExecutor clickToLogButton = (JavascriptExecutor) driver;
        clickToButton.executeScript("arguments[0].click();", buttonLogg);
//        buttonLogg.click();
        try {
            WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentification error");
        }
        System.out.println("LogIn is passed");
        driver.quit();
    }


    public void openNewTabAndLogin() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://windscribe.com/");
        String link = "window.open('https://windscribe.com/','_blank');";
        JavascriptExecutor openNewSameTab = (JavascriptExecutor) driver;
        openNewSameTab.executeScript(link);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondTab = windows.get(1);
        driver.switchTo().window(secondTab);
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        new Actions(driver)
                .sendKeys(searchNik,Login )
                .sendKeys(searchPassword, Password)
                .click(buttonLogg)
                .build()
                .perform();
        try {
            WebElement confirmLogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        } catch (Exception e) {
            driver.quit();
            throw new Exception("Authentification error");
        }
        System.out.println("LogIn is passed");
        driver.quit();







    }




}
