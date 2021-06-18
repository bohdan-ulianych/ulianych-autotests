package org.example;

import org.example.Pages.HomePage;
import org.testng.annotations.*;

public class LocalizationTests extends BaseTest {

    @Test(description = "Смена языка на главной странице c английского на русский ")
    public void changeLanguageInHomePageRus() {
        new HomePage(driver)
                .clickToFlag()
                .clickToChangeLoc()
                .checkRusLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на немецкий ")
    public void changeLanguageInHomePageDeu() {
        new HomePage(driver)
                .deuFlagButtonClick()
                .deuLocButtonClick()
                .checkDeuLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на итальянский ")
    public void changeLanguageInHomePageIta() {
        new HomePage(driver)
                .itaFlagButtonClick()
                .itaLocButtonClick()
                .checkItaLoc();
    }
}
