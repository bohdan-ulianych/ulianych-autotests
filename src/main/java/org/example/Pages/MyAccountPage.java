package org.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.*;

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
        return this;
    }

    @Step("Check to change a user`s password.")
    public MyAccountPage checkChangePassword() {
        Assert.assertTrue(confirmChanges.isDisplayed());
        System.out.print("Password is changed. ");
        return this;
    }
    @Step("Click to \"Change\" button to confirm change password.")
    public MyAccountPage buttonConfirmChangesPassClick() {
        buttonConfirmChangesPass.click();
        return this;
    }

    @Step("Enter user`s new password to confirm.")
    public MyAccountPage confirmNewPassword(String newPassword) {
        inputConfirmNewPassword.sendKeys(newPassword);
        return this;
    }

    @Step("Enter user`s new password.")
    public MyAccountPage enterNewPassword(String newPassword) {
        inputNewPassword.sendKeys(newPassword);
        return this;
    }

    @Step("Click to field with changing password.")
    public MyAccountPage inputOldPasswordClick() {
        inputOldPassword.click();
        return this;
    }

    @Step("Enter user`s old password.")
    public MyAccountPage enterOldPassword(String Password) {
        inputOldPassword.sendKeys(Password);
        return this;
    }

    @Step("Click to change password button.")
    public MyAccountPage buttonEditPasswordClick() {
        buttonEditPassword.click();
        return this;
    }

    @Step("Checking, that referral link is not empty and print. ")
    public MyAccountPage getRefLink() {
        if (refLink.getText() != null) {
            System.out.println("Link for your friends: " + refLink.getText());
        } else {
            System.out.println("Error to find referral link");
        }
        return this;
    }

    @Step("Check to change a user`s email.")
    public MyAccountPage checkChangeEmail() {
        Assert.assertTrue(confirmChangeEmail.isDisplayed());
        System.out.print("Email is changed. ");
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
        return this;
    }

    @Step("Clear field with confirming user`s password to change email.")
    public MyAccountPage inputConfirmPasswordClear() {
        inputConfirmPassword.clear();
        return this;
    }

    @Step("Enter user`s password to confirm changing email.")
    public MyAccountPage newEmailConfirmPassword(String Password) {
        inputConfirmPassword.sendKeys(Password);
        return this;
    }

    @Step("Click to field with changing email.")
    public MyAccountPage inputNewEmailClick() {
        inputNewEmail.click();
        return this;
    }

    @Step("Clear field with old user`s email to change email.")
    public MyAccountPage inputNewEmailClear() {
        inputNewEmail.clear();
        return this;
    }

    @Step("Enter new user`s email.")
    public MyAccountPage enterNewEmail(String Email) {
        inputNewEmail.sendKeys(Email);
        return this;
    }

    @Step("Click to change email button.")
    public MyAccountPage buttonEditEmailClick() {
        buttonEditEmail.click();
        return this;
    }

    @Step("Check success sing in user`s personal account.")
    public MyAccountPage checkSignIn() {
        Assert.assertTrue(successSingIn.isDisplayed());
        System.out.println("Login is passed");
        return this;
    }

    @Step("Check trying to sing in with incorrect data.")
    public MyAccountPage checkIncorrectData() {
        Assert.assertTrue(failedSignIn.isDisplayed());
        System.out.println("Russian localization is available");
        return this;
    }
}
