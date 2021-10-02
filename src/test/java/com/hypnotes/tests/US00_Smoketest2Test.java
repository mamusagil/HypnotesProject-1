package com.hypnotes.tests;

import com.hypnotes.pages.US00_SmokeTestPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

public class US00_Smoketest2Test {
    US00_SmokeTestPage us00DenemePage =new US00_SmokeTestPage();
@Test
    public void appointmentPackage1Assertion(){
    Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_appointment_semra_link"));
    ReusableMethods.waitFor(2);
    us00DenemePage.package1Button.click();
    ReusableMethods.waitFor(2);

    scrollDownToElement("10000");
    ReusableMethods.waitFor(2);
    us00DenemePage.yearButton.click();
    ReusableMethods.waitFor(2);

   JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
   je.executeScript("arguments[0].scrollIntoView();",us00DenemePage.year2021);


    us00DenemePage.year2021.click();
    ReusableMethods.waitFor(2);

    us00DenemePage.yearButton.click();
    ReusableMethods.waitFor(2);

    us00DenemePage.year2025.click();
    ReusableMethods.waitFor(2);

   us00DenemePage.monthButton.click();
    ReusableMethods.waitFor(2);

   us00DenemePage.monthSep.click();
   ReusableMethods.waitFor(2);

    us00DenemePage.day30.click();
    ReusableMethods.waitFor(3);

    us00DenemePage.time0655Button.click();
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
//    us00DenemePage.closeButton.click();
 //   ReusableMethods.waitFor(1);
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

  //  scrollDownToElement("100");
    us00DenemePage.yearButton.click();
   // JavascriptExecutor je1 = (JavascriptExecutor) Driver.getDriver();
    je.executeScript("arguments[0].scrollIntoView();",us00DenemePage.year2021);
    us00DenemePage.year2021.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.yearButton.click();
    ReusableMethods.waitFor(2);
    je.executeScript("arguments[0].scrollIntoView();",us00DenemePage.year2021);
    us00DenemePage.year2025.click();
    ReusableMethods.waitFor(2);
    Actions actions = new Actions(Driver.getDriver());
    actions.sendKeys(Keys.PAGE_UP).perform();
    ReusableMethods.waitFor(2);
    us00DenemePage.monthButton.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.monthSep.click();
    ReusableMethods.waitFor(2);

    actions.sendKeys(Keys.PAGE_DOWN).perform();
    String textDay23=us00DenemePage.day23.getText();
    ReusableMethods.waitFor(3);

 //  Actions actions = new Actions(Driver.getDriver());
   //
    SoftAssert assertt=new SoftAssert();
    assertt.assertEquals(textDay23,"06:55 AM - Semra");
    System.out.println("Appointment is scheduled");
   // assertt.assertAll();
    ReusableMethods.waitFor(2);
    us00DenemePage.day23.click();
    us00DenemePage.meetInfoButton.click();
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    us00DenemePage.cancelAppointmentButton.click();
    ReusableMethods.waitFor(2);
    us00DenemePage.cancelAppointmentYesButton.click();
    ReusableMethods.waitFor(2);
    System.out.println("Appointment Canceled");
    ReusableMethods.waitFor(3);
    us00DenemePage.closeMeetInfoButton.click();
    ReusableMethods.waitFor(2);
    actions.sendKeys(Keys.PAGE_UP).perform();
    ReusableMethods.waitFor(1);
    ReusableMethods.logout();


}
    public  void scrollDownToElement(String value) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,"+value+")");
    }
}
