package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
import org.example.Pages.HomePage;
import org.testng.annotations.*;
import utils.PropertyHelper;

@Listeners(DefaultListener.class)
public class LoginTests extends BaseTest {

    public final String VALID_LOGIN = PropertyHelper.getConf().validLogin();
    public final String VALID_PASSWORD = PropertyHelper.getConf().validPassword();
    public final String INVALID_LOGIN = PropertyHelper.getConf().invalidLogin();
    public final String INVALID_PASSWORD = PropertyHelper.getConf().invalidPassword();

    @Test(description = "Успешный вход на сайт")
    @Description("Successful Login to your personal account.")
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
    @Description("Check login with incorrect nik and correct password.")
    public void bloginWithIncorrectNik() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(INVALID_LOGIN)
                .enterPassword(VALID_PASSWORD)
                .clickLog()
                .checkIncorrectData();
    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    @Description("Check login with correct nik and incorrect password.")
    public void loginWithIncorrectIncorrectPass() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(INVALID_PASSWORD)
                .clickLog()
                .checkIncorrectData();
    }
}
