package org.example;

import org.example.Pages.HomePage;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    public final String VALID_LOGIN = "andersenTEST";
    public final String VALID_PASSWORD = "test1";
    public String invalidLogin = "jjvkfjnvdfd";
    public String invalidPassword = "jjvf51665";


    @Test(description = "Успешный вход на сайт")
    public void test1() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickLog()
                .checkSignIn()
                .logOut();
    }

    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
    public void test2() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(invalidLogin)
                .enterPassword(VALID_PASSWORD)
                .clickLog()
                .checkIncorrectData();

    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    public void test3() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(invalidPassword)
                .clickLog()
                .checkIncorrectData();
    }
}
