package org.example;
import org.example.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LocalizationTests extends BaseTest {

    @Test(description = "Смена языка на главной странице c английского на русский ")
    public void test1() {
        new HomePage(driver)
                .clickToFlag()
                .clickToChangeLoc();
        String rusLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(rusLocConfirm.contains("https://rus.windscribe.com/"));
        System.out.println("Russian localization is available");
    }

    @Test(description = "Смена языка на главной странице c английского на немецкий ")
    public void test2() {
        new HomePage(driver)
                .deuFlagButtonClick()
                .deuLocButtonClick();
        String deuLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(deuLocConfirm.contains("https://deu.windscribe.com/"));
        System.out.println("Deutsche localization is available");
    }

    @Test(description = "Смена языка на главной странице c английского на итальянский ")
    public void test3() {
        new HomePage(driver)
                .itaFlagButtonClick()
                .itaLocButtonClick();
        String itaLocConfirm = driver.getCurrentUrl();
        Assert.assertTrue(itaLocConfirm.contains("https://ita.windscribe.com/"));
        System.out.println("Italiano localization is available");

    }
}
