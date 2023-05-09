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

public class HomePage extends Utility {

    //By deskTopTab = By.xpath("//a[text()='Desktops']");
    //By laptopsAndNotebooksTab = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    //By componentsTab = By.xpath("//a[normalize-space()='Components']");

    @CacheLookup
    @FindBy(xpath = "//a[text()='Desktops']")
    WebElement deskTopTab;

    @CacheLookup
    @FindBy(linkText = "Show All Desktops")
    List<WebElement> showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksTab;

    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    List<WebElement> showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement componentsTab;

    @CacheLookup
    @FindBy(linkText = "Show All Components")
    List<WebElement> showAllComponents;


    public void mouseHoverAndClickDesktopTab() {
        Reporter.log("Mouse hover and click Desktops Tab" + deskTopTab.toString());
        mouseHoverToElementAndClick(deskTopTab);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click Desktops Tab");
    }

    public void mouseHoverAndClickLaptopsAndNotebooksTab() {
        Reporter.log("Click on Laptops and Notebooks Tab" + laptopsAndNotebooksTab.toString());
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click LaptopsAndNotebooks Tab");
    }

    public void mouseHoverAndClickComponents() {
        Reporter.log("Mouse hover and click components Tab" + componentsTab.toString());
        mouseHoverToElementAndClick(componentsTab);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click Components Tab");
    }

    public void selectAllDesktopsMenu() {
        Reporter.log("Select link Show all desktops" + showAllDesktops.toString());
        clickOnElement(By.linkText("Show AllDesktops"));
        CustomListeners.test.log(Status.PASS, "Select link Show all desktops");

    }

    public void selectShowAllLaptopsAndNotebooks() {
        Reporter.log("Select link Show all Laptops and Notebooks" + showAllLaptopsAndNotebooks.toString());
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        CustomListeners.test.log(Status.PASS, "Select link Show all Laptops and Notebooks");
    }

    public void selectShowAllComponents() {
        Reporter.log("Select link Show all Components" + showAllComponents.toString());
        clickOnElement(By.linkText("Show AllComponents"));
        CustomListeners.test.log(Status.PASS, "Show all components");

    }
}
