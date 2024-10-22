package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class clubActivity_Page {

    public clubActivity_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//span[@title='Incidents']")
    WebElement Incidents_link;
    private @FindBy(xpath = "//table[@aria-label=\"Incidents\"]/tbody/tr/th//a/span/slot/span")
    WebElement ClubActivity_link;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Status']//lightning-formatted-text[normalize-space()='Submitted']")
    WebElement StatusValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Owner']//slot[normalize-space()='RS Tech Club Activity']")
    WebElement OwnerValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Club Activity Name']//lightning-formatted-text")
    WebElement ClubActivityName_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Club']//div[@class='slds-form-element__control']//div[@class='slds-grid']//span//slot//span")
    WebElement ClubName_Txt;
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String expectedDateTomorrow = tomorrow.format(formatter);
    LocalDate today = LocalDate.now();
    String expectedDateToday = today.format(formatter);


    public void selectClubActivityRecord() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(Incidents_link);
        Incidents_link.click();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(ClubActivity_link);
        ClubActivity_link.click();
    }

    public void verifyClubActivityDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        String StatusText = StatusValue_fld.getText();
        Assert.assertEquals(StatusText, "Submitted", "Status is not Submitted!");
        String OwnerText = OwnerValue_fld.getText();
        Assert.assertEquals(OwnerText, "RS Tech Club Activity", "Owner is not correctly assigned");
        String clubActivityNameText = ClubActivityName_fld.getText();
        Assert.assertFalse(clubActivityNameText.isEmpty(), "Club Activity Name should not be empty");

        //String clubNameValue = ClubName_Txt.getText();
        //Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue,  "Club Name should be same");

        WebElement closureDateElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Closure_Date__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String closureDateText = closureDateElement.getText();
        String closureDateOnly = closureDateText.split(" ")[0];

        Assert.assertEquals(closureDateOnly, expectedDateToday, "Closure Date should be today's date");
        //verify that the closure date time is today

        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Club damage']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Water leakage']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Automation Test']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Known']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='08:00']")).isDisplayed());

        WebElement reopeningDateElement = driverContext.Driver.findElement(By.xpath("//records-record-layout-item[@field-label='Reopening Date']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String reopeningDateText = reopeningDateElement.getText();
        Assert.assertEquals(reopeningDateText, expectedDateTomorrow, "Reopening Date should be tomorrow's date");

        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[normalize-space()='Incident']")).isDisplayed());

    }
}
