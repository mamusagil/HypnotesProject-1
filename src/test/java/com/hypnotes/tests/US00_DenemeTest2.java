package com.hypnotes.tests;

import com.hypnotes.pages.US00_SmokeTestPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US00_DenemeTest2 extends TestBaseFinal {
    US00_SmokeTestPage US00DenemePage =new US00_SmokeTestPage();
    @Test
    public void negativeLoginTest() throws InterruptedException {
        Thread.sleep(3000);
        extentTest  = extentReports.createTest("Login","To login to Hypnotes website with valid username ve password");
        extentTest.info("Go to the web site");

        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        Thread.sleep(5000);

        extentTest.info("Click login button on homepage ");
        US00DenemePage.loginButton.click();

        extentTest.info("Send invalid username");
        US00DenemePage.emailBox.sendKeys("ssss@gmail.com");

       extentTest.info("Send invalid password");
        US00DenemePage.passwordBox.sendKeys("ssss");

        extentTest.info("Click login button");
        US00DenemePage.loginButton1.click();


        extentTest.info("Assert login page");

        Assert.assertTrue(US00DenemePage.wrongCreText.isDisplayed());

        System.out.println("NegativeLogin test passed");

    }
}
