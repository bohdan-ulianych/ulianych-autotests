package org.example.Pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Slf4j
public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Account Overview']")
    WebElement successSingIn;

    @FindBy(xpath = "//*[@class='edit_item'][1]")
    WebElement buttonEditEmail;

    @FindBy(id = "new_email_input")
    WebElement inputNewEmail;

    @FindBy(id = "new_email_pass_input")
    WebElement inputConfirmPassword;

    @FindBy(id = "email_change_submit")
    WebElement buttonConfirmChangeEmail;

    @FindBy(xpath = "//span[text()='Great, now check your Inbox (or Spam folder) for a confirmation email.']")
    WebElement confirmChangeEmail;

    @FindBy(id = "ma_friend_url")
    WebElement refLink;

    @FindBy(xpath = "//*[@id=\"myaccountpage\"]/div[4]/span/i")
    WebElement buttonEditPassword;

    @FindBy(id = "old_pass_input")
    WebElement inputOldPassword;

    @FindBy(id = "new_pass_input")
    WebElement inputNewPassword;

    @FindBy(id = "confirm_pass_input")
    WebElement inputConfirmNewPassword;

    @FindBy(id = "pass_change_submit")
    WebElement buttonConfirmChangesPass;

    @FindBy(xpath = "//span[text()='Your password has been changed']")
    WebElement confirmChanges;

    @FindBy(xpath = "//*[text()='Login is not correct. Try again.']")
    WebElement failedSignIn;

    @FindBy(xpath = "//*[@href = '/myaccount/logout']")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@href = '/myaccount']")
    WebElement myAccountButton;

    @Step("Logout from your personal account.")
    public MyAccountPage logOut() {
        Actions moove = new Actions(driver);
        moove.moveToElement(myAccountButton).build().perform();
        logOutButton.click();
        logger.info("Log out from personal account is done.");
        return this;
    }

    @Step("Check to change a user`s password.")
    public MyAccountPage checkChangePassword() {
        Assert.assertTrue(confirmChanges.isDisplayed());
        logger.info("Password is changed.");
        return this;
    }

    @Step("Click to \"Change\" button to confirm change password.")
    public MyAccountPage buttonConfirmChangesPassClick() {
        buttonConfirmChangesPass.click();
        logger.info("\"Change\" button to confirm change password is clicked.");
        return this;
    }

    @Step("Enter user`s new password to confirm.")
    public MyAccountPage confirmNewPassword(String newPassword) {
        inputConfirmNewPassword.sendKeys(newPassword);
        logger.info("Entering to confirm new password is done.");
        return this;
    }

    @Step("Enter user`s new password.")
    public MyAccountPage enterNewPassword(String newPassword) {
        inputNewPassword.sendKeys(newPassword);
        logger.info("Entering new user`s password is done.");
        return this;
    }

    @Step("Click to field with changing password.")
    public MyAccountPage inputOldPasswordClick() {
        inputOldPassword.click();
        logger.info("Fiend with change password is enable.");
        return this;
    }

    @Step("Enter user`s old password.")
    public MyAccountPage enterOldPassword(String Password) {
        inputOldPassword.sendKeys(Password);
        logger.info("Entering old user`s password is done.");
        return this;
    }

    @Step("Click to change password button.")
    public MyAccountPage buttonEditPasswordClick() {
        buttonEditPassword.click();
        logger.info("Button to change password is clicked.");
        return this;
    }

    @Step("Checking, that referral link is not empty and print. ")
    public MyAccountPage getRefLink() {
        if (refLink.getText() != null) {
            System.out.println("Link for your friends: " + refLink.getText());
        } else {
            System.out.println("Error to find referral link");
        }
        logger.info("Referral link received and not empty. ");
        return this;
    }

    @Step("Check to change a user`s email.")
    public MyAccountPage checkChangeEmail() {
        Assert.assertTrue(confirmChangeEmail.isDisplayed());
        logger.info("Email is changed. ");
        return this;
    }

    @Step("Click to \"Change\" button to confirm change email.")
    public MyAccountPage buttonConfirmChangeEmailClick() {
        buttonConfirmChangeEmail.click();
        return this;
    }

    @Step("Click to field with changing email.")
    public MyAccountPage inputConfirmPasswordClick() {
        inputConfirmPassword.click();
        logger.info("\"Change\" button to confirm change email is clicked.");
        return this;
    }

    @Step("Clear field with confirming user`s password to change email.")
    public MyAccountPage inputConfirmPasswordClear() {
        inputConfirmPassword.clear();
        logger.info("Fiend with confirming user`s password to change email is cleared. ");
        return this;
    }

    @Step("Enter user`s password to confirm changing email.")
    public MyAccountPage newEmailConfirmPassword(String Password) {
        inputConfirmPassword.sendKeys(Password);
        logger.info("User`s password is entered. ");
        return this;
    }

    @Step("Click to field with changing email.")
    public MyAccountPage inputNewEmailClick() {
        inputNewEmail.click();
        logger.info("Field with changing Email is enable. ");
        return this;
    }

    @Step("Clear field with old user`s email to change email.")
    public MyAccountPage inputNewEmailClear() {
        inputNewEmail.clear();
        logger.info("Field with old user`s email is cleared.");
        return this;
    }

    @Step("Enter new user`s email.")
    public MyAccountPage enterNewEmail(String Email) {
        inputNewEmail.sendKeys(Email);
        logger.info("New user`s email is entered.");
        return this;
    }

    @Step("Click to change email button.")
    public MyAccountPage buttonEditEmailClick() {
        buttonEditEmail.click();
        logger.info("Button to change user`s email is clicked.");
        return this;
    }

    @Step("Check success sing in in user`s personal account.")
    public MyAccountPage checkSignIn() {
        Assert.assertTrue(successSingIn.isDisplayed());
        logger.info("Successful sign in in users personal account. ");
        return this;
    }

    @Step("Check trying to sing in with incorrect data.")
    public MyAccountPage checkIncorrectData() {
        Assert.assertTrue(failedSignIn.isDisplayed());
        logger.warn("Entered incorrect data.");
        return this;
    }
}
