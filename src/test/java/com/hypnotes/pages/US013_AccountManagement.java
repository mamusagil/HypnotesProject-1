package com.hypnotes.pages;

import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US013_AccountManagement {

    public US013_AccountManagement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Verification')]")
    public WebElement verificationBtn;
    @FindBy(xpath = "//*[@name='phone']")
    public WebElement phoneInputBox;
    @FindBy(xpath = "//*[contains(text(),'Send veficiation SMS')]")
    public WebElement sendVerificationButton;
    @FindBy(xpath = "//*[contains(text(),'Verification SMS sent!')]")
    public WebElement verificationSMSsent;
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMessage;
    @FindBy(xpath = "//*[contains(text(),'Given time exceed for verification. Please try again...')]")
    public WebElement timefinishedMessage;
    @FindBy(xpath = "//*[@class='text-center']")
    public WebElement message;
    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    public WebElement cancelBtn;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement confirmBtn;
    @FindBy(xpath = "//*[@id='securityCode-input']")
    public WebElement securityCodeInput;
    @FindBy(xpath = "//*[contains(text(),' seconds remaining..')]")
    public WebElement secondsText;
    @FindBy(xpath = "//*[contains(text(),'Please Enter Your Security Code and Confirm in 120 seconds...')]")
    public WebElement pleaseEnterSecCode;
    @FindBy(xpath = "//a[@href='/api/login']")
    public WebElement Login;
    @FindBy(css = ".btn.btn-outline-primary")
    public WebElement signUp;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;
    @FindBy(css = ".genric-btn.success.circle.arrow.mt-20.mb-20")
    public WebElement loginButton;
    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    public WebElement logout;
    @FindBy(xpath = "//*[@class='ant-btn ant-btn-background-ghost'][1]']")
    public WebElement clientsBtn;
    @FindBy(xpath = "//a[contains(text(),'Add Client')]")
    public WebElement addClient;
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    public WebElement settings;
    @FindBy(xpath = "//span[contains(text(),'Calendar')]")
    public WebElement calendar;
    @FindBy(xpath = "//li/a[contains(text(),'Settings')]")
    public WebElement settingsCalendar;
    @FindBy(xpath = "//li/a[contains(text(),'Meetings')]")
    public WebElement meetings;
    @FindBy(xpath = "//a[@href='/api/public/connect/google']")
    public WebElement googleButton;
    @FindBy(xpath = "//a[@href='/api/public/connect/linkedin']")
    public WebElement linkedinButton;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailybalkas;
    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
    public WebElement nextButton1;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordybalkas;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement nextButton2;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement linkEdinusername;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement linkEdinpassword;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement linkEdinSignInButton;
    @FindBy(xpath = "//span[contains(text(),'View')]")
    public WebElement viewButton;
    @FindBy(xpath= "//input[@name='doc1']")
    public WebElement agreementButton1;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement nextButton;
    @FindBy(xpath= "//input[@name='doc2']")
    public WebElement agreementButton2;
    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    public WebElement submitButton;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    public WebElement closeButton;

    public void loginMethod() {
        ReusableMethods.waitForClickablility(Login, 10);
        ReusableMethods.clickWithJS(Login);
        ReusableMethods.waitForVisibility(inputEmail, 4);
        ReusableMethods.waitForVisibility(inputPassword, 4);
        inputEmail.clear();
        inputPassword.clear();
        String username = ConfigurationReader.getProperty("ybalkas-email");
        String password = ConfigurationReader.getProperty("ybalkas-password");
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        ReusableMethods.waitForClickablility(loginButton, 5);
        loginButton.click();
    }

    public void logoutMethod() {
        logout.click();
    }

    public void loginByLinkedinMethod() {
        ReusableMethods.waitForClickablility(Login, 10);
        ReusableMethods.clickWithJS(Login);
        ReusableMethods.waitForClickablility(linkedinButton, 10);
        ReusableMethods.clickWithJS(linkedinButton);
        ReusableMethods.waitForVisibility(linkEdinusername, 4);
        linkEdinusername.sendKeys("ybalkas@gmail.com");
        linkEdinpassword.sendKeys("mehtap1976MEHTAP");
        linkEdinSignInButton.click();

    }
    public void loginByGoogleMethod() {
        ReusableMethods.waitForClickablility(Login, 10);
        ReusableMethods.clickWithJS(Login);
        ReusableMethods.waitForClickablility(googleButton, 10);
        ReusableMethods.clickWithJS(googleButton);
        ReusableMethods.waitForVisibility(emailybalkas, 4);
        emailybalkas.sendKeys("ybalkas@gmail.com");
        ReusableMethods.waitForVisibility(nextButton1, 4);
        nextButton1.click();
        ReusableMethods.waitForVisibility(passwordybalkas,4);
        passwordybalkas.sendKeys("mehtap1976MEHTAP");
        nextButton2.click();
    }
    public  void scrollDownToElement(String value) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,"+value+")");
    }
    public  void scrollUpToElement() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-1500)");
    }
}
   // This Method Navigates to Settings Menu

   //driver.switchTo().alert().getText();


