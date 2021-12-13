package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US00_SmokeTestPage {
 public US00_SmokeTestPage() {
  PageFactory.initElements(Driver.getDriver(), this);
 }

 ////Login
 @FindBy(xpath = "//a[@href='/api/login']")
 public WebElement loginButton;
 @FindBy(xpath = "//input[@name='email']")
 public WebElement emailBox;
 @FindBy(xpath = "//input[@name='password']")
 public WebElement passwordBox;
 @FindBy(xpath = "//button[@type='submit']")
 public WebElement loginButton1;

 ////////
 @FindBy(xpath = " //h3[contains(text(),'Search Clients')]")
 public WebElement afterLogin;
 @FindBy(xpath = " //a[contains(text(),'Wrong')]")
 public WebElement wrongCreText;
 @FindBy(xpath = "//a[@href='/api/logout']")
 public WebElement logoutButton;

 //Add/Delete New Client
 @FindBy(xpath = "//a[@href='/dashboard/add-client']")
 public WebElement addClientButton;
 @FindBy(id = "first_name")
 public WebElement firstNameBox;
 @FindBy(id = "last_name")
 public WebElement lastNameBox;
 @FindBy(id = "phone")
 public WebElement phoneNumberBox;
 @FindBy(id = "occupation")
 public WebElement occupationBox;
 @FindBy(xpath = "//button[@type='submit']")
 public WebElement addButton;
 @FindBy(id = "inputGroupFile01")
 public WebElement imgBox;
 @FindBy(xpath = "//li[@class='ant-menu-item'][1]")
 public WebElement clientsButton;
 @FindBy(xpath = " //html")
 public WebElement wholePage;
 @FindBy(xpath = " //span[@class='ant-typography ant-typography-danger']")
 public WebElement deleteButton;
 @FindBy(xpath = " //button/span[contains(text(),'Yes')]")
 public WebElement yesButton;
 @FindBy(xpath = "//a[@href='/dashboard/services']")
 public WebElement servicesButton;
 @FindBy(xpath = "//span[contains(text(),'Add New Category')]")
 public WebElement addNewCategoryButton;


 //Add/Delete new category
 //@FindBy(xpath = "//input[@placeholder='Please enter a name']")
 @FindBy(id = "title")
 public WebElement addNewCategoryNameBox;
 @FindBy(id = "price")
 public WebElement addNewCategoryPriceBox;
 @FindBy(id = "duration")
 public WebElement addNewCategoryDurationDropDown;
 @FindBy(xpath = " //div[@class='rc-virtual-list-holder-inner']/div[1]/div")
 public WebElement duration30Minutes;
 @FindBy(id = "blockBefore")
 public WebElement blockBeforeBox;
 @FindBy(id = "blockAfter")
 public WebElement blockAfterBox;
 @FindBy(id = "paymentRequired")
 public WebElement paymentRequiredButton;
 @FindBy(id = "description")
 public WebElement descriptionBox;
 @FindBy(xpath = "//button[@type='submit']")
 public WebElement saveButton;
 @FindBy(xpath = "//div[contains(text(),'NewCategory1')]/parent::div/parent::div/parent::div//parent::div/ul/li[2]/span/span/*")
 public WebElement categoryDeleteButton;
 @FindBy(xpath = "//span[contains(text(),'OK')]")
 public WebElement categoryDeleteOKButton;

 //Add/Delete New Package
 @FindBy(id = "rc-tabs-0-tab-2")
 public WebElement packageTab;
 @FindBy(xpath = "//span[contains(text(),'Add New Package')]")
 public WebElement addNewpackageButton;
 @FindBy(xpath = "(//div/div/div/input[@placeholder='Please enter a name'])[2]")
 public WebElement packageNameBox;
 @FindBy(xpath = "(//div/input [@id='price'])[2]")
 public WebElement packagePriceBox;
 @FindBy(xpath = "(//input[@id='duration'])[2]")
 public WebElement packageDurationBox;
 @FindBy(xpath = " (//div[@class='rc-virtual-list-holder-inner']/div[1]/div)[2]")
 public WebElement packageDuration30Minutes;
 @FindBy(xpath = "(//button/div[@class='ant-switch-handle'])[2]")
 public WebElement blockExtraTimeButton;
 @FindBy(xpath = "(//input[@id='blockBefore'])[2]")
 public WebElement packageBlockBeforeBox;
 //(//input[@id='blockAfter']/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/*)[4]
 @FindBy(xpath = "(//input[@id='blockAfter'])[2]")
 public WebElement packageBlockAfterBox;
 @FindBy(xpath = "(//button[@id='paymentRequired'])[2]")
 public WebElement packagePaymentRequiredbutton;
 @FindBy(id = "totalSessions")
 public WebElement totalSessionsBox;
 @FindBy(id = "sessionInterval")
 public WebElement sessionIntervalBox;
 @FindBy(xpath = "(//textarea[@id='description'])[2]")
 public WebElement packageDescriptionBox;
 @FindBy(xpath = " (//button[@type='submit'])[2]")
 public WebElement packageSaveButton;
 @FindBy(xpath = "  //div[contains(text(),'NewPackage1')]/parent::div/parent::div/parent::div/parent::div/ul/li[2]")
 public WebElement newPackageDeleteButton;
 @FindBy(xpath = " //span[contains(text(),'OK')]")
 public WebElement packageDeleteOKButton;

 //Appointment Package1
 @FindBy(xpath = "//div[contains(text(),'Package1')]")
 public WebElement package1Button;
 @FindBy(xpath = "//span[@class='ant-select-selection-item']")
 public WebElement yearButton;

 @FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']")
 public List<WebElement> dropDownYear;

 @FindBy(xpath = "//div[@class='rc-virtual-list-scrollbar-thumb rc-virtual-list-scrollbar-thumb-moving']")
 public WebElement scrollButton;

 @FindBy(xpath = " //div[@label='2021']")
 public WebElement year2021;

 @FindBy(xpath = " //div[@label='2025']")
 public WebElement year2025;

 @FindBy(xpath = " //span[contains(text(),'Current Time')]")
 public WebElement currentTime;

 @FindBy(xpath = "  //div[@label='Sep']")
 public WebElement monthSep;

 @FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
 public WebElement monthButton;


 @FindBy(xpath = "(//div[contains(text(),'23')])[2]")
 public WebElement day30;

 @FindBy(xpath = "(//div[@class='ant-picker-calendar-date-content'])[24]")
 public WebElement day23;


 @FindBy(xpath = "//span[contains(text(),'06:55 AM')]")
 public WebElement time0655Button;

 @FindBy(xpath = "//span[contains(text(),'Yes')]")
 public WebElement appointmentYesButton;
 @FindBy(id = "basic_firstName")
 public WebElement appointmentNameBox;
 @FindBy(id = "basic_lastName")
 public WebElement appointmentLastNameBox;
 @FindBy(id = "basic_email")
 public WebElement appointmentEmailBox;
 @FindBy(id = "basic_phone")
 public WebElement appointmentPhoneBox;
 @FindBy(xpath = "//div[@class='ant-select-selection-overflow']")
 public WebElement majorConcernsDropDown;
 @FindBy(xpath = "//div[@title='Weight Loss Program']")
 public WebElement weightLossButton;
 @FindBy(xpath = "//span[contains(text(),'Submit')]")
 public WebElement appointmentSubmitButton;
 @FindBy(xpath = "//span[contains(text(),'Next')]")
 public WebElement appointmentNextButton;
 @FindBy(xpath = " //button[@aria-label='Close']")
 public WebElement closeButton;

 //Check For Appoinment

 @FindBy(xpath = "//span[contains(text(),'Calendar')]")
 public WebElement calendarButton;
 @FindBy(xpath = " //a[contains(text(),'Meetings')]")
 public WebElement meetingsButton;
 @FindBy(xpath = "//div[@class='ant-collapse-header']")
 public WebElement meetInfoButton;
 //(//span[contains(text(),'08:05 - Semra')])[1]
 @FindBy(xpath = "//span[contains(text(),'Cancel Appointment')]")
 public WebElement cancelAppointmentButton;
 @FindBy(xpath = "//span[contains(text(),'Yes')]")
 public WebElement cancelAppointmentYesButton;

 @FindBy(xpath = "//span[@class='anticon anticon-close']")
 public WebElement closeMeetInfoButton;

 // Zehra Smoke Test Sign Up as A Client and Sign Up as Therapist

 @FindBy(xpath = "//button[normalize-space()='Sign Up']")
 public WebElement signUpButton;

 @FindBy(xpath = "//a[normalize-space()='Client']")
 public WebElement registerClient;

 @FindBy(xpath = "//input[@id='name-input']")
 public WebElement inputName;

 @FindBy(xpath = "//input[@id='surname-input']")
 public WebElement inputSurName;

 @FindBy(xpath = "//input[@id='client_registration_form_email']") //input[@id='registration_form_email']
 public WebElement inputEmail;

 @FindBy(xpath = "//input[@id='pass-input']")
 public WebElement inputPassword;

 @FindBy(xpath = "//button[@id='register-submit']")
 public WebElement clickSignUp;

 @FindBy(xpath = "//a[normalize-space()='Therapist']")
 public WebElement registerTherapist;

 @FindBy(xpath = "//input[@id='fullname-input']")
 public WebElement inputFullName;

 @FindBy(xpath = "//input[@id='registration_form_email']")
 public WebElement inputTherapistEmail;

 @FindBy(xpath = "//input[@id='pass-input']")
 public WebElement inputTherapistPassword;

@FindBy(xpath = "//div[@role='alert']")
 public WebElement alertPopUp;




}