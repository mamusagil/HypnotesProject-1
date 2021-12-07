package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US16_calendar_SettingPage {

    public US16_calendar_SettingPage() {
     PageFactory.initElements(Driver.getDriver(),this);}
    ////Login
    @FindBy(xpath = "//a[@href='/api/login']")
    public WebElement loginButtonMD;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBoxMD;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBoxMD;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton1MD;


}
