package com.hypnotes.tests;
import com.hypnotes.pages.US009_ClientManagementEdit;
import com.hypnotes.pages.US013_AccountManagement;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.geom.RectangularShape;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class US009_ClientManagementEditTest {

    US009_ClientManagementEdit clientManagement = new US009_ClientManagementEdit();
    US013_AccountManagement us_013accountManagement = new US013_AccountManagement();
    Random random = new Random();
     WebDriver driver;
     @BeforeMethod
             public void login(){
         Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_linkYB"));
         us_013accountManagement.loginMethod();
     }
    @AfterMethod
    public void logout(){ Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_linkYB"));
        us_013accountManagement.logoutMethod();
    }
        @Test(priority = 1)
    public void TestClientManagement() throws InterruptedException {
//         ReusableMethods.waitFor(3);
//       us_013accountManagement.viewButton.click();
//        ReusableMethods.clickWithJS(us_013accountManagement.agreementButton1);
//        us_013accountManagement.nextButton.click();
//        us_013accountManagement.scrollDownToElement("1500");
//        ReusableMethods.waitFor(4);
//       ReusableMethods.clickWithJS(us_013accountManagement.agreementButton2);
//        ReusableMethods.waitFor(3);
//        ReusableMethods.clickWithJS(us_013accountManagement.submitButton);
        clientManagement.navigateToClientTabs();
        us_013accountManagement.scrollDownToElement("1500");
        Thread.sleep(2000);
        clientManagement.editButton.click();
        ReusableMethods.waitFor(3);
        clientManagement.inputValidValues("Azimi", "Gencaev", "45654654654", "Student","hfdyy@gmail.com"," dyt street Uk","57666");
        ReusableMethods.waitFor(4);
        us_013accountManagement.scrollDownToElement("1500");
        ReusableMethods.clickWithJS(clientManagement.saveButton);
        Assert.assertEquals(clientManagement.messageUpdated.getText(), "Client Info has been successfully updated!✅");
        ReusableMethods.waitFor(3);
    }

//    @Test(priority = 2)
//    public void editName_SUrnamewithInValid_Credentials() throws InterruptedException {
//       // Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
//       // us_013accountManagement.loginByLinkedinMethod();
//         ReusableMethods.waitFor(3);
//        clientManagement.navigateToClientTabs();
//        us_013accountManagement.scrollDownToElement("1500");
//        Thread.sleep(2000);
//        clientManagement.editButton.click();
//        clientManagement.inputBoxFirstName.clear();
//        ReusableMethods.waitFor(2);
//        clientManagement.inputBoxFirstName.sendKeys("Tahsin67*-)6");
//        clientManagement.inputBoxFirstName.getAttribute("value");
//        clientManagement.inputBoxLastName.clear();
//        ReusableMethods.waitFor(2);
//        clientManagement.inputBoxLastName.sendKeys("Aga0*6*ü^4=)");
//        ReusableMethods.waitFor(3);
//        ReusableMethods.clickWithJS(clientManagement.saveButton);
//        clientManagement.inputBoxLastName.getAttribute("value");
//        Assert.assertEquals(clientManagement.inputBoxLastName.getAttribute("value"), "Aga");
//        Assert.assertEquals(clientManagement.inputBoxFirstName.getAttribute("value"), "Tahsin");
//    }
//
//    @Test(priority = 3)
//    public void editTelephone_withInValid_CredentialsTest() throws InterruptedException {
//        ReusableMethods.waitFor(2);
//        clientManagement.navigateToClientTabs();
//        us_013accountManagement.scrollDownToElement("1500");
//        Thread.sleep(2000);
//        clientManagement.editButton.click();
//        clientManagement.inputBoxPhoneNumber.clear();
//        clientManagement.inputBoxPhoneNumber.sendKeys("0Aga0*566*ü^4=)001");
//        ReusableMethods.waitFor(3);
//        ReusableMethods.clickWithJS(clientManagement.saveButton);
//        clientManagement.inputBoxPhoneNumber.getAttribute("value");
//        System.out.println(clientManagement.inputBoxPhoneNumber.getAttribute("value"));
//        Assert.assertEquals(clientManagement.inputBoxPhoneNumber.getAttribute("value"), "005664001");
//    }
////    @Test(priority = 4)
//  //  public void WithEmptyFields_beEmptyTest() throws InterruptedException {
////         Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
////         us_013accountManagement.loginByLinkedinMethod();
////        ReusableMethods.waitFor(3);
////        clientManagement.navigateToClientTabs();
////        us_013accountManagement.scrollDownToElement();
////        Thread.sleep(2000);
////        clientManagement.editButton.click();
////        ReusableMethods.waitFor(2);
////        String nameBeforedit=clientManagement.inputBoxFirstName.getAttribute("value");
////        System.out.println(nameBeforedit);
////         clientManagement.inputBoxFirstName.sendKeys("");
////        String nameAfteredit=clientManagement.inputBoxFirstName.getAttribute("value");
////        System.out.println(nameAfteredit);
////        ReusableMethods.waitFor(2);
////        String lastnameBeforedit=clientManagement.inputBoxFirstName.getAttribute("value");
////        clientManagement.inputBoxLastName.sendKeys("");
////        String lastnameAfteredit=clientManagement.inputBoxFirstName.getAttribute("value");
////        ReusableMethods.waitFor(2);
////        ReusableMethods.clickWithJS(clientManagement.saveButton);
////        Assert.assertTrue(nameBeforedit.equals(nameAfteredit));
////        Assert.assertTrue(lastnameBeforedit==lastnameAfteredit);
////
////    }
//    @Test(priority = 4)
//    public void cancelButtonTest() throws InterruptedException {
//        //   Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
//        //   us_013accountManagement.loginByLinkedinMethod();
//        clientManagement.navigateToClientTabs();
//        us_013accountManagement.scrollDownToElement("1500");
//        Thread.sleep(2000);
//        clientManagement.editButton.click();
//        ReusableMethods.waitFor(3);
//        clientManagement.inputValidValues("Azimi", "Gencaev", "45654654654", "Student");
//        Assert.assertTrue(clientManagement.cancelButton());
//
    @Test(priority = 2)
    public void presentingIssue_Attachments_Test() {
        clientManagement.navigateToPresentingIssues();
        ReusableMethods.waitFor(2);
        us_013accountManagement.scrollDownToElement("1500");
        int number = random.nextInt(100);
        String issue = "newissue" + number;
        clientManagement.title.sendKeys(issue);
        String issueName = clientManagement.title.getAttribute("value");
        ReusableMethods.waitFor(2);
        us_013accountManagement.scrollDownToElement("1500");
        clientManagement.addButton.click();
        WebElement newIssue = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'" + issueName + "')]"));
        System.out.println(newIssue);
        ReusableMethods.waitFor(3);
        newIssue.click();
        us_013accountManagement.scrollDownToElement("1800");
        ReusableMethods.waitFor(4);
        clientManagement.attachmentsButton.click();
        String projectPath = System.getProperty("user.dir");
        String filePath1 = "src/test/resources/2014gr0506e.pdf";
        String fullPath1 = projectPath + "/" + filePath1;
        String filePath2 = "src/test/resources/Todd-Haynes-2017.jpeg";
        String fullPath2 = projectPath + "/" + filePath2;
        clientManagement.browsefile.sendKeys(fullPath1 + "\n " + fullPath2);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(clientManagement.imageAddedmessage.getText(), "2 images added.");
        ReusableMethods.waitFor(8);
        clientManagement.deleteIssue.click();
        ReusableMethods.waitFor(3);
        clientManagement.no.click();
       int numberofissuesBeforedelete=clientManagement.issueArray.size();
        System.out.println(numberofissuesBeforedelete);
        clientManagement.deleteIssue.click();
       ReusableMethods.waitFor(3);
        clientManagement.yes.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();
       int numberofissuesAfterdelete=clientManagement.issueArray.size();
        System.out.println(numberofissuesAfterdelete);
        Assert.assertFalse(numberofissuesAfterdelete==numberofissuesBeforedelete,"Issue not deleted");

    }

    @Test(priority = 3)
    public void presentingIssue_Attachments_Extract_File_intoText_SentToClient_Test() {
        clientManagement.navigateToPresentingIssues();
        ReusableMethods.waitFor(2);
        us_013accountManagement.scrollDownToElement("1500");
        int number = random.nextInt(100);
        String issue = "newissue" + number;
        clientManagement.title.sendKeys(issue);
        String issueName = clientManagement.title.getAttribute("value");
        ReusableMethods.waitFor(2);
        us_013accountManagement.scrollDownToElement("1500");
        clientManagement.addButton.click();
        WebElement newIssue = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'" + issueName + "')]"));
        System.out.println(newIssue);
        ReusableMethods.waitFor(5);
        newIssue.click();
        us_013accountManagement.scrollDownToElement("1800");
        ReusableMethods.waitFor(4);
        clientManagement.attachmentsButton.click();
        String projectPath = System.getProperty("user.dir");
        String filePath1 = "src/test/resources/2014gr0506e.pdf";
        String fullPath1 = projectPath + "/" + filePath1;
        String filePath2 = "src/test/resources/Todd-Haynes-2017.jpeg";
        String fullPath2 = projectPath + "/" + filePath2;
        clientManagement.browsefile.sendKeys(fullPath1 + "\n " + fullPath2);
        clientManagement.addedImageFile.click();
        us_013accountManagement.scrollDownToElement("400");
        ReusableMethods.waitFor(3);
        clientManagement.extractTextButton.click();
        ReusableMethods.waitFor(10);
        ReusableMethods.clickWithJS(clientManagement.copyButton);
        Assert.assertEquals(clientManagement.textCopiedToClipBoard.getText(), "Text copied to your clipboard!");
        ReusableMethods.waitFor(10);
       us_013accountManagement.scrollDownToElement("400");
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(clientManagement.sendToClient);
        Assert.assertEquals(clientManagement.SentToClientMessage.getText(),"Sent to Client");

     }

    @Test(priority = 4)
    public void presentingIssue_Attachments_Delete_File_Test() {
        clientManagement.navigateToPresentingIssues();
        ReusableMethods.waitFor(2);
        clientManagement.newissue.click();
        us_013accountManagement.scrollDownToElement("1800");
        ReusableMethods.waitFor(4);
        clientManagement.attachmentsButton.click();
        String projectPath = System.getProperty("user.dir");
        String filePath1 = "src/test/resources/2014gr0506e.pdf";
        String fullPath1 = projectPath + "/" + filePath1;
        clientManagement.browsefile.sendKeys(fullPath1);
        clientManagement.addedImageFile.click();
        us_013accountManagement.scrollDownToElement("400");
        ReusableMethods.waitFor(3);
        int beforeDelete = clientManagement.numberoffilesCreated.size();
        System.out.println(clientManagement.numberoffilesCreated.size());
        clientManagement.extractDeleteButton.click();
        ReusableMethods.waitFor(2);
        clientManagement.deleteExtractedMessageYes.click();
        Driver.getDriver().navigate().refresh();
        int afterDelete = clientManagement.numberoffilesCreated.size();
        System.out.println(clientManagement.numberoffilesCreated.size());
        Assert.assertFalse(beforeDelete == afterDelete, "file is not deleted");
    }

    @Test(priority = 5)
    public void presentingIssue_Record_Test() throws AWTException {
        clientManagement.navigateToPresentingIssues();
        ReusableMethods.waitFor(2);
        clientManagement.newissue.click();
        us_013accountManagement.scrollDownToElement("1700");
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(clientManagement.recordButton);
        ReusableMethods.waitFor(10);
        ReusableMethods.clickWithJS(clientManagement.recordButton);
      //  JavascriptExecutor jse = (JavascriptExecutor)driver;
     //   jse.executeScript("document.querySelector('#audioElement').play();");
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(clientManagement.voiceExtractText);
        ReusableMethods.waitFor(4);
        clientManagement.copyButtonVoice.click();
        Assert.assertEquals(clientManagement.textCopiedToClipBoard.getText(),"Text copied to your clipboard!");
        ReusableMethods.waitFor(2);
        int beforeDelete = clientManagement.numberofVoicefilesCreated.size();
        System.out.println(clientManagement.numberofVoicefilesCreated.size());
        clientManagement.voiceDeleteButton.click();
        clientManagement.deleteExtractedMessageYes.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();
        int afterDelete = clientManagement.numberofVoicefilesCreated.size();
        System.out.println(clientManagement.numberofVoicefilesCreated.size());
        Assert.assertFalse(beforeDelete == afterDelete, "file is not deleted");

//        ReusableMethods.clickWithJS(clientManagement.recordButton);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.clickWithJS(clientManagement.recordButton);
//        ReusableMethods.waitFor(5);
//        ReusableMethods.clickWithJS(clientManagement.recordButton);
//        ReusableMethods.waitFor(5);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("clientManagement.audioFile.play();");
//        ReusableMethods.waitFor(3);

//        Robot robot = new Robot();
//        robot.mouseMove(630, 420); // move mouse point to specific location
//        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click


    }
}
