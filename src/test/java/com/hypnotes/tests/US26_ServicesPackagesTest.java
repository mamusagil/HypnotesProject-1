package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.ServicesPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US26_ServicesPackagesTest extends ReusableMethods {
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
    public void servicesPackages(){
        services.servicesButton.click();
        services.packagesButton.click();
        ReusableMethods.waitFor(1);
        services.addNewPackage.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(services.createPackageTitle.isDisplayed());
    }

    @Test(priority = 2)
    public void packagesAdd(){
        String name = "Apple";
        String price = "1000";
        String duration = "100";

        String totalSessions = "24";
        String sessionInterval = "1";
        String beforeTime = "5";
        String afterTime = "10";
        String description = "Package test";

        services.inputPackageName.sendKeys(name);
        services.inputPackagePrice.sendKeys(price);
        services.inputPackageDuration.sendKeys(duration);
        //services.blockExtraTime.click();

        ReusableMethods.waitFor(1);
        services.totalSessions.sendKeys(totalSessions);
        services.sessionInterval.sendKeys(sessionInterval);
        services.descriptionPackage.sendKeys(description);

        ReusableMethods.clickWithJS(services.savePackageButton);
        ReusableMethods.waitFor(1);

        String actualText = services.getCategoryItems.get(0).getText() + " " + services.getDuration.get(0).getText()
                + " " + services.getPrice.get(0).getText()+ " " + services.getSessions.get(0).getText()
                + " " + services.getInterval.get(0).getText();

        String expectedText = name +" Duration: " + duration + " mins Price: $" + price
                + " Total Sessions: " + totalSessions + " Interval: " + sessionInterval + " weeks";

        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText );

    }


    @Test(priority = 3)
    public void packagesEdit(){


        int index = -1;
        for (int i = 0; i < services.getCategoryItems.size(); i++) {
            if(services.getCategoryItems.get(i).getText().equals("Apple"))
                index = i;
        }

        ReusableMethods.clickWithJS(services.editButton.get(index));

        String name = "Banana";
        String price = "3";
        String duration = "3";

        String totalSessions = "5";
        String sessionInterval = "5";
        String beforeTime = "5";
        String afterTime = "10";
        String description = "Package edit test";

        ReusableMethods.cleanTextInBox(services.inputPackageName);
        ReusableMethods.waitFor(1);
        services.inputPackageName.sendKeys(name);

        ReusableMethods.cleanTextInBox(services.inputPackagePrice);
        ReusableMethods.waitFor(1);
        services.inputPackagePrice.sendKeys(price);

        ReusableMethods.cleanTextInBox(services.inputPackageDuration);
        ReusableMethods.waitFor(1);
        services.inputPackageDuration.sendKeys(duration);

        ReusableMethods.cleanTextInBox(services.totalSessions);
        ReusableMethods.waitFor(1);
        services.totalSessions.sendKeys(totalSessions);

        ReusableMethods.cleanTextInBox(services.sessionInterval);
        ReusableMethods.waitFor(1);
        services.sessionInterval.sendKeys(sessionInterval);

        ReusableMethods.cleanTextInBox(services.descriptionPackage);
        ReusableMethods.waitFor(1);
        services.descriptionPackage.sendKeys(description);

        ReusableMethods.clickWithJS(services.savePackageButton);
        ReusableMethods.waitFor(1);

        String actualText = services.getCategoryItems.get(index).getText() + " " + services.getDuration.get(index).getText()
                + " " + services.getPrice.get(index).getText()+ " " + services.getSessions.get(index).getText()
                + " " + services.getInterval.get(index).getText();

        String expectedText = name +" Duration: " + duration + " mins Price: $" + price
                + " Total Sessions: " + totalSessions + " Interval: " + sessionInterval + " weeks";

        //System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText );

    }


    @Test(priority = 4)
    public void servicesDelete(){

        int index = -1;
        for (int i = 0; i < services.getCategoryItems.size(); i++) {
            if(services.getCategoryItems.get(i).getText().equals("Banana"))
                index = i;
        }

        ReusableMethods.clickWithJS(services.deleteButton.get(index));
        //services.deleteButton.get(0).click();
        ReusableMethods.waitFor(1);
        services.okButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(services.getCategoryItems.isEmpty());
        //ReusableMethods.logout();
    }

}
