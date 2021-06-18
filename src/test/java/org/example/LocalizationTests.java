package org.example;
import org.example.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LocalizationTests extends BaseTest {

    @Test(description = "Смена языка на главной странице c английского на русский ")
    public void test1() {
        new HomePage(driver)
                .clickToFlag()
                .clickToChangeLoc()
                .checkRusLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на немецкий ")
    public void test2() {
        new HomePage(driver)
                .deuFlagButtonClick()
                .deuLocButtonClick()
                .checkDeuLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на итальянский ")
    public void test3() {
        new HomePage(driver)
                .itaFlagButtonClick()
                .itaLocButtonClick()
                .checkItaLoc();
    }
}
