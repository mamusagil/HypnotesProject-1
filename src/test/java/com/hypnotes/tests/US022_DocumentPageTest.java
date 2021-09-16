package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.US022_DocumentPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US022_DocumentPageTest extends ReusableMethods {

    CommonPage commonPage = new CommonPage();

    US022_DocumentPage test = new US022_DocumentPage();


    @BeforeTest
    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link_ayfer"));
        ReusableMethods.login(ConfigurationReader.getProperty("email_ayfer"),
                ConfigurationReader.getProperty("password_ayfer"));
    }

    @Test
    public void clickSelectFileButton() throws InterruptedException {
        test.documentButton.click();
        test.addDocument.click();

        String projectPath = System.getProperty("user.dir");

        System.out.println("projectPath = " + projectPath);
        Thread.sleep(3000);

        String filePath = "src/test/resources/ContactTracing1.pdf";

        String fullPath= projectPath + "/" + filePath;

        Thread.sleep(3000);

        test.selectFileButton.sendKeys(fullPath);

        Driver.getDriver().switchTo().activeElement().sendKeys(fullPath);

        System.out.println(fullPath);

       Thread.sleep(2000);
       ReusableMethods.hover(test.nextButton);
       test.nextButton.click();



    }


}
