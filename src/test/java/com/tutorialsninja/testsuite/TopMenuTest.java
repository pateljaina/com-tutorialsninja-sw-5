package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homepage;
    DesktopsPage desktopsPage;
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage;
    ComponentsPage componentsPage;
    //HomePage homepage = new HomePage();
    //DesktopsPage desktopsPage = new DesktopsPage();
    //LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
    //ComponentsPage componentsPage = new ComponentsPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homepage.mouseHoverAndClickDesktopTab();
        homepage.selectAllDesktopsMenu();
        String expectedMessage = "Desktops";
        Assert.assertEquals(desktopsPage.getVerifyDesktopsText(), expectedMessage, "Not directed to Desktops Page");
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homepage.mouseHoverAndClickLaptopsAndNotebooksTab();
        homepage.selectShowAllLaptopsAndNotebooks();
        String expectedMessage = "Laptops & Notebooks";
        Assert.assertEquals(laptopsAndNoteBooksPage.getVerifyLaptopsAndNotebooksText(),expectedMessage,"Not directed to Laptops and Notebooks page successfully");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homepage.mouseHoverAndClickComponents();
        homepage.selectShowAllComponents();
        String expectedMessage = "Components";
        Assert.assertEquals(componentsPage.getVerifyComponentsText(), expectedMessage,"Not directed to components page successfully");
    }
}
