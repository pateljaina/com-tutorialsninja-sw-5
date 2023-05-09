package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    //By myAccount = By.xpath(" //span[contains(text(),'My Account')]");
    //By emailField = By.id("input-email");
    //By passwordField = By.id("input-password");
    //By loginButton = (By.xpath("//form[contains(@action,'login')]//input[@type='submit']"));
    //By accountText = By.xpath("//div[@class='col-sm-9']/h2[contains(text(),'My Account')]");
    //By myAccountText = By.xpath("//h1[contains(text(),'Account Logout')]");
    //By continueButton = By.xpath("//div[@class='pull-right']//a");

    @CacheLookup
    @FindBy(xpath = " //span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-9']/h2[contains(text(),'My Account')]")
    WebElement accountText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement myAccountText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='pull-right']//a")
    WebElement continueButton;

    public void clickOnMyAccount() {
        Reporter.log("Click on Product Macbook" + myAccount.toString());
        clickOnElement(myAccount);
        CustomListeners.test.log(Status.PASS, "Click on My Account");
    }

    public void enterEmail(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on Login button");
    }

    public String getMyAccountLogoutText() {
        Reporter.log("Get text from" + myAccountText.toString());
        String message = getTextFromElement(myAccountText);
        CustomListeners.test.log(Status.PASS, " Get my account logout text");
        return message;
    }

    public String getMyAccountText() {
        Reporter.log("Get text from" + accountText.toString());
        String message = getTextFromElement(accountText);
        CustomListeners.test.log(Status.PASS, " Get My Account text");
        return message;
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on Continue button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on Continue button");
    }
}
