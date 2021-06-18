package org.example;
import org.example.Pages.HomePage;
import org.example.Pages.MyAccountPage;
import org.testng.annotations.*;

public class MyAccountTests extends BaseTest {

    public String validLogin = "andersenTEST";
    public String validPassword = "test1";
    String Email = "test15@gmvvf.co1";

    @BeforeMethod
    public void login() {
        new HomePage(driver)
                .goToLoginPage()
                .enterNik(validLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkSignIn();
    }

    @Test(description = "Валидная смена пароля пользователя. НЕ ЗАБЫТЬ ПОМЕНЯТЬ ПАРОЛЬ В ОСТАЛЬНЫХ ПЕРЕМЕННЫХ Password")
    public void test1() {
        String newPassword = validPassword + "1";
        new MyAccountPage(driver)
                .buttonEditPasswordClick()
                .inputOldPasswordClick()
                .enterOldPassword(validPassword)
                .enterNewPassword(newPassword)
                .confirmNewPassword(newPassword)
                .buttonConfirmChangesPassClick()
                .checkChangePassword();
        System.out.println(" New password is: " + newPassword);
        validPassword = newPassword;
    }


    @Test(description = "Вывод реферальной ссылки")
    public void test2() {
        new MyAccountPage(driver).getRefLink();
    }

    @Test(description = "Валидная смена електронной почты. НЕ ЗАБЫТЬ СМЕНИТЬ ПОМЕНЯТЬ ПЕРЕМЕННУЮ Email")
    void test3() {
        String newEmail = Email + "1";
        new MyAccountPage(driver)
                .buttonEditEmailClick()
                .inputNewEmailClick()
                .inputConfirmPasswordClear()
                .enterNewEmail(newEmail)
                .inputConfirmPasswordClick()
                .inputConfirmPasswordClear()
                .newEmailConfirmPassword(validPassword)
                .buttonConfirmChangeEmailClick()
                .checkChangeEmail();
        System.out.println("New email is: " + newEmail);
        newEmail = Email;
    }
}