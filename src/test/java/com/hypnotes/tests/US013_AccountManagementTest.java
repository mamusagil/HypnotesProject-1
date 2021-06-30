package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.US013_AccountManagement;
import com.hypnotes.utilities.ReusableMethods;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US013_AccountManagementTest {
    US013_AccountManagement us013_accountManagement= new US013_AccountManagement();
    WebDriver driver= Driver.getDriver();

    @Test(priority = 1)
    public void validPhoneTest() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("hypnotes_link"));
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        us013_accountManagement.loginMethod();
        us013_accountManagement.settings.click();
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("4234123301");
        us013_accountManagement.sendVerificationButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(us013_accountManagement.confirmBtn.isDisplayed());
        driver.navigate().refresh();
        Thread.sleep(3000);

    }
    @Test(priority = 2)
    public void invalidPhoneTest()  {
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("42341");
        us013_accountManagement.sendVerificationButton.click();
        String message= us013_accountManagement.message.getText();
        Assert.assertEquals(message,"Please Enter Your Security Code and Confirm in 120 seconds...");
        driver.navigate().refresh();
        }
    @Test(priority = 3)
    public void sendCodeTest()  {
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("1423412330");
        us013_accountManagement.sendVerificationButton.click();
        Assert.assertEquals(us013_accountManagement.verificationSMSsent.getText(), "Verification SMS sent!");
        us013_accountManagement.securityCodeInput.sendKeys("3453452");
        String message = us013_accountManagement.toastMessage.getText();
        Assert.assertEquals(message, "Verification code is successfully sent your phone.");
        driver.navigate().refresh();
    }
        @Test(priority = 4)
        public void wrongSecurityCodeTest()  {
            us013_accountManagement.verificationBtn.click();
            us013_accountManagement.phoneInputBox.sendKeys("1423412330");
            us013_accountManagement.sendVerificationButton.click();
            ReusableMethods.waitForVisibility(us013_accountManagement.securityCodeInput,5);
            us013_accountManagement.securityCodeInput.sendKeys("3453452");
            ReusableMethods.waitForClickablility(us013_accountManagement.confirmBtn,5);
            us013_accountManagement.confirmBtn.click();
            String message = us013_accountManagement.toastMessage.getText();
            System.out.println("message = " + message);
            Assert.assertEquals(message, "Your security code has expired or wrong!");
           Driver.closeDriver();
        }
    @Test(priority = 6)
    public void timeElapsedSecurityCodeTest() throws InterruptedException {
          us013_accountManagement.phoneInputBox.sendKeys("5667");
          us013_accountManagement.sendVerificationButton.click();
        Thread.sleep(124000);
        us013_accountManagement.confirmBtn.click();
       String message = us013_accountManagement.toastMessage.getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message, "Your security code has expired");
        Driver.closeDriver();
    }
    @Test(priority = 5)
    public void cancelPhoneVerificationTest() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("hypnotes_link"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        us013_accountManagement.loginMethod();
        us013_accountManagement.settings.click();
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("1423412330");
        //ReusableMethods.waitForClickablility(us013_accountManagement.sendVerificationButton,10);
         Thread.sleep(5000);
        us013_accountManagement.sendVerificationButton.click();
       // ReusableMethods.waitForClickablility(us013_accountManagement.cancelBtn,10);
        us013_accountManagement.cancelBtn.click();
        driver.navigate().refresh();
    }
    }



