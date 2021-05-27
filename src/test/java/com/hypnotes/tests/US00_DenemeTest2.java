package com.hypnotes.tests;

import com.hypnotes.pages.US00_DenemePage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US00_DenemeTest2 {
    US00_DenemePage US00DenemePage =new US00_DenemePage();
    @Test
    public void negativeLoginTest() throws InterruptedException {
        Thread.sleep(3000);
       // extentTest  = extentReports.createTest("Login","To login to Hypnotes website with valid username ve password");
       // extentTest.info("Go to the web site");
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        Thread.sleep(5000);
       // extentTest.info("Click login button on homepage ");
        US00DenemePage.loginButton.click();

       // extentTest.info("Send invalid username");
        US00DenemePage.emailBox.sendKeys("ssss@gmail.com");
    //    extentTest.info("Send invalid password");
        US00DenemePage.passwordBox.sendKeys("ssss");

      //  extentTest.info("Click login button");
        US00DenemePage.loginButton1.click();


     //   extentTest.info("Assert login page");

        Assert.assertTrue(US00DenemePage.wrongCreText.isDisplayed());

        System.out.println("NegativeLogin test passed");

    }
}
