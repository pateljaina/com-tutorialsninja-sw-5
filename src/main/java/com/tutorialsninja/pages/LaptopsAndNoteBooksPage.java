package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNoteBooksPage extends Utility {
    //By laptopsAndNotebooksText = By.xpath("//h2[normalize-space()='Laptops & Notebooks']");
    //By sortOption = By.id("input-sort");
    //By macBookProduct = By.linkText("MacBook");
    //By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    //By macBookAddToCartButton = By.xpath("//button[@id='button-cart']");
    //By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    //By macBookSuccessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible'][contains(.,'Success: You have added MacBook to your shopping cart!')][1]");

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortOption;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookProduct;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement macBookAddToCartButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'][contains(.,'Success: You have added MacBook to your shopping cart!')][1]")
    WebElement macBookSuccessMessage;


    public String getVerifyLaptopsAndNotebooksText() {
        Reporter.log("Get text from" + laptopsAndNotebooksText.toString());
        String message = getTextFromElement(laptopsAndNotebooksText);
        CustomListeners.test.log(Status.PASS, " Get Laptops and Notebooks Text");
        return message;
    }

    public String getVerifyMacBookText() {
        Reporter.log("Get text from" + macBookText.toString());
        String message = getTextFromElement(macBookText);
        CustomListeners.test.log(Status.PASS, " Get Macbook Text");
        return message;
    }

    public String getMacbookAddedToCartSuccessfully() {
        Reporter.log("Get text from" + macBookSuccessMessage.toString());
        String message = getTextFromElement(macBookSuccessMessage);
        CustomListeners.test.log(Status.PASS, " Get Macbook Added To Cart Successfully Text");
        return message;
    }

    public void sortOptionPriceHighToLow() {
        Reporter.log("Select sort option High to Low" + sortOption.toString());
        selectByVisibleTextFromDropDown(sortOption, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS, "Select sort option High to Low");

    }

    public void clickOnProductMacBook() {
        Reporter.log("Click on Product Macbook" + macBookProduct.toString());
        clickOnElement(macBookProduct);
        CustomListeners.test.log(Status.PASS, "Click on product MacBook");
    }

    public void clickOnMacBookAddToCartButton() {
        Reporter.log("Click on Add Macbook to Cart button" + macBookAddToCartButton.toString());
        clickOnElement(macBookAddToCartButton);
        CustomListeners.test.log(Status.PASS, "Click on add Macbook to cart");
    }

    public void clickOnShoppingCartSuccess() {
        Reporter.log("Click on shopping cart in success message" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart link from success message");
    }

}
