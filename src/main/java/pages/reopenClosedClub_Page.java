package pages;

import base.driverContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class reopenClosedClub_Page {

    public reopenClosedClub_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[normalize-space()='Reopen Closed Club']")
    WebElement ReopenClosedClub_btn;
    private @FindBy(xpath = "//iframe[@title='accessibility title']")
    WebElement ClosureDetailsFrame;
    private @FindBy(xpath = "//select[@name='Club_openings_type_2']/option[@value='Default Choice']")
    WebElement ClubOpeningsType_drpdwn;
    private @FindBy(xpath = "//select[@name='Club_openings_type_2']/option[@value='Club_openings_type_choices.Basic']")
    WebElement ClubOpeningsType_option;
    private @FindBy(xpath = "//select[@name='Opening_hours_type']/option[@value='Default Choice']")
    WebElement OpeningHoursType_drpdwn;
    private @FindBy(xpath = "//select[@name='Opening_hours_type']/option[@value='Opening_hours_type_choices.Type 1']")
    WebElement OpeningHoursType_option;
    private @FindBy(xpath = "//button[normalize-space(text())='Save and Close' and contains(@class, 'slds-button_brand')]")
    WebElement Next_Btn;
    private @FindBy(xpath = "//input[@name='Club_active__c']")
    WebElement ClubActive_checkbox;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Open']")
    WebElement ClubStatus_fld;
    private @FindBy(xpath = "//span[normalize-space()='Club openings type']/following::lightning-formatted-text[normalize-space()='Basic']")
    WebElement ClubOpeningsType_value;
    private @FindBy(xpath = "//span[normalize-space()='Opening Hours Type']/following::lightning-formatted-text[normalize-space()='Type 1']")
    WebElement OpeningHoursType_value;
    private @FindBy(xpath = "//div[contains(@data-target-selection-name,'sfdc:RecordField.Account.Closure_Type__c')]//lightning-formatted-text")
    WebElement ClosureType_value;
    private @FindBy(xpath = "//div[contains(@data-target-selection-name,'sfdc:RecordField.Account.Closure_Reason__c')]//lightning-formatted-text")
    WebElement ClosureReason_value;
    private @FindBy(xpath = "//div[contains(@data-target-selection-name,'sfdc:RecordField.Account.Closure_Date__c')]//lightning-formatted-text")
    WebElement ClosureDate_value;


    public void clickReopenClosedClubButton() {
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        ReopenClosedClub_btn.click();
    }

    public void selectClubOpeningsAndOpeningHoursType() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(ClosureDetailsFrame);
        driverContext.Driver.switchTo().frame(ClosureDetailsFrame);
        ClubOpeningsType_drpdwn.click();
        commonmethods.staticWait(1000);
        ClubOpeningsType_option.click();
        commonmethods.staticWait(1000);
        OpeningHoursType_drpdwn.click();
        commonmethods.staticWait(1000);
        OpeningHoursType_option.click();
    }

    public void clickOnSaveAndClose() {
        commonmethods.staticWait(2000);
        //commonmethods.waitForLoad();
        Next_Btn.click();
    }

    public void verifyClubReopen() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubActive_checkbox);
        Assert.assertTrue(ClubActive_checkbox.isSelected(), "Club active checkbox should be selected.");
        commonmethods.waitUntilWebElementIsVisible(ClubStatus_fld);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Open']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[contains(text(),'Closure Reason before reactivation: Maintenance')]")).isDisplayed());
        Assert.assertTrue(ClubOpeningsType_value.isDisplayed(), "'Basic' value is not displayed under the Club Openings Type field.");
        Assert.assertTrue(OpeningHoursType_value.isDisplayed(), "'Type 1' value is not displayed under the Opening Hours Type field.");
        String closureTypeText = ClosureType_value.getText();
        Assert.assertTrue(closureTypeText.isEmpty(), "The Closure Type field is not empty. Current value: " + closureTypeText);
        String closureReasonText = ClosureReason_value.getText();
        Assert.assertTrue(closureReasonText.isEmpty(), "The Closure Type field is not empty. Current value: " + closureReasonText);
        String closureDateText = ClosureDate_value.getText();
        Assert.assertTrue(closureDateText.isEmpty(), "The Closure Type field is not empty. Current value: " + closureDateText);
    }
}

