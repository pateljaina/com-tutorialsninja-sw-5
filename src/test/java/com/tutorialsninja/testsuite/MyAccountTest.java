package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    MyAccount myAccount;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccount = new MyAccount();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        String expectedMessage1 = "Register Account";
        Assert.assertEquals(myAccount.getRegisterText(), expectedMessage1, "Not directed to correct page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        String expectedMessage2 = "Returning Customer";
        Assert.assertEquals(myAccount.getReturningCustomerText(), expectedMessage2, "Not directed to current page");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterFirstname("Jaina");
        myAccount.enterLastname("Patel");
        myAccount.enterEmail("pateljgp@gmail.com");
        myAccount.enterTelephone("07999999999");
        myAccount.enterPassword("Prime12345");
        myAccount.enterConfirmPassword("Prime12345");
        myAccount.selectRadioButton();
        myAccount.clickONPrivacyCheck();
        myAccount.clickOnContinueButton();
        String expectedMessage1 = "Your Account Has Been Created";
        Assert.assertEquals(myAccount.getRegistrationConfirmMessage(), expectedMessage1, "Error creating account");
        myAccount.clickOnContinueButton2();
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage2 = "Account Logout";
        Assert.assertEquals(myAccount.getLogoutMessage(), expectedMessage2, "Text does not match");
        myAccount.clickOnContinueButton2();

    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        loginPage.enterEmail("pateljgp@gmail.com");
        loginPage.enterPassword("Prime12345");
        loginPage.clickOnLoginButton();
        String expectedMessage1 = "My Account";
        Assert.assertEquals(loginPage.getMyAccountText(), expectedMessage1, "Not directed to My account page");
        myAccount.selectMyAccountOptions("Logout");
        String expectedMessage2 = "Account Logout";
        Assert.assertEquals(loginPage.getMyAccountLogoutText(), expectedMessage2, "Not logged out");
        loginPage.clickOnContinueButton();
    }
}
