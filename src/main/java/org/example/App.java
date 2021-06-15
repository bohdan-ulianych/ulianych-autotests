package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriver driver = null;
        Tests test1 = new Tests(driver);
        test1.logIn();//логин
        test1.printReferalLink();//вывод реферальной ссылки
        test1.changePassword();//смена пароля
        test1.logIn();//логин и изменённым паролем
        //после каждого прогона тестов со сменой пароля нужно менять переменную Password на измененный пароль

    }
}