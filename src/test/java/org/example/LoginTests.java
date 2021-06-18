package org.example;

import org.example.Pages.HomePage;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    public final String VALID_LOGIN = "andersenTEST";
    public final String VALID_PASSWORD = "test1";
    public final String INVALID_LOGIN = "jjvkfjnvdfd";
    public final String INVALID_PASSWORD = "jjvf51665";

    @Test(description = "Успешный вход на сайт")
    public void successfulLogin() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickLog()
                .checkSignIn()
                .logOut();
    }

    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
    public void loginWithIncorrectNik() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(INVALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickLog()
                .checkIncorrectData();
    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    public void loginWithIncorrectIncorrectPass() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(INVALID_PASSWORD)
                .clickLog()
                .checkIncorrectData();
    }
}
