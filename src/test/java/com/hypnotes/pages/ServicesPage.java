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

    @FindBy(className = "ant-tabs-tab-btn")
    public WebElement categoryButton;

    @FindBy(xpath = "//span[text()='Add New Category']")
    public WebElement addNewCategory;

    @FindBy(id = "title")
    public WebElement categoryName;

    @FindBy(id = "price")
    public WebElement priceInput;

    @FindBy(id = "duration")
    public WebElement duration;

    @FindBy(id = "blockBefore")
    public WebElement blockBefore;

    @FindBy(id = "blockAfter")
    public WebElement blockAfter;

    @FindBy(id = "paymentRequired")
    public WebElement paymentRequired;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class ='ant-card-meta-title']")
    public WebElement categoryList;

    @FindBy(xpath= "//div[@class='ant-card-meta-title']")
    public List<WebElement> getCategoryItems;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[1]")
    public List<WebElement> getDuration;

    @FindBy(xpath= "//div[@class='ant-card-meta-description']/p[2]")
    public List<WebElement> getPrice;

    @FindBy(xpath = "//span[@class='anticon anticon-edit']")
    public List<WebElement> editButton;

    @FindBy(xpath = "//span[@class='anticon anticon-delete']")
    public List<WebElement> deleteButton;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
    public WebElement okButton;








}
