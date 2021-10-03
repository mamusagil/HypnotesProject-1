package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US077_Services {
    public US077_Services(){
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

    @FindBy(className = "ant-btn ant-btn-primary")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class ='ant-card-meta-title']")
    public WebElement categoryList;




}
