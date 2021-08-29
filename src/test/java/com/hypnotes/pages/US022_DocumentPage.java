package com.hypnotes.pages;

import com.hypnotes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US022_DocumentPage {

    public US022_DocumentPage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//a[@href='/dashboard/documents']")
    public WebElement documentButton;

    @FindBy(xpath = "//span[contains(text(),'Add Document')]")
    public WebElement addDocument;

    @FindBy(xpath = "//button[@class='ant-btn']")
    public WebElement selectFileButton;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement nextButton;
}
