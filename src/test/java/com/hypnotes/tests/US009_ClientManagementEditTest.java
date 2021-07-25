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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US009_ClientManagementEditTest {

    US009_ClientManagementEdit clientManagement = new US009_ClientManagementEdit();
    US013_AccountManagement us_013accountManagement= new US013_AccountManagement();

    @Test(priority = 1)
    public void TestClientManagement() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us_013accountManagement.loginByLinkedinMethod();
         ReusableMethods.waitFor(3);
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
        clientManagement.inputValidValues("Azimi", "Gencaev", "45654654654", "Student");
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(clientManagement.saveButton);
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Client Info has been successfully updated!✅");
        us_013accountManagement.scrollUpToElement();
        ReusableMethods.waitFor(3);
    }

    @Test(priority = 2)
    public void editName_SUrnamewithInValid_Credentials() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us_013accountManagement.loginByLinkedinMethod();
         ReusableMethods.waitFor(3);
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement();
        Thread.sleep(2000);
        clientManagement.editButton.click();
        clientManagement.inputBoxFirstName.clear();
        ReusableMethods.waitFor(2);
        clientManagement.inputBoxFirstName.sendKeys("Tahsin67*-)6");
        clientManagement.inputBoxFirstName.getAttribute("value");
        clientManagement.inputBoxLastName.clear();
        ReusableMethods.waitFor(2);
        clientManagement.inputBoxLastName.sendKeys("Aga0*6*ü^4=)");
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(clientManagement.saveButton);
        clientManagement.inputBoxLastName.getAttribute("value");
        Assert.assertEquals(clientManagement.inputBoxLastName.getAttribute("value"), "Aga");
        Assert.assertEquals(clientManagement.inputBoxFirstName.getAttribute("value"), "Tahsin");
    }

    @Test(priority = 3)
    public void editTelephone_withInValid_CredentialsTest() throws InterruptedException {
        ReusableMethods.waitFor(2);
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement();
        Thread.sleep(2000);
        clientManagement.editButton.click();
        clientManagement.inputBoxPhoneNumber.clear();
        clientManagement.inputBoxPhoneNumber.sendKeys("0Aga0*566*ü^4=)001");
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(clientManagement.saveButton);
        clientManagement.inputBoxPhoneNumber.getAttribute("value");
        System.out.println(clientManagement.inputBoxPhoneNumber.getAttribute("value"));
        Assert.assertEquals(clientManagement.inputBoxPhoneNumber.getAttribute("value"), "005664001");
    }
//    @Test(priority = 4)
  //  public void WithEmptyFields_beEmptyTest() throws InterruptedException {
//         Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
//         us_013accountManagement.loginByLinkedinMethod();
//        ReusableMethods.waitFor(3);
//        clientManagement.navigateToClientTabs();
//        us_013accountManagement.scrollDownToElement();
//        Thread.sleep(2000);
//        clientManagement.editButton.click();
//        ReusableMethods.waitFor(2);
//        String nameBeforedit=clientManagement.inputBoxFirstName.getAttribute("value");
//        System.out.println(nameBeforedit);
//         clientManagement.inputBoxFirstName.sendKeys("");
//        String nameAfteredit=clientManagement.inputBoxFirstName.getAttribute("value");
//        System.out.println(nameAfteredit);
//        ReusableMethods.waitFor(2);
//        String lastnameBeforedit=clientManagement.inputBoxFirstName.getAttribute("value");
//        clientManagement.inputBoxLastName.sendKeys("");
//        String lastnameAfteredit=clientManagement.inputBoxFirstName.getAttribute("value");
//        ReusableMethods.waitFor(2);
//        ReusableMethods.clickWithJS(clientManagement.saveButton);
//        Assert.assertTrue(nameBeforedit.equals(nameAfteredit));
//        Assert.assertTrue(lastnameBeforedit==lastnameAfteredit);
//
//    }
    @Test(priority = 4)
    public void cancelButtonTest() throws InterruptedException {
        //   Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        //   us_013accountManagement.loginByLinkedinMethod();
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement();
        Thread.sleep(2000);
        clientManagement.editButton.click();
        ReusableMethods.waitFor(3);
        clientManagement.inputValidValues("Azimi", "Gencaev", "45654654654", "Student");
        Assert.assertTrue(clientManagement.cancelButton());
    }
    @Test(priority = 6)
    public void presentingIssueAddnewProblemTest(){

    }




}
