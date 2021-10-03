package com.hypnotes.tests;

import com.hypnotes.pages.US00_SmokeTestPage;
import com.hypnotes.pages.US077_Services;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US077_ServicesTest extends ReusableMethods {
    US00_SmokeTestPage us00DenemePage =new US00_SmokeTestPage();
    US077_Services us077_services = new US077_Services();


    @BeforeTest
    public void login() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_linkm"));
        us00DenemePage.loginButton.click();
        ReusableMethods.waitFor(1);
        us00DenemePage.emailBox.sendKeys(ConfigurationReader.getProperty("mukremin-email"));
        ReusableMethods.waitFor(1);
        us00DenemePage.passwordBox.sendKeys(ConfigurationReader.getProperty("password-mukremin"));
        ReusableMethods.waitFor(1);
        us00DenemePage.loginButton1.click();
        ReusableMethods.waitFor(1);

    }

    @Test(priority = 1)
    public void servicesCategory(){
        us077_services.servicesButton.click();
        us077_services.categoryButton.click();
        ReusableMethods.waitFor(1);
        us077_services.addNewCategory.click();
        ReusableMethods.waitFor(1);
    }


    @Test(priority = 2)
    public void servicesAdd(){



}




}
