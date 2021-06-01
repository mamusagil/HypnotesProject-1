package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US09_ClientManagementPage {

    public US09_ClientManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@href='/api/login'])[1]")
    public WebElement login;

    @FindBy(xpath ="//*[@name='email']" )
    public WebElement username;

    @FindBy(xpath ="//*[@name='password']" )
    public WebElement password;

    @FindBy(xpath ="(//*[contains(text(),'Login')])[2]" )
    public WebElement loginButton;


}
