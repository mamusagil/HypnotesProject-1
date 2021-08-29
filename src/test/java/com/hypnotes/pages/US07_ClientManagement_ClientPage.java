package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US07_ClientManagement_ClientPage {

    public US07_ClientManagement_ClientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Second Project
    @FindBy(xpath = "//a[@href='/dashboard/documents']")
    public WebElement documentButton;

    @FindBy(xpath = "//span[contains(text(),'Add Document')]")
    public WebElement addDocument;
    ////////////////////////////////////

    @FindBy( xpath = "//a[@href='/api/login']")
    public WebElement loginButton;
//    By loginButton = By.xpath("//a[@href='/api/login']");

    @FindBy(xpath = "//span[@class='ant-menu-title-content']//a[@href='/dashboard/add-client']")
    public WebElement addClientButton;

    @FindBy( xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy( xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy( xpath = "//input[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='postal']")
    public WebElement zipCode;

   // @FindBy( xpath = "//button[contains(@class,'genric-btn info-border circle')]")
   @FindBy( xpath = "//button[contains(text(),'Add')]")
    public WebElement addButton;

    // After adding one client, to add another one
    @FindBy(xpath = "//a[@href= '/dashboard/add-client']")
    public WebElement addClientButton2;


    @FindBy(xpath = "//a[@href= '/dashboard']")
    public WebElement clients;

    @FindBy(xpath = "//span[@class = 'ant-comment-content-author-name']")
    public List<WebElement> getClientNames;

    // noClientsSavedTest

    @FindBy(xpath = "//div[@class='ant-result-title']")
    public WebElement noClientsSaved;

    //searchByName
    @FindBy(xpath = "//input[@class='ant-input ant-input-lg']")
    public WebElement searchByName;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button']")
    public WebElement getSearchByNameButton;

    @FindBy(xpath = "//h5[@class='ant-typography']")
    public WebElement afterSearchSavedClient;

    //AC-04 Listed clients will be clickable to navigate client details page

    @FindBy(xpath = "//span[@class='ant-comment-content-author-name']")
    public List<WebElement> isClientClickable;

    @FindBy(xpath = "//div[@class='left-action-button']//span//a")
    public WebElement viewDetails;


    @FindBy(xpath = "//button[@id='editBtn']")
    public WebElement editButton;

    //AC-05 user can delete client by clicking Delete button but should see confirmation of deletion popup
    @FindBy(xpath = "//span[@class='anticon anticon-delete']")
    public List<WebElement> deleteButtons;

    @FindBy(xpath = "//div[contains(text(),'Are you sure to delete this client?')]")
    public WebElement deleteConfirmation;

    //AC-06 when user confirm deletion of client will see message "Client deleted."

    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    public WebElement yesButton;















}


