package com.hypnotes.tests;

import com.hypnotes.pages.US09_ClientManagementPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import org.testng.annotations.Test;


public class US09_ClientManagementTest {
    US09_ClientManagementPage clientManagementPage = new US09_ClientManagementPage();


    @Test
    public void ConnectingWebsiteTest() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));

        clientManagementPage.login.click();
        clientManagementPage.username.sendKeys(ConfigurationReader.getProperty("userSlm"));
        clientManagementPage.password.sendKeys(ConfigurationReader.getProperty("passwordSlm"));
        clientManagementPage.loginButton.click();
        Thread.sleep(2000);

    }
}

