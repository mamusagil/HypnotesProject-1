package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.ServicesPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.annotations.BeforeTest;

public class US27_ServicesGroupSessionTest extends ReusableMethods {

    com.hypnotes.pages.CommonPage CommonPage =new CommonPage();
    ServicesPage services = new ServicesPage();

    @BeforeTest
    public void login() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_linkm"));
        CommonPage.loginButton.click();
        ReusableMethods.waitFor(1);
        CommonPage.emailBox.sendKeys(ConfigurationReader.getProperty("mukremin-email"));
        ReusableMethods.waitFor(1);
        CommonPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password-mukremin"));
        ReusableMethods.waitFor(1);
        CommonPage.loginButton1.click();
        ReusableMethods.waitFor(1);
    }


}
