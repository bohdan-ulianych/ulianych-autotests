package org.example;
import org.example.Pages.HomePage;
import org.example.Pages.MyAccountPage;
import org.testng.annotations.*;

public class MyAccountTests extends BaseTest {

    public String validLogin = "andersenTEST";
    public String validPassword = "test11111";
    public String Email = "test15@gmvvf.co111";



    @Test(description = "Валидная смена пароля пользователя. НЕ ЗАБЫТЬ ПОМЕНЯТЬ ПАРОЛЬ В ОСТАЛЬНЫХ ПЕРЕМЕННЫХ Password")
    public void test1() {
        String newPassword = validPassword + "1";
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
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
    public void test2() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .getRefLink()
                .logOut();
    }

    @Test(description = "Валидная смена електронной почты. НЕ ЗАБЫТЬ СМЕНИТЬ ПОМЕНЯТЬ ПЕРЕМЕННУЮ Email")
    void test3() {
        String newEmail = Email + "1";
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn()
                .buttonEditEmailClick()
                .inputNewEmailClick()
                .inputConfirmPasswordClear()
                .enterNewEmail(newEmail)
                .inputConfirmPasswordClick()
                .inputConfirmPasswordClear()
                .newEmailConfirmPassword(validPassword)
                .buttonConfirmChangeEmailClick()
                .checkChangeEmail()
                .logOut();
        System.out.println("New email is: " + newEmail);
        newEmail = Email;
    }
}