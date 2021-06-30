package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US00_DenemePage {
   public US00_DenemePage(){
    PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy( xpath = "//a[@href='/api/login']")
    public WebElement loginButton;

    @FindBy( xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy( xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy( xpath = "//button[@type='submit']")
    public WebElement loginButton1;


    @FindBy( xpath = " //h3[contains(text(),'Search Clients')]")
    public WebElement afterLogin;

 @FindBy( xpath = " //a[contains(text(),'Wrong')]")
 public WebElement wrongCreText;


 @FindBy( xpath = "//a[@href='/api/logout']")
 public WebElement logoutButton;



 @FindBy( xpath = "//a[@href='/dashboard/add-client']")
 public WebElement addClientButton;


 //id="first_name"
 @FindBy(id="first_name")
 public WebElement firstNameBox;




 @FindBy(id="last_name")
 public WebElement lastNameBox;

 @FindBy(id="phone")
 public WebElement phoneNumberBox;

 @FindBy(id="occupation")
 public WebElement occupationBox;


 @FindBy(xpath="//button[@type='submit']")
 public WebElement addButton;


}
