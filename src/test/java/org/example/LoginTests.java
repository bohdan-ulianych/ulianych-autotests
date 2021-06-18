package org.example;

import org.example.Pages.HomePage;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    public String validLogin = "andersenTEST";
    public String validPassword = "test1";
    public String invalidLogin = "jjvkfjnvdfd";
    public String invalidPassword = "jjvf51665";


    @Test(description = "Успешный вход на сайт")
    public void test1() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .logOut();
    }

    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
    public void test2() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(invalidLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkIncorrectData();

    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    public void test3() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
                .enterPassword(invalidPassword)
                .clickLog()
                .checkIncorrectData();
    }
}
