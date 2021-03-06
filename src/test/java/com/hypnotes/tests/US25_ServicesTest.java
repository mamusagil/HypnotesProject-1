package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.ServicesPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US25_ServicesTest extends ReusableMethods {
    CommonPage CommonPage =new CommonPage();
    ServicesPage services = new ServicesPage();
    
    @BeforeTest
    public void login() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_linkm"));
        CommonPage.loginButton.click();
        ReusableMethods.waitFor(1);
        CommonPage.emailBox.sendKeys(ConfigurationReader.getProperty("mukremin-email"));
        ReusableMethods.waitFor(1);
        CommonPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password-mukremin"));
        ReusableMethods.waitFor(1);
        CommonPage.loginButton1.click();
        ReusableMethods.waitFor(1);

    }

    @Test(priority = 1)
    public void servicesCategory(){
        services.servicesButton.click();
        services.categoryButton.click();
        ReusableMethods.waitFor(1);
        services.addNewCategory.click();
        ReusableMethods.waitFor(1);
    }


    @Test(priority = 2)
    public void categoryAdd(){
        String name = "Golden";
        String price = "90";
        String duration = "40";
        String beforeTime = "5";
        String afterTime = "10";
        String description = "Golden category test";

        services.inputName.sendKeys(name);
        services.inputPrice.sendKeys(price);
        services.inputDuration.sendKeys(duration);
        services.blockBefore.sendKeys(beforeTime);
        services.blockAfter.sendKeys(afterTime);
        services.description.sendKeys(description);

        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(services.saveButton);
        ReusableMethods.waitFor(1);

        String actualText = services.getCategoryItems.get(0).getText() + " " + services.getDuration.get(0).getText()
                + " " + services.getPrice.get(0).getText();

        //System.out.println(actualText);
        Assert.assertEquals(actualText, name +" Duration: " + duration + " mins Price: $" + price);
    }


    @Test(priority = 3)
    public void servicesEdit(){

        int index = -1;
        for (int i = 0; i < services.getCategoryItems.size(); i++) {
            if(services.getCategoryItems.get(i).getText().equals("Golden"))
                index = i;
        }

        services.editButton.get(index).click();
        String name = "Silver";
        String price = "100";
        String duration = "30";
        String beforeTime = "15";
        String afterTime = "10";
        String description = "Silver category test";

        //services.categoryName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        ReusableMethods.cleanTextInBox(services.inputName);
        ReusableMethods.waitFor(1);
        services.inputName.sendKeys(name);

        ReusableMethods.cleanTextInBox(services.inputPrice);
        ReusableMethods.waitFor(1);
        services.inputPrice.sendKeys(price);

        ReusableMethods.cleanTextInBox(services.inputDuration);
        ReusableMethods.waitFor(1);
        services.inputDuration.sendKeys(duration);

        ReusableMethods.cleanTextInBox(services.blockBefore);
        ReusableMethods.waitFor(1);
        services.blockBefore.sendKeys(beforeTime);

        ReusableMethods.cleanTextInBox(services.blockAfter);
        ReusableMethods.waitFor(1);
        services.blockAfter.sendKeys(afterTime);

        ReusableMethods.cleanTextInBox(services.description);
        ReusableMethods.waitFor(1);
        services.description.sendKeys(description);
        ReusableMethods.waitFor(1);

        ReusableMethods.clickWithJS(services.saveButton);
        ReusableMethods.waitFor(1);
        String actualText = services.getCategoryItems.get(index).getText() + " " + services.getDuration.get(index).getText()
                + " " + services.getPrice.get(index).getText();

        //System.out.println(actualText);
        Assert.assertEquals(actualText, name +" Duration: " + duration + " mins Price: $" + price);

    }


    @Test(priority = 4)
    public void servicesDelete(){

        int index = -1;
        for (int i = 0; i < services.getCategoryItems.size(); i++) {
            if(services.getCategoryItems.get(i).getText().equals("Silver"))
                index = i;
        }

        services.deleteButton.get(index).click();
        ReusableMethods.waitFor(1);
        services.okButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1);
        //System.out.println(services.getCategoryItems.size());
        Assert.assertTrue(services.getCategoryItems.isEmpty());
        ReusableMethods.logout();
    }
}
