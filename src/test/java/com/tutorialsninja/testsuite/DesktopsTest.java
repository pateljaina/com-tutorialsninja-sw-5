package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    //HomePage homepage = new HomePage();
    //DesktopsPage desktopsPage = new DesktopsPage();
    //LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    //ComponentsPage componentsPage = new ComponentsPage();
    //ShoppingCart shoppingCart = new ShoppingCart();

    HomePage homepage;
    DesktopsPage desktopsPage;
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage;
    ComponentsPage componentsPage;
    ShoppingCart shoppingCart;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
        shoppingCart = new ShoppingCart();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        homepage.mouseHoverAndClickDesktopTab();
        homepage.selectAllDesktopsMenu();
        desktopsPage.sortOptionZtoA();
        //verify products will arrange in descending order
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        homepage.mouseHoverAndClickDesktopTab();
        homepage.selectAllDesktopsMenu();
        desktopsPage.sortOptionAtoZ();
        desktopsPage.selectHPLP3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktopsPage.getVerifyHPLP3065Text(), expectedMessage, "Incorrect product");
        desktopsPage.selectRequiredDateFormCalendar("2022", "11", "30");
        desktopsPage.selectCurrencyPounds();
        desktopsPage.clickOnPoundSterlingOption();
        desktopsPage.clickOnQuantityField();
        desktopsPage.changeQuantity();
        Thread.sleep(2000);
        desktopsPage.clickAddToCartButtonHP();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals(desktopsPage.getVerifySuccessMessage(), expectedMessage1, "Product not added to basket");
        Thread.sleep(2000);
        desktopsPage.clickOnLinkShoppingCart();
        Thread.sleep(2000);
        String expectedMessage2 = "Shopping Cart";
        Assert.assertEquals(shoppingCart.verifyShoppingCartText(), expectedMessage2, "Not directed to correct page");
        Thread.sleep(2000);
        String expectedMessage3 = "HP LP3065";
        Assert.assertEquals(shoppingCart.verifyHPProductNameTextHP(), expectedMessage3, "Product Name incorrect");
        Thread.sleep(2000);
        String expectedMessage4 = "Delivery Date:2022-11-30";
        Assert.assertEquals(shoppingCart.verifyDeliveryDateHP(), expectedMessage4, "Incorrect date");
        Thread.sleep(2000);
        String expectedMessage5 = "Product 21";
        Assert.assertEquals(shoppingCart.verifyModelNameHP(), expectedMessage5, "Incorrect Model No");
        Thread.sleep(2000);
        String expectedMessage6 = "£74.73";
        Assert.assertEquals(shoppingCart.verifyPriceHP(), expectedMessage6, "Incorrect Price");
    }
}


