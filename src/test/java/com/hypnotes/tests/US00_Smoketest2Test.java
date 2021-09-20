package com.hypnotes.tests;

import com.hypnotes.pages.US00_SmokeTestPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US00_Smoketest2Test {
    US00_SmokeTestPage us00DenemePage =new US00_SmokeTestPage();
@Test
    public void appointmentPackage1Assertion(){
    Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_appointment_semra_link"));
    ReusableMethods.waitFor(2);
    us00DenemePage.package1Button.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.dateButton.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.time0800Button.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.appointmentYesButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.appointmentNameBox.sendKeys("Semra ");
    us00DenemePage.appointmentLastNameBox.sendKeys("Patient");
    us00DenemePage.appointmentEmailBox.sendKeys("sss@gmail.com");
    us00DenemePage.appointmentPhoneBox.sendKeys("111111");
    us00DenemePage.majorConcernsDropDown.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.weightLossButton.click();
    //select.selectByIndex(1);
    ReusableMethods.waitFor(1);
    us00DenemePage.appointmentSubmitButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.appointmentNextButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.appointmentSubmitButton.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.closeButton.click();
    ReusableMethods.waitFor(1);
         //   WebDriverWait wt = new WebDriverWait(driver,6);
    // elementToBeClickable expected criteria
  //  wt.until(ExpectedConditions.elementToBeClickable (By.className("s-buy")));
//Check For Appointment

            Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
    us00DenemePage.loginButton.click();

    ReusableMethods.waitFor(1);
    us00DenemePage.emailBox.sendKeys(ConfigurationReader.getProperty("semra-email"));
    ReusableMethods.waitFor(1);
    us00DenemePage.passwordBox.sendKeys(ConfigurationReader.getProperty("semra-password"));
    ReusableMethods.waitFor(1);
    us00DenemePage.loginButton1.click();
    ReusableMethods.waitFor(1);

    us00DenemePage.calendarButton.click();
    ReusableMethods.waitFor(1);
    us00DenemePage.meetingsButton.click();
    ReusableMethods.waitFor(1);
//    us00DenemePage.dateBox.click();
    ReusableMethods.waitFor(1);
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    SoftAssert assertt=new SoftAssert();
    assertt.assertTrue(us00DenemePage.semra08text.isDisplayed());
    System.out.println("Appointment is scheduled");
    assertt.assertAll();
    ReusableMethods.waitFor(2);
    actions.sendKeys(Keys.PAGE_UP).perform();
    ReusableMethods.waitFor(3);
    ReusableMethods.logout();


}
}
