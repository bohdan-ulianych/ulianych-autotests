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
import java.util.concurrent.TimeUnit;

public class LocalizationTests extends BaseTest{
    ChromeDriver driver;
    String Login = "AndersenTEST";
    String Password = "test1";


    @Test(description = "Смена языка на главной странице c английского на русский ")
    public void test1(){
        WebElement rusflagButton = driver.findElement(By.xpath("//*[@class='language-selector-toggle']"));
        rusflagButton.click();
        WebElement rusLocButton = driver.findElement(By.xpath("//a[@href = 'https://rus.windscribe.com/']"));
        rusLocButton.click();
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://rus.windscribe.com/"));
        System.out.println("Russian localization is available");
    }

    @Test(description = "Смена языка на главной странице c английского на немецкий ")
    public void test2(){
        WebElement flagButtondeu = driver.findElement(By.xpath("//*[@class='language-selector-toggle']"));
        flagButtondeu.click();
        WebElement deuLocButton = driver.findElement(By.xpath("//a[@href = 'https://deu.windscribe.com/']"));
        deuLocButton.click();
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://deu.windscribe.com/"));
        System.out.println("Deutsche localization is available");

    }

    @Test(description = "Смена языка на главной странице c английского на итальянский ")
    public void test3(){
        WebElement itaflagButton = driver.findElement(By.xpath("//*[@class='language-selector-toggle']"));
        itaflagButton.click();
        WebElement itaLocButton = driver.findElement(By.xpath("//a[@href = 'https://ita.windscribe.com/']"));
        itaLocButton.click();
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://ita.windscribe.com/"));
        System.out.println("Italiano localization is available");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
