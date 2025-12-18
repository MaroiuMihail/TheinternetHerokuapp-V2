package com.mihai.theinternet.tests;

import com.mihai.theinternet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAuthenticationTests extends BaseTest {

    @Test
    public void userCanLoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                loginPage.getFlashAlert().contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailsWithInvalidPassword(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tomsmith", "wrong");

        String alert = loginPage.getFlashAlert();

        Assert.assertTrue(alert.contains("Your password is invalid!"),
                "Alert was: " + alert);
    }

    @Test
    public void loginFail_invalidUsername(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tomsmit","SuperSecretPassword!");

        Assert.assertTrue(loginPage.getFlashAlert().contains("Your username is invalid!"));
    }
}
