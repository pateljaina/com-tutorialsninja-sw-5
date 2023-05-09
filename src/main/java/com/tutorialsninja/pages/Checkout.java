package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Checkout extends Utility {
    //By checkoutTitle = By.xpath("//h1[normalize-space()='Checkout']");
    //By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
    //By radioGuestCheckout = By.xpath("//input[@value='guest']");
    //By continueTab = By.id("button-account");
    //By firstNameField = By.id("input-payment-firstname");
    //By lastNameField = By.id("input-payment-lastname");
    //By emailField = By.id("input-payment-email");
    //By phoneNumber = By.id("input-payment-telephone");
    //By address1Field = By.id("input-payment-address-1");
    //By cityField = By.id("input-payment-city");
    //By zipPostalCode = By.id("input-payment-postcode");
    //By country = By.id("input-payment-country");
    //By region = By.id("input-payment-zone");
    //By continueButton = By.id("button-guest");
    //By notesArea = By.xpath("textarea[name='comment']");
    //By checkboxAgree = By.xpath("//input[@name='agree']");
    //By continuePaymentMethodButton = By.id("button-payment-method");
    //By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkoutTitle;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement radioGuestCheckout;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueTab;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement zipPostalCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement region;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "textarea[name='comment']")
    WebElement notesArea;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkboxAgree;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement continuePaymentMethodButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public String verifyCheckOutTitle() {
        Reporter.log("Verify checkout title" + checkoutTitle.toString());
        String message = getTextFromElement(checkoutTitle);
        CustomListeners.test.log(Status.PASS, "Verify checkout title");
        return message;
    }

    public String verifyNewCustomer() {
        Reporter.log("Verify New Customer text" + newCustomerText.toString());
        String message = getTextFromElement(newCustomerText);
        CustomListeners.test.log(Status.PASS, "Verify new customer text");
        return message;
    }

    public String verifyWarningMessage() {
        Reporter.log("Verify warning Message" + warningMessage.toString());
        String message = getTextFromElement(warningMessage);
        CustomListeners.test.log(Status.PASS, "Verify warning message");
        return message;
    }

    public void clickOnGuestCheckoutRadioButton() {
        Reporter.log("Click on Guest checkout button" + radioGuestCheckout.toString());
        clickOnElement(radioGuestCheckout);
        CustomListeners.test.log(Status.PASS, "Click on Guest Checkout radio button");

    }

    public void clickOnContinueTab() {
        Reporter.log("Click on continue Tab" + continueTab.toString());
        clickOnElement(continueTab);
        CustomListeners.test.log(Status.PASS, "Click on Continue tab");
    }

    public void enterFirstName(String firstname) {
        Reporter.log("Enter First name " + firstname + " to first name field " + firstNameField.toString());
        sendTextToElement(firstNameField, firstname);
        CustomListeners.test.log(Status.PASS, "Enter firstName" + firstname);
    }

    public void enterLastName(String lastName) {
        Reporter.log("Enter Last name " + lastName + " to last name field " + lastNameField.toString());
        sendTextToElement(lastNameField, lastName);
        CustomListeners.test.log(Status.PASS, "Enter lastName" + lastName);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter emailID" + email);
    }

    public void enterPhoneNumber(String phoneNo) {
        Reporter.log("Enter phone number " + phoneNo + " Phone number field " + phoneNo.toString());
        sendTextToElement(phoneNumber, phoneNo);
        CustomListeners.test.log(Status.PASS, "Enter phoneNumber" + phoneNo);
    }

    public void enterAddress1(String address1) {
        Reporter.log("Enter first line of address " + address1 + " to address1 field" + address1Field.toString());
        sendTextToElement(address1Field, address1);
        CustomListeners.test.log(Status.PASS, "Enter address1" + address1);
    }

    public void enterCity(String cityName) {
        Reporter.log("Enter City name " + cityName + "to City field" + cityField.toString());
        sendTextToElement(cityField, cityName);
        CustomListeners.test.log(Status.PASS, "Enter cityName" + cityName);
    }

    public void enterZipPostalCode(String postCode) {
        Reporter.log("Enter postcode " + postCode + " to postcode field" + zipPostalCode.toString());
        sendTextToElement(zipPostalCode, postCode);
        CustomListeners.test.log(Status.PASS, "Enter postCode" + postCode);
    }

    public void enterNotesInComments(String comment) {
        Reporter.log("Enter notes in comments " + comment + " to comments field" + notesArea.toString());
        sendTextToElement(notesArea, comment);
        CustomListeners.test.log(Status.PASS, "Enter comment");
    }

    public void selectCountry() {
        Reporter.log("Select United Kingdom" + country.toString());
        selectByVisibleTextFromDropDown(country, "United Kingdom");
        CustomListeners.test.log(Status.PASS, "Enter country" + country);
    }

    public void selectRegion() {
        Reporter.log("Select Greater London" + region.toString());
        selectByVisibleTextFromDropDown(region, "Greater London");
        CustomListeners.test.log(Status.PASS, "Enter region" + region);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on Continue button");
    }

    public void clickOnTermsAndConditionsCheckBox() {
        Reporter.log("Click on Terms and Conditions Check box" + checkboxAgree.toString());
        clickOnElement(checkboxAgree);
        CustomListeners.test.log(Status.PASS, "Click on terms and conditions check box");
    }

    public void clickOnContinuePaymentMethodButton() {
        Reporter.log("Click on continue payment method button" + continuePaymentMethodButton.toString());
        clickOnElement(continuePaymentMethodButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Payment method");
    }
}
