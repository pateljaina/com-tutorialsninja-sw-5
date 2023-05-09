package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccount extends Utility {
    //By myAccount = By.xpath(" //span[contains(text(),'My Account')]");
    //By registerText = By.xpath("//h1[contains(text(),'Register Account')]");
    //By firstName = By.id("input-firstname");
    //By lastName = By.id("input-lastname");
    //By emailField = By.id("input-email");
    //By telephoneField = By.id("input-telephone");
    //By passwordField = By.id("input-password");
    //By confirmPasswordField = By.id("input-confirm");
    //By privacyCheck = (By.xpath("//div[@class = 'buttons']//input[@name='agree']"));
    //By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    //By continueButton2 = By.xpath("//a[normalize-space()='Continue']");
    //By confirmMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    //By logoutMessage = By.xpath("//div[@class='col-sm-9']/h1");
    //By returningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");

    @CacheLookup
    @FindBy(xpath = " //span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyCheck;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton2;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-9']/h1")
    WebElement logoutMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;


    public void clickOnMyAccount() {
        Reporter.log("Click on My account" + myAccount.toString());
        clickOnElement(myAccount);
        CustomListeners.test.log(Status.PASS, "Click on my account");
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void enterFirstname(String firstname) {
        Reporter.log("Enter first name " + firstname + " to firstname field " + firstName.toString());
        sendTextToElement(firstName, firstname);
        CustomListeners.test.log(Status.PASS, "Enter first name " + firstname);
    }

    public void enterLastname(String lastname) {
        Reporter.log("Enter last name " + lastname + " to lastname field " + lastName.toString());
        sendTextToElement(lastName, lastname);
        CustomListeners.test.log(Status.PASS, "Enter last name " + lastname);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }

    public void enterTelephone(String phone) {
        Reporter.log("Enter telephone number " + phone + " to telephone number field " + telephoneField.toString());
        sendTextToElement(telephoneField, phone);
        CustomListeners.test.log(Status.PASS, "Enter telephone number " + phone);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password" + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter password " + password);

    }

    public void enterConfirmPassword(String confirmPass) {
        Reporter.log("Enter confirm password" + confirmPass + " to confirm password field " + confirmPasswordField.toString());
        sendTextToElement(confirmPasswordField, confirmPass);
        CustomListeners.test.log(Status.PASS, "Enter confirm password " + confirmPass);

    }

    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

    public void clickONPrivacyCheck() {
        Reporter.log("Click on privacy check" + privacyCheck.toString());
        clickOnElement(privacyCheck);
        CustomListeners.test.log(Status.PASS, "Click on privacy check");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void clickOnContinueButton2() {
        Reporter.log("Click on 2nd continue button" + continueButton2.toString());
        clickOnElement(continueButton2);
        CustomListeners.test.log(Status.PASS, "Click on 2nd continue button");
    }

    public String getRegistrationConfirmMessage() {
        Reporter.log("Get registration confirmation message" + confirmMessage.toString());
        String message = getTextFromElement(confirmMessage);
        CustomListeners.test.log(Status.PASS, "Registration confirmation message");
        return message;
    }

    public String getLogoutMessage() {
        Reporter.log("Get logout message" + logoutMessage.toString());
        String message = getTextFromElement(logoutMessage);
        CustomListeners.test.log(Status.PASS, "Get logout message");
        return message;
    }

    public String getRegisterText() {
        Reporter.log("Get register text" + registerText.toString());
        String message = getTextFromElement(registerText);
        CustomListeners.test.log(Status.PASS, "Get register text");
        return message;
    }

    public String getReturningCustomerText() {
        Reporter.log("Get returning customer text" + returningCustomerText.toString());
        String message = getTextFromElement(returningCustomerText);
        CustomListeners.test.log(Status.PASS, "Get returning customer text");
        return message;
    }
}
