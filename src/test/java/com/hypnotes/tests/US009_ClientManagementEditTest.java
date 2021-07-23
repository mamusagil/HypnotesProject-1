package com.hypnotes.tests;
import com.hypnotes.pages.US009_ClientManagementEdit;
import com.hypnotes.pages.US013_AccountManagement;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US009_ClientManagementEditTest {

    US009_ClientManagementEdit clientManagement = new US009_ClientManagementEdit();
    US013_AccountManagement us_013accountManagement= new US013_AccountManagement();
     WebDriver driver= Driver.getDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test(priority = 1)
    public void TestClientManagement() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us_013accountManagement.loginByLinkedinMethod();
        us_013accountManagement.viewButton.click();
        ReusableMethods.clickWithJS(us_013accountManagement.agreementButton1);
        us_013accountManagement.nextButton.click();
        us_013accountManagement.scrollDownToElement();
        ReusableMethods.waitFor(4);
        ReusableMethods.clickWithJS(us_013accountManagement.agreementButton2);
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(us_013accountManagement.submitButton);
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement();
        Thread.sleep(2000);
        clientManagement.editButton.click();
        ReusableMethods.waitFor(3);
        clientManagement.inputValidValues("Rayaan", "Hayat", "45654654654", "Student");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Client Info has been successfully updated!✅");
        us_013accountManagement.scrollUpToElement();
        ReusableMethods.waitFor(3);
        us_013accountManagement.logout.click();
         Driver.closeDriver();
    }



    @Test(priority = 2)
    public void editName_withInValid_Credentials() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us_013accountManagement.loginByLinkedinMethod();
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement();
        Thread.sleep(2000);
        clientManagement.editButton.click();
        clientManagement.invalidValues("hi434", "sdh", "4353455678", "teacher");
      //  Assert.assertEquals(clientManagement.messageUpdated.getText(), "Name should not include any digit or special characters");
      //  loginPage.logoutMethod();

    }
    @Test(priority = 3)
    public void editSurname_withInValid_CredentialsTest() throws InterruptedException {
     // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues("hi", "sdh*6", "435345", "teacher");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Surname should not include any digit or special characters");
      //  loginPage.logoutMethod();
    }
    @Test(priority = 4)
    public void editTelephone_withInValid_CredentialsTest() throws InterruptedException {
     // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues("Esref", "Balks", "435345*7", "teacher");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Please enter valid phone number.");
      //  loginPage.logoutMethod();
    }
    @Test(priority = 5)
    public void requriedFieldsMustnot_beEmptyTest() throws InterruptedException {
      // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues(" ", " ", " ", "teacher");
        Thread.sleep(3000);
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Required Fields must be filled");
    //    loginPage.logoutMethod();

    }
    @Test(priority = 6)
    public void cancelButtonTest() throws InterruptedException {
     //   loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        Assert.assertTrue(clientManagement.cancelButton());
       // loginPage.logoutMethod();
    }
}
