package org.example;

import io.qameta.allure.Description;
import logging.DefaultListener;
import org.example.Pages.HomePage;
import org.testng.annotations.*;

@Listeners(DefaultListener.class)
public class LocalizationTests extends BaseTest {

    @Test(description = "Смена языка на главной странице c английского на русский ")
    @Description("Change language on home page from English to Russian.")
    public void changeLanguageInHomePageRus() {
        new HomePage(driver)
                .clickToFlag()
                .clickToChangeLoc()
                .checkRusLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на немецкий ")
    @Description("Change language on home page from English to Dutch. ")
    public void changeLanguageInHomePageDeu() {
        new HomePage(driver)
                .deuFlagButtonClick()
                .deuLocButtonClick()
                .checkDeuLoc();
    }

    @Test(description = "Смена языка на главной странице c английского на итальянский ")
    @Description("Change language on home page from English to Italiano. ")
    public void changeLanguageInHomePageIta() {
        new HomePage(driver)
                .itaFlagButtonClick()
                .itaLocButtonClick()
                .checkItaLoc();
    }
}
