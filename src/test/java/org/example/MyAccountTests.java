package org.example;

import org.example.Pages.HomePage;
import org.example.Pages.MyAccountPage;
import org.testng.annotations.*;

public class MyAccountTests extends BaseTest {

    public final String VALID_LOGIN = "andersenTEST";
    public String validPassword = "test11111";
    public String email = "test15@gmvvf.co111";

    @Test(description = "Валидная смена пароля пользователя. НЕ ЗАБЫТЬ ПОМЕНЯТЬ ПАРОЛЬ В ОСТАЛЬНЫХ ПЕРЕМЕННЫХ Password")
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

    @Test(description = "Валидная смена електронной почты. НЕ ЗАБЫТЬ СМЕНИТЬ ПОМЕНЯТЬ ПЕРЕМЕННУЮ Email")
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
        newEmail = email;
    }
}