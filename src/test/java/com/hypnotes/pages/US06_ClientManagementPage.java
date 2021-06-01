package com.hypnotes.pages;


import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US06_ClientManagementPage {
    public US06_ClientManagementPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy( xpath = "//h3[text()='Search Clients']")
    public WebElement searchClientsText;

    @FindBy( tagName = "h5")
    public WebElement allNames;

    @FindBy( xpath = "//input[@placeholder='Search Client by Name']")
    public WebElement  searchBox;

    @FindBy( xpath = "//span[text()='Search']")
    public WebElement searchButton;

    @FindBy( xpath = "//span[text()='Occupation']")
    public WebElement occupation;

    @FindBy( xpath = "//span[text()='Phone']")
    public WebElement phone;

    @FindBy( xpath = "//span[text()='Email']")
    public WebElement email;

    @FindBy( className = "ant-descriptions-item-content")
    public WebElement inputInfo;

    @FindBy( linkText = "View Detail")
    public WebElement viewDetails;

    @FindBy( xpath = "//span[text()='Delete']")
    public WebElement deleteButton;



















}
