package org.example;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Pages.MyAccountPage;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    public String validLogin = "andersenTEST";
    public String validPassword = "test11";
    public String invalidLogin = "jjvkfjnvdfd";
    public String invalidPassword = "jjvf51665";


    @Test(description = "Успешный вход на сайт")
    public void test1() {
         new HomePage(driver)
                .goToLoginPage();
         new LoginPage(driver)
                 .enterNik(validLogin)
                 .enterPassword(validPassword)
                 .clickLog();
         new MyAccountPage(driver)
                 .checkSignIn();
    }

    @Test(description = "Вход на сайт с некорректным логином и валидным паролем")
    public void test2() {
        new HomePage(driver)
                .goToLoginPage();
        new LoginPage(driver)
                .enterNik(invalidLogin)
                .enterPassword(validPassword)
                .clickLog()
                .checkIncorrectData();
    }

    @Test(description = "Вход на сайт с валидным  логином и некорректным паролем")
    public void test3() {
        new HomePage(driver)
                .goToLoginPage();
        new LoginPage(driver)
                .enterNik(validLogin)
                .enterPassword(invalidPassword)
                .clickLog()
                .checkIncorrectData();
    }
}
