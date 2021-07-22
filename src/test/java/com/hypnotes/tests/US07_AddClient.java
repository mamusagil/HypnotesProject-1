package com.hypnotes.tests;

import com.hypnotes.pages.US00_DenemePage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US07_AddClient extends ReusableMethods {
    US00_DenemePage us00DenemePage =new US00_DenemePage();
    ReusableMethods reusableMethods=new ReusableMethods();
    @BeforeTest
    public void loginTest() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us00DenemePage.loginButton.click();

        Thread.sleep(3000);
        us00DenemePage.emailBox.sendKeys(ConfigurationReader.getProperty("semra-email"));
        Thread.sleep(3000);
        us00DenemePage.passwordBox.sendKeys(ConfigurationReader.getProperty("semra-password"));
        Thread.sleep(3000);
        us00DenemePage.loginButton1.click();
        Thread.sleep(3000);


        Assert.assertTrue(us00DenemePage.afterLogin.isDisplayed());
        System.out.println("Login test passed");
        Thread.sleep(3000);
       //reusableMethods.clickWithJS(us00DenemePage.logoutButton);
      //  Thread.sleep(3000);

        us00DenemePage.addClientButton.click();
        Thread.sleep(3000);

    }

@Test
    public void positiveTest()throws InterruptedException{
        us00DenemePage.firstNameBox.sendKeys("Semra");
        Thread.sleep(2000);
    us00DenemePage.lastNameBox.sendKeys("Bilgic");
    Thread.sleep(2000);
    us00DenemePage.phoneNumberBox.sendKeys("12345678");
    Thread.sleep(2000);
    us00DenemePage.occupationBox.sendKeys("QA Tester");
    Thread.sleep(2000);
    us00DenemePage.imgButton.sendKeys("/Users/",ConfigurationReader.getProperty("user"),"/IdeaProjects/HypnotesProject/src/test/resources/Todd-Haynes-2017.jpeg");
    Thread.sleep(2000);
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    us00DenemePage.addButton.click();
    Thread.sleep(2000);



}



}
