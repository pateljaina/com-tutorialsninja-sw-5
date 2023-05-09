package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopsAndNoteBooksTest extends BaseTest {
    //HomePage homepage = new HomePage();
    //DesktopsPage desktopsPage = new DesktopsPage();
    //LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    // ComponentsPage componentsPage = new ComponentsPage();
    //ShoppingCart shoppingCart = new ShoppingCart();
    //Checkout checkout = new Checkout();
    HomePage homepage;
    DesktopsPage desktopsPage;
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage;
    ComponentsPage componentsPage;
    ShoppingCart shoppingCart;
    Checkout checkout;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
        shoppingCart = new ShoppingCart();
        checkout = new Checkout();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homepage.mouseHoverAndClickLaptopsAndNotebooksTab();
        homepage.selectShowAllLaptopsAndNotebooks();
        laptopsAndNoteBooksPage.sortOptionPriceHighToLow();
        //verify The products will arrange in high to low order.
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlacesOrderSuccessfully() {
        homepage.mouseHoverAndClickLaptopsAndNotebooksTab();
        homepage.selectShowAllLaptopsAndNotebooks();
        laptopsAndNoteBooksPage.sortOptionPriceHighToLow();
        laptopsAndNoteBooksPage.clickOnProductMacBook();
        String expectedMessage1 = "MacBook";
        Assert.assertEquals(laptopsAndNoteBooksPage.getVerifyMacBookText(), expectedMessage1, "Product not added to cart");
        laptopsAndNoteBooksPage.clickOnMacBookAddToCartButton();
        String expectedMessage2 = "Success: You have added MacBook to your shopping cart!";
        Assert.assertEquals(laptopsAndNoteBooksPage.getMacbookAddedToCartSuccessfully(), expectedMessage2, "Product not added successfully");
        laptopsAndNoteBooksPage.clickOnShoppingCartSuccess();
        String expectedMessage3 = "Shopping Cart";
        Assert.assertEquals(shoppingCart.verifyShoppingCartTextMacbook(), expectedMessage1, "Not directed to correct page");
        String expectedMessage4 = "MacBook";
        Assert.assertEquals(shoppingCart.verifyProductNameMacbook(), expectedMessage4, "Product name does not match");
        // shoppingCart.clearQuantityField();
        shoppingCart.changeQuantityTo2();
        shoppingCart.clickOnUpdateTab();
        String expectedMessage5 = "Success: You have modified your shopping cart!";
        Assert.assertEquals(shoppingCart.verifyModifySuccessMessage(), expectedMessage5, "Cart not modified");
        String expectedMessage6 = "£737.45";
        Assert.assertEquals(shoppingCart.verifyMacbookTotalPrice(), expectedMessage6, "Total price does not match");
        String expectedMessage7 = "Checkout";
        Assert.assertEquals(checkout.verifyCheckOutTitle(), expectedMessage7, "Not directed to correct page");
        String expectedMessage8 = "New Customer";
        Assert.assertEquals(checkout.verifyNewCustomer(), expectedMessage8, "Text Not matched");
        checkout.clickOnGuestCheckoutRadioButton();
        checkout.clickOnContinueTab();
        checkout.enterFirstName("Jaina");
        checkout.enterLastName("Patel");
        checkout.enterEmail("pateljgp@gmail.com");
        checkout.enterPhoneNumber("07999999999");
        checkout.enterAddress1("1 Littleheath Road");
        checkout.enterCity("London");
        checkout.enterZipPostalCode("CR27SS");
        checkout.selectCountry();
        checkout.selectRegion();
        checkout.clickOnContinueButton();
        checkout.enterNotesInComments("Please ship promptly");
        checkout.clickOnTermsAndConditionsCheckBox();
        checkout.clickOnContinuePaymentMethodButton();
        String expectedMessage9 = "Warning: Payment method required!";
        Assert.assertEquals(checkout.verifyWarningMessage(), expectedMessage9, "Incorrect message displayed");
    }
}
