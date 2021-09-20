package com.hypnotes.tests;

import com.hypnotes.pages.US00_SmokeTestPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US00_Smoketest1Test extends ReusableMethods{
    US00_SmokeTestPage us00DenemePage =new US00_SmokeTestPage();
   // ReusableMethods reusableMethods=new ReusableMethods();
    @BeforeTest
    public void login() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us00DenemePage.loginButton.click();

        ReusableMethods.waitFor(1);
        us00DenemePage.emailBox.sendKeys(ConfigurationReader.getProperty("semra-email"));
        ReusableMethods.waitFor(1);
        us00DenemePage.passwordBox.sendKeys(ConfigurationReader.getProperty("semra-password"));
        ReusableMethods.waitFor(1);
        us00DenemePage.loginButton1.click();
        ReusableMethods.waitFor(1);


       // Assert.assertTrue(us00DenemePage.afterLogin.isDisplayed());
      //  System.out.println("Login test passed");
      //  ReusableMethods.waitFor(2);
       //reusableMethods.clickWithJS(us00DenemePage.logoutButton);
      //  Thread.sleep(3000);



    }

    @Test (priority = 2)
    public void clintAddDelete()throws InterruptedException {

    us00DenemePage.addClientButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.firstNameBox.sendKeys("Semra");
    ReusableMethods.waitFor(1);
    us00DenemePage.lastNameBox.sendKeys("Bilgic");
    ReusableMethods.waitFor(1);
    us00DenemePage.phoneNumberBox.sendKeys("12345678");
    ReusableMethods.waitFor(1);
    us00DenemePage.occupationBox.sendKeys("QA Tester");
    ReusableMethods.waitFor(1);

    String projectPath = System.getProperty("user.dir");
    System.out.println("projectPath = " + projectPath);
    String filePath = "src/test/resources/Todd-Haynes-2017.jpeg";

    String fullPath= projectPath + "/" + filePath;

    System.out.println(fullPath);

    us00DenemePage.imgBox.sendKeys(fullPath);
    ReusableMethods.waitFor(1);
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    ReusableMethods.waitFor(1);
    us00DenemePage.addButton.click();


    ReusableMethods.waitFor(2);

    us00DenemePage.clientsButton.click();
    ReusableMethods.waitFor(1);

    String wholePageText = us00DenemePage.wholePage.getText();
    System.out.println(wholePageText);
    int count = 0;
    String[] words = wholePageText.split("\\s+");
    System.out.println("-----------------------");
    System.out.println(words[2]);
    System.out.println(words.length);
    System.out.println("-----------------------");

    for(int i=0; i<words.length;i++)
    {
        if(words[i].equals("Phone")){
            count++;
        }
    }
    System.out.println(count);
    Assert.assertTrue(count!=0);
    System.out.println("Clint is added");

    us00DenemePage.deleteButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.yesButton.click();
    ReusableMethods.waitFor(3);
    System.out.println("Clint is deleted");
      //  ReusableMethods.logout();

}

    @Test (priority = 3)
     public void categoryAddDelete()throws InterruptedException {
        us00DenemePage.servicesButton.click();
        us00DenemePage.addNewCategoryButton.click();
        us00DenemePage.addNewCategoryNameBox.sendKeys("NewCategory1");
        us00DenemePage.addNewCategoryPriceBox.sendKeys("40");
        us00DenemePage.addNewCategoryDurationDropDown.click();
        us00DenemePage.duration30Minutes.click();
        us00DenemePage.blockBeforeBox.sendKeys("5");
        us00DenemePage.blockAfterBox.sendKeys("5");
        us00DenemePage.paymentRequiredButton.click();
        us00DenemePage.descriptionBox.sendKeys("NewCategory1 Description");
        us00DenemePage.saveButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(2);
        System.out.println("New Category is Added");
        ReusableMethods.waitFor(2);
        us00DenemePage.categoryDeleteButton.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(us00DenemePage.categoryDeleteOKButton);
        ReusableMethods.waitFor(2);
        System.out.println("New Category is Deleted");
      //  ReusableMethods.logout();

    }
    @Test (priority = 4)
    public void packageAddDelete()throws InterruptedException {
        us00DenemePage.servicesButton.click();
        us00DenemePage.packageTab.click();
        us00DenemePage.addNewpackageButton.click();
        us00DenemePage.packageNameBox.sendKeys("NewPackage1");
        us00DenemePage.packagePriceBox.sendKeys("40");
        us00DenemePage.packageDurationBox.click();
        us00DenemePage.packageDuration30Minutes.click();
        us00DenemePage.blockExtraTimeButton.click();
        us00DenemePage.packageBlockBeforeBox.sendKeys("5");
        ReusableMethods.waitFor(2);
        us00DenemePage.packageBlockAfterBox.sendKeys("5");
        us00DenemePage.packagePaymentRequiredbutton.click();
        us00DenemePage.totalSessionsBox.sendKeys("4");
        us00DenemePage.sessionIntervalBox.sendKeys("1");
        us00DenemePage.packageDescriptionBox.sendKeys("NewPackage1 Description");
        us00DenemePage.packageSaveButton.click();
        ReusableMethods.waitFor(2);
        System.out.println("New Package is Added");
        us00DenemePage.newPackageDeleteButton.click();
        ReusableMethods.waitFor(1);
        us00DenemePage.packageDeleteOKButton.click();
        ReusableMethods.waitFor(2);
        System.out.println("New Package is Deleted");
        logout();
    }


}
