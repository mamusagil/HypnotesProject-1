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
    // WebDriver driver= Driver.getDriver();
    @Test(priority = 1)
    public void validPhoneTest() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us013_accountManagement.loginByLinkedinMethod();
        us013_accountManagement.settings.click();
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("4234123012");
        us013_accountManagement.sendVerificationButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(us013_accountManagement.confirmBtn.isDisplayed());
        Driver.getDriver().navigate().refresh();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void verificationSmsSendTest()  {
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("435345432");
        us013_accountManagement.sendVerificationButton.click();
        Assert.assertEquals(us013_accountManagement.verificationSMSsent.getText(), "Verification SMS sent!");
        Driver.getDriver().navigate().refresh();
    }
    @Test(priority = 3)
    public void sendCodeTest()throws InterruptedException  {
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("1423412330");
        us013_accountManagement.sendVerificationButton.click();
        us013_accountManagement.securityCodeInput.sendKeys("3453452");
        String message = us013_accountManagement.toastMessage.getText();
        Thread.sleep(2000);
        Assert.assertEquals(message, "Verification code is successfully sent your phone.");
        Driver.getDriver().navigate().refresh();
    }
    @Test(priority = 4)
    public void wrongSecurityCodeTest() throws InterruptedException {
        us013_accountManagement.settings.click();
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("1423412330");
        us013_accountManagement.sendVerificationButton.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForVisibility(us013_accountManagement.securityCodeInput,5);
        us013_accountManagement.securityCodeInput.sendKeys("3453452");
        Thread.sleep(3000);
        us013_accountManagement.confirmBtn.click();
        String message = us013_accountManagement.toastMessage.getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message, "Your security code has expired or wrong!");
        Driver.getDriver().navigate().refresh();
    }
    @Test(priority = 6)
    public void timeElapsedSecurityCodeTest() throws InterruptedException {
        us013_accountManagement.verificationBtn.click();
        ReusableMethods.waitForVisibility(us013_accountManagement.phoneInputBox,3);
        us013_accountManagement.phoneInputBox.sendKeys("5667564562");
        us013_accountManagement.sendVerificationButton.click();
        Thread.sleep(124000);
        String message = us013_accountManagement.timefinishedMessage.getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message, "Given time exceed for verification. Please try again...");
        us013_accountManagement.closeButton.click();
        Driver.closeDriver();

    }
    @Test(priority = 5)
    public void cancelPhoneVerificationTest() throws InterruptedException {
        //Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        // us013_accountManagement.loginMethod();
        us013_accountManagement.settings.click();
        us013_accountManagement.verificationBtn.click();
        us013_accountManagement.phoneInputBox.sendKeys("1423412330");
        ReusableMethods.waitForClickablility(us013_accountManagement.sendVerificationButton,4);
        us013_accountManagement.sendVerificationButton.click();
        ReusableMethods.waitForClickablility(us013_accountManagement.cancelBtn,3);
        us013_accountManagement.cancelBtn.click();
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
    }
}


