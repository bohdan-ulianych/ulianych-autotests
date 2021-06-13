package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://windscribe.com/");
        WebElement buttonLog = driver.findElement(By.xpath("//*[text()='Log In']"));
        buttonLog.click();
        WebElement searchNik = driver.findElement(By.id("username"));
        WebElement searchPassword = driver.findElement(By.id("pass"));
        searchPassword.click();
        searchNik.sendKeys("KopoBa");
        searchPassword.sendKeys("qwertyqaz");
        WebElement buttonLogg = driver.findElement(By.id("login_button"));
        buttonLogg.click();
        WebElement confirmlogin = driver.findElement(By.xpath("//*[text()='Account Overview']"));
        if (confirmlogin.getText().equals("Account Overview")) {
            System.out.println("OK");
        } else {
            throw new Exception("Error");
        }
        System.out.println("Breakpoint");
        driver.quit();
    }


}