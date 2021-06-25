package org.example;

import data.LoginProvider;
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

    @Test(dataProvider = "Test with incorrect data.", dataProviderClass = LoginProvider.class)
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
