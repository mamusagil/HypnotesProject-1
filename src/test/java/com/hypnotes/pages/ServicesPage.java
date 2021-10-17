package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ServicesPage {
    public ServicesPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(xpath = "//a[@href='/dashboard/services']")
    public WebElement servicesButton;

    @FindBy(xpath ="//div[@id='rc-tabs-0-tab-1']" )
    public WebElement categoryButton;

    @FindBy(xpath ="//div[@id='rc-tabs-0-tab-2']" )
    public WebElement packagesButton;

    @FindBy(xpath = "//span[text()='Add New Category']")
    public WebElement addNewCategory;

    @FindBy(xpath = "//span[text()='Add New Package']")
    public WebElement addNewPackage;

    @FindBy(xpath = "(//input[@class='ant-input'])[1]")
    public WebElement inputName;

    @FindBy(xpath = "(//input[@class='ant-input'])[2]")
    public WebElement inputPackageName;

    @FindBy(xpath = "(//input[@id='price'])[1]")
    public WebElement inputPrice;

    @FindBy(xpath = "(//input[@id='price'])[2]")
    public WebElement inputPackagePrice;

    @FindBy(xpath = "(//input[@id='duration'])[1]")
    public WebElement inputDuration;

    @FindBy(xpath = "(//input[@id='duration'])[2]")
    public WebElement inputPackageDuration;


    @FindBy(id = "blockBefore")
    public WebElement blockBefore;

    @FindBy(id = "blockAfter")
    public WebElement blockAfter;

    @FindBy(id = "paymentRequired")
    public WebElement paymentRequired;

    @FindBy(id = "totalSessions")
    public WebElement totalSessions;

    @FindBy(id = "sessionInterval")
    public WebElement sessionInterval;

    //@FindBy(id = "description")
    @FindBy(xpath = "(//textarea[@id='description'])[1]")
    public WebElement description;

    @FindBy(xpath = "(//textarea[@id='description'])[2]")
    public WebElement descriptionPackage;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement savePackageButton;

    @FindBy(xpath = "//div[@class ='ant-card-meta-title']")
    public WebElement categoryList;

    @FindBy(xpath= "//div[@class='ant-card-meta-title']")
    public List<WebElement> getCategoryItems;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[1]")
    public List<WebElement> getDuration;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[2]")
    public List<WebElement> getPrice;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[3]")
    public List<WebElement> getSessions;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[4]")
    public List<WebElement> getInterval;

    @FindBy(xpath = "//span[@class='anticon anticon-edit']")
    public List<WebElement> editButton;

    @FindBy(xpath = "//span[@class='anticon anticon-delete']")
    public List<WebElement> deleteButton;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
    public WebElement okButton;

    @FindBy(xpath = "//div[contains(text(), 'Create a new package')]")
    public WebElement createPackageTitle;

    @FindBy(xpath = "(//button[@class='ant-switch'])[1]")
    public WebElement blockExtraTime;



}
