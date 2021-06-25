package org.example;

import data.LoginProvider;
import io.qameta.allure.Description;
import logging.DefaultListener;
import org.example.Pages.HomePage;
import org.testng.annotations.*;
import utils.PropertyHelper;

@Listeners(DefaultListener.class)
public class LoginTests extends BaseTest {

    @Test(description = "Успешный вход на сайт", dataProvider = "Successful sign in.", dataProviderClass = LoginProvider.class)
    @Description("Successful Login to your personal account.")
    public void successfulLogin(String login, String password) {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(login)
                .enterPassword(password)
                .clickLog()
                .checkSignIn()
                .logOut();
    }

    @Test(description = "Вход с некорректными данными.", dataProvider = "Test with incorrect data.", dataProviderClass = LoginProvider.class)
    @Description("Check login with incorrect credits.")
    public void loginWithIncorrectData(String login, String password) {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(login)
                .enterPassword(password)
                .clickLog()
                .checkIncorrectData();
    }
}
