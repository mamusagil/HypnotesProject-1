package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;

import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class US009_ClientManagementEdit {
    public US009_ClientManagementEdit(){ PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(xpath = "//*[.='Contact us']")
    public List<WebElement> inputBox=new ArrayList<>();
    @FindBy(xpath="//a[contains(text(),'Clients')]")
    public WebElement clientsButton;
    @FindBy(xpath="(//*[contains(text(),'View Detail')])[1]")
    public WebElement viewDetail;
    @FindBy(xpath="//button[contains(text(),'Edit')]")
    public WebElement editButton;
    @FindBy(xpath="//input[@class='form-control infoInput']")
    public List<WebElement> inputBoxes=new ArrayList<>();
    @FindBy(xpath="//label[contains(text(),'First Name')]/../descendant::input")
    public WebElement inputBoxFirstName;
    @FindBy(xpath="//label[contains(text(),'Last Name')]/../descendant::input")
    public WebElement inputBoxLastName;
    @FindBy(xpath="//label[contains(text(),'Phone Number')]/../descendant::input")
    public WebElement inputBoxPhoneNumber;
    @FindBy(xpath="//label[contains(text(),'Occupation')]/../descendant::input")
    public WebElement inputBoxOccupation;
    @FindBy(xpath="//*[contains(text(),'Save')]")
    public WebElement saveButton;
    @FindBy(xpath="//*[contains(text(),'Cancel')]")
    public WebElement cancelButton;
    @FindBy(xpath="//*[@id='inputGroupFile01']")
    public WebElement browseFile;
    @FindBy(xpath="//*[contains(text(),'Client Info')]")
    public WebElement clientInfo;
    @FindBy(xpath="//*[contains(text(),'Presenting Issue')]")
    public WebElement presentingIssue;
    @FindBy(xpath="//*[contains(text(),'Sessions')]")
    public WebElement sessions;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement messageUpdated;
    @FindBy (xpath="//a[@class='genric-btn primary circle arrow']")
    public WebElement addNewProblem;
    @FindBy (xpath="//input[@id='title']")
    public WebElement title;
    @FindBy(xpath="//button[contains(text(),'Add')]")
    public WebElement addButton;
    @FindBy(xpath="//span[contains(text(),'Delete Issue')]")
    public WebElement deleteIssue;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement problemAdded;
    @FindBy (xpath="//div[@class='ant-popover-message-title']")
    public WebElement popupDeleteCOnfirm;
    @FindBy (xpath="//span[contains(text(),'Yes')]")
    public WebElement yes;
    @FindBy (xpath="//span[contains(text(),'No')]")
    public WebElement no;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement issueAddedMessage;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement issuedeletedMessage;
    @FindBy(xpath = "//div[@class='col-12']/a")
    public List<WebElement> issueArray=new ArrayList<>();
    @FindBy (css=".fas.fa-plus-circle")
    public WebElement attachmentsButton;
    @FindBy (xpath="//div[@class='col-6 col-sm-4 col-md-3 col-lg-2 mb-2 text-center align-items-center cursor-pointer record-btn']")
    public WebElement recordVoiceButton;
    @FindBy (css="input[id^='addImageModalInput']")
    public WebElement browsefile;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement imageAddedmessage;
    @FindBy (xpath="//div[contains(@id,'image')][2]")
    public WebElement addedImageFile;
    @FindBy (css="button[id^='imageModalExtract']")
    public WebElement extractTextButton;
    @FindBy (css="button[id^='imageModalDelete']")
    public WebElement extractDeleteButton;
    @FindBy (xpath="//button[contains(text(),'Copy')]")
    public WebElement copyButton;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement textCopiedToClipBoard;
    @FindBy (xpath="//button/span[contains(text(),'Yes')]")
    public WebElement deleteExtractedMessageYes;
    @FindBy(css = ".col-12.row.m-0.py-3>div")
    public List<WebElement> numberoffilesCreated=new ArrayList<>();
    @FindBy (css = ".record-status")
    public WebElement recordButton;
    @FindBy (xpath="//a[contains(text(),'newissue')]")
    public WebElement newissue3;
    @FindBy (css = ".fas.fa-file-audio.note-add-image-btn")
    public WebElement audioFile;
    @FindBy (css = "[id='voiceModalExtractTextButton']")
    public WebElement voiceExtractText;
    @FindBy (css = "[id='voiceModalDeleteButton']")
    public WebElement voiceDeleteButton;
    @FindBy (xpath = "(//button[contains(text(),'Copy')])[2]")
    public WebElement copyButtonVoice;
    @FindBy(css = ".fas.fa-file-audio.note-add-image-btn")
    public List<WebElement> numberofVoicefilesCreated=new ArrayList<>();
    @FindBy (css = "[id='voiceModalAudio']")
    public WebElement audioelement;
    @FindBy (xpath = "//span[contains(text(),'Delete Issue')]")
    public WebElement deleteissue;
    @FindBy (xpath = "//div[@class='col-12']/a")
    public List<WebElement> numberofissuesCreated=new ArrayList<>();
    @FindBy (xpath = "//input[@id='postal']")
    public WebElement zipCode;
    @FindBy (xpath = "(//button[contains(text(),'Send to client')])[1]")
    public WebElement sendToClient;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement SentToClientMessage;


    US013_AccountManagement us013_accountManagement= new US013_AccountManagement();




   public void navigateToClientTabs() throws InterruptedException {
       ReusableMethods.waitForClickablility(clientsButton,3);
      ReusableMethods.clickWithJS(clientsButton);
       ReusableMethods.waitForClickablility(viewDetail,3);
       ReusableMethods.clickWithJS(viewDetail);
       ReusableMethods.waitForClickablility(clientInfo,3);
       ReusableMethods.clickWithJS(clientInfo);

   }
    public void inputValidValues(String name, String surname ,String telephone,String Occupation,String email,String address ,String zipCode )  {
        inputBoxes.get(0).clear();
        inputBoxes.get(0).sendKeys(name);
        inputBoxes.get(1).clear();
        inputBoxes.get(1).sendKeys(surname);
        inputBoxes.get(2).clear();
        inputBoxes.get(2).sendKeys(telephone);
        inputBoxes.get(3).clear();
        inputBoxes.get(3).sendKeys(Occupation);
        inputBoxes.get(4).clear();
        inputBoxes.get(4).sendKeys(email);
        inputBoxes.get(5).clear();
        inputBoxes.get(5).sendKeys(address);
        inputBoxes.get(6).clear();
        inputBoxes.get(6).sendKeys(zipCode);
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Todd-Haynes-2017.jpeg";
        String fullPath = projectPath+"/"+filePath;
        browseFile.sendKeys(fullPath);

    }
    public void invalidValues(String name, String surname ,String telephone,String Occupation)  {
        inputBoxes.get(0).clear();
        inputBoxes.get(0).sendKeys(name);
        inputBoxes.get(1).clear();
        inputBoxes.get(1).sendKeys(surname);
        inputBoxes.get(2).clear();
        inputBoxes.get(2).sendKeys(telephone);
        inputBoxes.get(3).clear();
        inputBoxes.get(3).sendKeys(Occupation);
        ReusableMethods.waitFor(3);
        saveButton.click();
    }
    public Boolean cancelButton()  {
       List<String> listBeforeCancel= new ArrayList<>();
        listBeforeCancel.add(inputBoxes.get(0).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(1).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(2).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(3).getAttribute("value"));
        System.out.println("listBeforeCancel = " + listBeforeCancel);
        ReusableMethods.clickWithJS(cancelButton);
        List<String> listafterCancel= new ArrayList<>();
        listafterCancel.add(inputBoxes.get(0).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(1).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(2).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(3).getAttribute("value"));
        System.out.println("afterBeforeCancel = " + listafterCancel);

        return listBeforeCancel.equals(listafterCancel);

    }
    public void navigateToPresentingIssues()  {
        ReusableMethods.waitForClickablility(clientsButton, 3);
        ReusableMethods.clickWithJS(clientsButton);
        us013_accountManagement.scrollDownToElement("1800");
        ReusableMethods.waitForClickablility(viewDetail, 3);
        ReusableMethods.clickWithJS(viewDetail);
        ReusableMethods.waitForClickablility(presentingIssue, 3);
        ReusableMethods.clickWithJS(presentingIssue);
        ReusableMethods.waitForClickablility(addNewProblem ,3);
        ReusableMethods.clickWithJS(addNewProblem);
    }
}
