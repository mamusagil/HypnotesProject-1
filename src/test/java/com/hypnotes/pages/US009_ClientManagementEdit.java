package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;

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
    @FindBy(xpath="//*[contains(text(),'View Detail')]")
    public WebElement viewDetail;
    @FindBy(xpath="//button[contains(text(),'Edit')]")
    public WebElement editButton;
    @FindBy(xpath="//input[@class='form-control infoInput']")
    public List<WebElement> inputBoxes=new ArrayList<>();
    @FindBy(xpath="//*[contains(text(),'Save')]")
    public WebElement saveButton;
    @FindBy(xpath="//*[contains(text(),'Save')]")
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

   public void navigateToClientTabs() throws InterruptedException {
     clientsButton.click();
     Thread.sleep(2000);
     viewDetail.click();
     clientInfo.click();
   }
    public void inputValidValues(String name, String surname ,String telephone,String Occupation)  {
        inputBoxes.get(0).clear();
        inputBoxes.get(0).sendKeys(name);
        inputBoxes.get(1).clear();
        inputBoxes.get(1).sendKeys(surname);
        inputBoxes.get(2).clear();
        inputBoxes.get(2).sendKeys(telephone);
        inputBoxes.get(3).clear();
        inputBoxes.get(3).sendKeys(Occupation);
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/pasaport.jpg";
        String fullPath = projectPath+"/"+filePath;
        browseFile.sendKeys(fullPath);
        saveButton.click();
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
        saveButton.click();
    }
    public Boolean cancelButton()  {
       List<String> listBeforeCancel= new ArrayList<>();
        listBeforeCancel.add(inputBoxes.get(0).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(1).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(2).getAttribute("value"));
        listBeforeCancel.add(inputBoxes.get(3).getAttribute("value"));
        System.out.println("listBeforeCancel = " + listBeforeCancel);
        cancelButton.click();
        List<String> listafterCancel= new ArrayList<>();
        listafterCancel.add(inputBoxes.get(0).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(1).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(2).getAttribute("value"));
        listafterCancel.add(inputBoxes.get(3).getAttribute("value"));
        System.out.println("afterBeforeCancel = " + listafterCancel);

        return listBeforeCancel.equals(listafterCancel);

    }
}
