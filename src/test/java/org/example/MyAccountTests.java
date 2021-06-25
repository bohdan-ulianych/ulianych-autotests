package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
import org.example.Pages.HomePage;
import org.testng.annotations.*;
import utils.PropertyHelper;

@Listeners(DefaultListener.class)
public class MyAccountTests extends BaseTest {

    public final String VALID_LOGIN = PropertyHelper.getConf().validLogin();
    public String validPassword = PropertyHelper.getConf().validPassword();
    public final String EMAIL = PropertyHelper.getConf().email();
    public final String RETURN_PASSWORD = PropertyHelper.getConf().returnPassword();

    @Test(description = "Валидная смена пароля пользователя.")
    @Description("Valid changing user`s password.")
    public void successfulChangePassword() {
        String newPassword = validPassword + "1";
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .buttonEditPasswordClick()
                .inputOldPasswordClick()
                .enterOldPassword(validPassword)
                .enterNewPassword(newPassword)
                .confirmNewPassword(newPassword)
                .buttonConfirmChangesPassClick()
                .checkChangePassword()
                .logOut();
        System.out.println(" New password is: " + newPassword);
        validPassword = newPassword;
    }

    @Test(description = "Вывод реферальной ссылки")
    @Description("Printing a referral link.")
    public void printRefLink() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .getRefLink()
                .logOut();
    }

    @Test(description = "Валидная смена електронной почты.")
    @Description("Valid changing user`s email.")
    void successfulChangeEmail() {
        String newEmail = EMAIL + "1";
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .buttonEditEmailClick()
                .inputNewEmailClick()
                .inputNewEmailClear()
                .enterNewEmail(newEmail)
                .inputConfirmPasswordClick()
                .inputConfirmPasswordClear()
                .newEmailConfirmPassword(validPassword)
                .buttonConfirmChangeEmailClick()
                .checkChangeEmail()
                .logOut();
        System.out.println("New email is: " + newEmail);
    }

    @AfterClass
    void returnOldCredits() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .buttonEditEmailClick()
                .inputNewEmailClick()
                .inputNewEmailClear()
                .enterNewEmail(EMAIL)
                .inputConfirmPasswordClick()
                .inputConfirmPasswordClear()
                .newEmailConfirmPassword(validPassword)
                .buttonConfirmChangeEmailClick()
                .checkChangeEmail()
                .buttonEditPasswordClick()
                .inputOldPasswordClick()
                .enterOldPassword(validPassword)
                .enterNewPassword(RETURN_PASSWORD)
                .confirmNewPassword(RETURN_PASSWORD)
                .buttonConfirmChangesPassClick()
                .checkChangePassword()
                .logOut();
    }
}