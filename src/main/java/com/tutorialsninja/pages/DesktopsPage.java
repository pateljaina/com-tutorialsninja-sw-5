package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class DesktopsPage extends Utility {
    //By desktopsText = By.xpath("//h2[text()='Desktops']");
    //By sortOption = By.id("input-sort");
    //By hplp3065Link = By.linkText("HP LP3065");
    //By hplp3065PageText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    //By currencyDropDown = By.xpath("//i[@class='fa fa-caret-down']");
    //By poundSterlingOption = By.xpath("//button[normalize-space()='£Pound Sterling']");
    //By quantityField = By.xpath("//input[@id='input-quantity']");
    //By addToCartButtonHP = By.xpath("//button[@id='button-cart']");
    //By successMessageHP = By.xpath("//div[text()='Success: You have added ']");
    //By shoppingCartbutton = By.xpath("//a[contains(text(),'shopping cart')]");
    @CacheLookup
    @FindBy(xpath = "//h2[text()='Desktops']")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortOption;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement hplp3065Link;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement hplp3065PageText;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-caret-down']")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement poundSterlingOption;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantityField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButtonHP;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Success: You have added ']")
    WebElement successMessageHP;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartbutton;


    public String getVerifyDesktopsText() {
        Reporter.log("Get text from" + desktopsText.toString());
        String message = getTextFromElement(desktopsText);
        CustomListeners.test.log(Status.PASS, " Get desktopsText");
        return message;
    }

    public String getVerifyHPLP3065Text() {
        Reporter.log("Get text from" + hplp3065PageText.toString());
        String message = getTextFromElement(hplp3065PageText);
        CustomListeners.test.log(Status.PASS, "Get hplp3065PageText");
        return message;

    }

    public String getVerifySuccessMessage() {
        Reporter.log("Get text from" + successMessageHP.toString());
        String message = getTextFromElement(successMessageHP);
        CustomListeners.test.log(Status.PASS, "Get successMessageHP");
        return message;
    }

    public void sortOptionZtoA() {
        Reporter.log("Selected text from Drop down" + sortOption.toString());
        selectByVisibleTextFromDropDown(sortOption, "Model (Z - A)");
        CustomListeners.test.log(Status.PASS, "Model (Z - A)");
    }

    public void sortOptionAtoZ() {
        Reporter.log("Selected text from Drop down" + sortOption.toString());
        selectByVisibleTextFromDropDown(sortOption, "Model (A - Z)");
        CustomListeners.test.log(Status.PASS, "Model (A - Z)");
    }

    public void selectCurrencyPounds() {
        Reporter.log("Selected text from Drop down" + sortOption.toString());
        clickOnElement(currencyDropDown);
        CustomListeners.test.log(Status.PASS, "Model (A - Z)");

    }

    public void clickOnPoundSterlingOption() {
        Reporter.log("Click on Pound Sterling Option" + poundSterlingOption.toString());
        clickOnElement(poundSterlingOption);
        CustomListeners.test.log(Status.PASS, "Click on Pound Sterling Option");

    }

    public void selectHPLP3065() {
        Reporter.log("Click on HPLP3065 product Link" + hplp3065Link.toString());
        clickOnElement(hplp3065Link);
        CustomListeners.test.log(Status.PASS, "Click on hplp3065Link");
    }

    public void clickOnQuantityField() {
        Reporter.log("Click on Quantity field" + quantityField.toString());
        clickOnElement(quantityField);
        CustomListeners.test.log(Status.PASS, "Click on Quantity Field");

    }

    public void changeQuantity() {
        Reporter.log("Change quantity to 1" + quantityField.toString());
        sendTextToElement(quantityField, "1");
        CustomListeners.test.log(Status.PASS, "Change quantity to 1");
    }

    public void clickAddToCartButtonHP() {
        Reporter.log("Click on add to cart button" + addToCartButtonHP.toString());
        clickOnElement(addToCartButtonHP);
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
    }

    public void clickOnLinkShoppingCart() {
        Reporter.log("Click on shopping cart" + shoppingCartbutton.toString());
        clickOnElement(shoppingCartbutton);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }

    public void selectRequiredDateFormCalendar(String year, String month, String date) {
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }


}
