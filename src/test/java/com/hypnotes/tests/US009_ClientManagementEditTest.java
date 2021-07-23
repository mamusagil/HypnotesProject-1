package com.hypnotes.tests;
import com.hypnotes.pages.US009_ClientManagementEdit;
import com.hypnotes.pages.US013_AccountManagement;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
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
     Alert alert ;
    @Test
    public void TestClientManagement() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("hypnotes_link"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        us_013accountManagement.loginByLinkedinMethod();
        us_013accountManagement.viewButton.click();
        ReusableMethods.clickWithJS(us_013accountManagement.agreementButton1);
        us_013accountManagement.nextButton.click();
        js.executeScript("window.scrollBy(0,1000)");
        ReusableMethods.clickWithJS(us_013accountManagement.agreementButton2);
        ReusableMethods.waitFor(2);
        us_013accountManagement.submitButton.click();
        clientManagement.navigateToClientTabs();
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        clientManagement.editButton.click();
        ReusableMethods.waitFor(3);
        clientManagement.inputValidValues("Rayaan", "Hayat", "45654654654", "Student");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Client Info has been successfully updated!✅");
        js.executeScript("window.scrollBy(0,0)");
        // us_013accountManagement.logoutMethod();
      //  src/test/resources/Todd-Haynes-2017.jpeg
    }



    @Test
    public void editName_withInValid_Credentials() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("hypnotes_link"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        us_013accountManagement.loginByLinkedinMethod();
        clientManagement.navigateToClientTabs();
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        clientManagement.editButton.click();
        clientManagement.invalidValues("hi434", "sdh", "435345", "teacher");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Name should not include any digit or special characters");
      //  loginPage.logoutMethod();

    }
    @Test
    public void editSurname_withInValid_CredentialsTest() throws InterruptedException {
     // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues("hi", "sdh*6", "435345", "teacher");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Surname should not include any digit or special characters");
      //  loginPage.logoutMethod();
    }
    @Test
    public void editTelephone_withInValid_CredentialsTest() throws InterruptedException {
     // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues("Esref", "Balks", "435345*7", "teacher");
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Please enter valid phone number.");
      //  loginPage.logoutMethod();
    }
    @Test
    public void requriedFieldsMustnot_beEmptyTest() throws InterruptedException {
      // loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        clientManagement.invalidValues(" ", " ", " ", "teacher");
        Thread.sleep(3000);
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Required Fields must be filled");
    //    loginPage.logoutMethod();

    }
    @Test
    public void cancelButtonTest() throws InterruptedException {
     //   loginPage.loginMethod();
        clientManagement.navigateToClientTabs();
        Assert.assertTrue(clientManagement.cancelButton());
       // loginPage.logoutMethod();
    }
}
