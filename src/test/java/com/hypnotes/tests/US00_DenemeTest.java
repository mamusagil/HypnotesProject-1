package com.hypnotes.tests;

import com.hypnotes.pages.US00_DenemePage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US00_DenemeTest extends ReusableMethods {
    US00_DenemePage US00DenemePage =new US00_DenemePage();

    @Test
public void loginTest() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        US00DenemePage.loginButton.click();


        US00DenemePage.emailBox.sendKeys(ConfigurationReader.getProperty("semra-email"));
        US00DenemePage.passwordBox.sendKeys(ConfigurationReader.getProperty("semra-password"));
        US00DenemePage.loginButton1.click();


        Assert.assertTrue(US00DenemePage.afterLogin.isDisplayed());
        System.out.println("Login test passed");
        Thread.sleep(3000);
        ReusableMethods.clickWithJS(US00DenemePage.logoutButton);
        Thread.sleep(3000);

        // methodla login yapma
        login(ConfigurationReader.getProperty("semra-email"),ConfigurationReader.getProperty("semra-password"));
        //methodla logout yapma
        logout();

    }
}
