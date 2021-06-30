package com.hypnotes.pages;

import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US013_AccountManagement  {

    public US013_AccountManagement(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath="//*[contains(text(),'Verification')]")
    public  WebElement verificationBtn;
    @FindBy(xpath="//*[@name='phone']")
  public  WebElement phoneInputBox;
   @FindBy(xpath ="//*[contains(text(),'Send veficiation SMS')]" )
  public    WebElement sendVerificationButton;
   @FindBy (xpath="//*[contains(text(),'Verification SMS sent!')]")
   public WebElement verificationSMSsent;
    @FindBy (xpath="//div[@class='toast-message']")
    public WebElement toastMessage;
    @FindBy(xpath ="//*[@class='text-center']")
  public WebElement message;
   @FindBy(xpath="//*[contains(text(),'Cancel')]")
   public     WebElement cancelBtn;
   @FindBy(xpath = "//*[contains(text(),'Confirm')]")
  public WebElement confirmBtn;
   @FindBy(xpath = "//*[@id='securityCode-input']")
   public  WebElement securityCodeInput;
   @FindBy(xpath = "//*[contains(text(),' seconds remaining..')]")
   public    WebElement secondsText;
    @FindBy(xpath = "//*[contains(text(),'Please Enter Your Security Code and Confirm in 120 seconds...')]")
    public    WebElement pleaseEnterSecCode;
    @FindBy(xpath="//a[@href='/api/login']")
    public WebElement Login;
    @FindBy(css=".btn.btn-outline-primary")
    public WebElement signUp;
    @FindBy(xpath="//input[@name='email']")
    public  WebElement inputEmail;
    @FindBy(xpath="//input[@name='password']")
    public WebElement inputPassword;
    @FindBy(css=".genric-btn.success.circle.arrow.mt-20.mb-20")
    public WebElement loginButton;
    @FindBy(xpath="//*[contains(text(),'Logout')]")
    public WebElement logout;
    @FindBy(xpath = "//*[@class='ant-btn ant-btn-background-ghost'][1]']")
    public WebElement  clientsBtn;
    @FindBy(xpath="//a[contains(text(),'Add Client')]")
    public WebElement addClient;
    @FindBy(xpath="//a[contains(text(),'Settings')]")
    public WebElement settings;
    @FindBy(xpath="//span[contains(text(),'Calendar')]")
    public WebElement calendar;
    @FindBy(xpath="//li/a[contains(text(),'Settings')]")
    public WebElement settingsCalendar;
    @FindBy(xpath="//li/a[contains(text(),'Meetings')]")
    public WebElement meetings;
    public void loginMethod()  {
        ReusableMethods.waitForClickablility(Login,10);
        ReusableMethods.clickWithJS(Login);
        ReusableMethods.waitForVisibility(inputEmail,4);
        ReusableMethods.waitForVisibility(inputPassword,4);
        inputEmail.clear();
        inputPassword.clear();
        String username = ConfigurationReader.getProperty("ybalkas-email");
        String password = ConfigurationReader.getProperty("ybalkas-password");
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        ReusableMethods.waitForClickablility(loginButton,5);
        loginButton.click();
    }
    public  void logoutMethod(){
        logout.click();
    }
    }

   // This Method Navigates to Settings Menu

   //driver.switchTo().alert().getText();


