package org.example;

import io.qameta.allure.Description;
import org.example.Pages.HomePage;
import org.example.Pages.MyAccountPage;
import org.junit.jupiter.api.AfterAll;
import org.testng.annotations.*;

public class MyAccountTests extends BaseTest {

    public final String VALID_LOGIN = "bakabek";
    public String validPassword = "test123";
    public final String email = "testing@gmvvf.c5";
    public final String returnPassword = "test123";


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
        String newEmail = email + "1";
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
    void returnOldPassword() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(VALID_LOGIN)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .buttonEditEmailClick()
                .inputNewEmailClick()
                .inputNewEmailClear()
                .enterNewEmail(email)
                .inputConfirmPasswordClick()
                .inputConfirmPasswordClear()
                .newEmailConfirmPassword(validPassword)
                .buttonConfirmChangeEmailClick()
                .checkChangeEmail()
                .buttonEditPasswordClick()
                .inputOldPasswordClick()
                .enterOldPassword(validPassword)
                .enterNewPassword(returnPassword)
                .confirmNewPassword(returnPassword)
                .buttonConfirmChangesPassClick()
                .checkChangePassword()
                .logOut();
    }
}