package com.hypnotes.tests;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.US07_ClientManagement_ClientPage;
import com.hypnotes.utilities.ConfigurationReader;
import com.hypnotes.utilities.Driver;
import com.hypnotes.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class US07_ClientManagementTest extends ReusableMethods {

    CommonPage commonPage = new CommonPage();
    US07_ClientManagement_ClientPage test = new US07_ClientManagement_ClientPage();

    @BeforeTest
    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("hypnotes_link_ayfer"));
        ReusableMethods.login(ConfigurationReader.getProperty("email_ayfer"),
                ConfigurationReader.getProperty("password_ayfer"));
    }

    @Test(priority = 1) //AC-2 If there is no saved client, show no client yet design with add new client button.
    public void noSavedClientShowNoClient(){

        String noClientsSaved = test.noClientsSaved.getText();
        Assert.assertEquals(noClientsSaved,"No clients yet");

    }


    @Test(priority =2) // AC-1 : Saved clients should be listed
    public void savedClientsShouldBeListed() throws InterruptedException {

        // After Login
        test.addClientButton.click();
        test.firstName.sendKeys("Ahmet");
        test.lastName.sendKeys("Bartin");
        test.phone.sendKeys("1234567891");
        //test.addButton.click();
        ReusableMethods.clickWithJS(test.addButton);
        Thread.sleep(1000);
        //Move to add client button;
        ReusableMethods.clickWithJS(test.addClientButton2);
//        test.addClientButton2.click();

        //
        test.firstName.sendKeys("Cemre");
        test.lastName.sendKeys("Deniz");
        test.phone.sendKeys("23456789122");
        ReusableMethods.clickWithJS(test.addButton);
        ReusableMethods.clickWithJS(test.clients);
        //test.clients.click(); // to go back to all clients

        List<String> names = ReusableMethods.getElementsText(test.getClientNames);

        Assert.assertEquals(names.get(0),"Ahmet Bartin");
        Assert.assertEquals(names.get(1),"Cemre Deniz");

    }

    @Test(priority =3) //AC-03 User will be able to search clients with their names, last names or emails
    public void searchClientsWithNames(){

        test.searchByName.sendKeys("Ahmet Bartin");
        test.getSearchByNameButton.click();

        String savedClient = test.afterSearchSavedClient.getText();
        Assert.assertEquals(savedClient,"Ahmet Bartin");
    }

//    @Test // AC-05 user can delete client by clicking Delete button but should see confirmation of deletion popup
//    public void userCanDeleteClientSeePopup() throws InterruptedException {
//        test.deleteButtons.get(0).click();
//        Thread.sleep(1000);
//        String deleteConfirm = test.deleteConfirmation.getText();
//
//        Assert.assertEquals(deleteConfirm,"Are you sure to delete this client?");
//
//
//    }


    @Test(priority =4) //AC-04 Listed clients will be clickable to navigate client details page
    public void listedClientsWillBeClickable(){
        test.isClientClickable.get(0).click(); // click
        ReusableMethods.hover(test.editButton);
        String editButton = test.editButton.getText();
        Assert.assertEquals(editButton,"Edit");
        ReusableMethods.logout();
    }



//    @Test //AC-06 when user confirm deletion of client will see message "Client deleted."
//    public void userConfirmDeletionAndSeeClientDeleted() {
//        test.deleteButtons.get(0).click();
//
//
//    }
}
