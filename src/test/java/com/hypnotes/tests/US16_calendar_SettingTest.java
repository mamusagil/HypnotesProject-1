package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.US16_calendar_SettingPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class US16_calendar_SettingTest extends CommonPage {
    US16_calendar_SettingPage us16Page = new US16_calendar_SettingPage();


    @Test
     public void loginWithValidCridentials(){
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link"));
        us16Page.loginButtonMD.click();
        ReusableMethods.waitFor(3);
        us16Page.emailBoxMD.sendKeys("mustafaduyarer@gmail.com");
        us16Page.passwordBoxMD.sendKeys("Bilbao48970/");
        ReusableMethods.waitFor(3);
        us16Page.loginButton1MD.click();
        ReusableMethods.waitFor(3);






    }


}
