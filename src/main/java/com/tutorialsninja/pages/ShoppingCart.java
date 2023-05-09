package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCart extends Utility {
    //By titleShoppingCart = By.xpath("//h1[contains(text(),' (1.00kg)')]");
    //By productNameTextHP = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    //By date = By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]");
    //By modelHP = By.xpath("//td[contains(text(),'Product 21')]");
    //By totalPriceHP = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]");
    //By shoppingCartTextMacbook = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    //By productNameMacbook = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    //By quantityInputField = By.xpath("//input[contains(@name, 'quantity')]");
    //By updateCartMacbook = By.xpath("//button[contains(@data-original-title, 'Update')]");
    //By updateSuccessMacbook = By.xpath("//div[@id='checkout-cart']/div[1]");
    ///By priceMacbook = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    //By checkoutButton = By.linkText("Checkout");
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),' (1.00kg)')]")
    WebElement titleShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productNameTextHP;

    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date:2022-11-30')]")
    WebElement date;

    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement modelHP;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    WebElement totalPriceHP;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartTextMacbook;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameMacbook;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement quantityInputField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateCartMacbook;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement updateSuccessMacbook;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement priceMacbook;

    @CacheLookup
    @FindBy(linkText = "Checkout")
    WebElement checkoutButton;

    public String verifyShoppingCartText() {
        Reporter.log("Get shopping cart text" + titleShoppingCart.toString());
        String message = getTextFromElement(titleShoppingCart);
        CustomListeners.test.log(Status.PASS, "Verify Shopping cart text");
        return message;
    }

    public String verifyHPProductNameTextHP() {
        Reporter.log("Get HP product name text" + productNameTextHP.toString());
        String message = getTextFromElement(productNameTextHP);
        CustomListeners.test.log(Status.PASS, "Verify HP Product name text");
        return message;
    }

    public String verifyDeliveryDateHP() {
        Reporter.log("Get Delivery date text" + date.toString());
        String message = getTextFromElement(date);
        CustomListeners.test.log(Status.PASS, "Verify Delivery date text");
        return message;
    }

    public String verifyModelNameHP() {
        Reporter.log("Get model name text" + modelHP.toString());
        String message = getTextFromElement(modelHP);
        CustomListeners.test.log(Status.PASS, "Verify Model name HP");
        return message;
    }

    public String verifyPriceHP() {
        Reporter.log("Verify price" + totalPriceHP.toString());
        String message = getTextFromElement(totalPriceHP);
        CustomListeners.test.log(Status.PASS, "Verify total price");
        return message;
    }

    public String verifyShoppingCartTextMacbook() {
        Reporter.log("Verify shopping cart text" + shoppingCartTextMacbook.toString());
        String message = getTextFromElement(shoppingCartTextMacbook);
        CustomListeners.test.log(Status.PASS, "Verify shopping cart text Macbook");
        return message;
    }

    public String verifyProductNameMacbook() {
        Reporter.log("Verify product name Macbook text" + productNameMacbook.toString());
        String message = getTextFromElement(productNameMacbook);
        CustomListeners.test.log(Status.PASS, "Verify product name Macbook");
        return message;
    }

    public String verifyModifySuccessMessage() {
        Reporter.log("Verify modified success message" + updateSuccessMacbook.toString());
        String message = getTextFromElement(updateSuccessMacbook);
        CustomListeners.test.log(Status.PASS, "Verify product name Macbook");
        return message;
    }

    public String verifyMacbookTotalPrice() {
        Reporter.log("Verify Macbook Total Price" + priceMacbook.toString());
        String message = getTextFromElement(priceMacbook);
        CustomListeners.test.log(Status.PASS, "Verify Macbook total price");
        return message;

    }

    //public void clearQuantityField() {
    // WebElement quantityInputField.clear();
    // }

    public void changeQuantityTo2() {
        Reporter.log("Change quantity to 2 " + quantityInputField.toString());
        sendTextToElement(quantityInputField, "2");
        CustomListeners.test.log(Status.PASS, "Change quantity to 2");
    }

    public void clickOnUpdateTab() {
        Reporter.log("Click on Update Tab" + updateCartMacbook.toString());
        clickOnElement(updateCartMacbook);
        CustomListeners.test.log(Status.PASS, "Click on update tab");
    }

    public void clickOnCheckoutButton() {
        Reporter.log("Click on CheckOut button" + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on Checkout button");
    }
}
