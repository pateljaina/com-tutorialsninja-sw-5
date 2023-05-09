package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.Utilities.Utility;
import com.tutorialsninja.customlisteners.CustomListeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement componentsText;
    //By componentsText = By.xpath("//h2[normalize-space()='Components']");

    public String getVerifyComponentsText() {
        Reporter.log("Get text from" + componentsText.toString());
        String message = getTextFromElement(componentsText);
        CustomListeners.test.log(Status.PASS, " Get Components Text");
        return message;
    }

}
