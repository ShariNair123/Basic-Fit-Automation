package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class tempCloseClub_Page {

    public tempCloseClub_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[normalize-space()='Close Club']")
    WebElement CloseClub_Btn;
    private @FindBy(xpath = "//iframe[@title='accessibility title']")
    WebElement ClosureDetailsFrame;
    private @FindBy(xpath = "//label[text()='Closure Type']/following-sibling::div//select")
    WebElement ClosureType_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Temporarily Closed']")
    WebElement TemporarilyClosed_option;
    private @FindBy(xpath = "//label[text()='Closure Reason']/following-sibling::div//select")
    WebElement ClosureReason_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Maintenance']")
    WebElement TempClosureReason_option;
    private @FindBy(xpath = "//input[@name='Club_Closure_Other_Reason']")
    WebElement ClosureReasonDescr_txt;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Next_Btn;
    private @FindBy(xpath = "//input[@name='Club_active__c']")
    WebElement ClubActive_checkbox;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Closed']")
    WebElement ClubStatus_fld;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Temporarily Closed']")
    WebElement ClosureType_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Maintenance']")
    WebElement ClosureReason_txt;
    private @FindBy(xpath = "//input[@name='Club_Closure_Other_Reason']")
    WebElement ClosureReasonDescr_text;
    private @FindBy(xpath = "//input[@name='Club_Rebuild_Start_Date_change']")
    WebElement ClubRebldStrtDate_clndr;
    private @FindBy(xpath = "//input[@name='Club_Rebuild_End_Date_change']")
    WebElement ClubRebldEndDate_clndr;
    private @FindBy(xpath = "//input[@name='Club_Re_open_Date']")
    WebElement ClubReopenDate_clndr;
    private @FindBy(xpath = "//input[@name='Partial_Reopening_End_Date']")
    WebElement ClubPartialReopenEndDate_clndr;
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    LocalDate twodaysafter = LocalDate.now().plusDays(2);
    LocalDate threedaysafter = LocalDate.now().plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
    private @FindBy(xpath = "//select[@name='Please_fill_in_Reopening_Time']")
    WebElement ReopeningTime_drpdwn;
    private @FindBy(xpath = "//option[@value='Club_Activity_ReopeningTime_Choices.08:00']")
    WebElement ReopeningTime_option;
    private @FindBy(xpath = "//input[@name='Partial_Reopening']")
    WebElement PartialReopening_chkbox;
    private @FindBy(xpath = "//select[@name='Partial_Opening_Hours_Type']")
    WebElement PartialReopngHoursType_drpdwn;
    private @FindBy(xpath = "//option[@value='Opening_hours_type_choices.Type 1']")
    WebElement PartialReopngHoursType_option;

    //LocalDate currentDate = LocalDate.now();
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //String todayDate = currentDate.format(formatter);





    public void clickCloseButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(CloseClub_Btn);
        CloseClub_Btn.click();
        commonmethods.waitForLoad();
    }

    public void enterTemporaryClosureDetails() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClosureDetailsFrame);
        driverContext.Driver.switchTo().frame(ClosureDetailsFrame);
        commonmethods.waitUntilWebElementToBeClickable(ClosureType_Pcklst);
        commonmethods.staticWait(2000);
        ClosureType_Pcklst.click();
        commonmethods.waitForLoad();
        TemporarilyClosed_option.click();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReason_Pcklst);
        ClosureReason_Pcklst.click();
        commonmethods.waitForLoad();
        TempClosureReason_option.click();
        ClosureReasonDescr_text.click();
        ClosureReasonDescr_text.sendKeys("Automation Test");
        ClubRebldStrtDate_clndr.click();
        String todayDate = today.format(formatter);
        WebElement todayElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + todayDate + "']"));
        todayElement.click();
        ClubRebldEndDate_clndr.click();
        String tomorrowDate = tomorrow.format(formatter);
        WebElement tomorrowElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + tomorrowDate + "']"));
        tomorrowElement.click();
        commonmethods.staticWait(2000);
        ClubReopenDate_clndr.click();
        String twodaysafterDate = twodaysafter.format(formatter);
        WebElement twodaysafterElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + twodaysafterDate + "']"));
        twodaysafterElement.click();
        ReopeningTime_drpdwn.click();
        ReopeningTime_option.click();
    }

    public void checkPartialReopeningFieldsForWithoutPartialReopeningScenario() {
        Assert.assertFalse(PartialReopening_chkbox.isSelected(), "The Partial Reopening checkbox should be unselected.");
    }

    public void enterPartialReopeningFieldValues() {
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", PartialReopening_chkbox);
        //PartialReopening_chkbox.click();
        commonmethods.staticWait(2000);
        ClubPartialReopenEndDate_clndr.click();
        commonmethods.staticWait(2000);
        String threedaysafterDate = threedaysafter.format(formatter);
        WebElement threedaysafterElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + threedaysafterDate + "']"));
        threedaysafterElement.click();
        PartialReopngHoursType_drpdwn.click();
        PartialReopngHoursType_option.click();
    }

    public void clickNext() {
        Next_Btn.click();
    }

    public void clickSave() {
        commonmethods.waitForLoad();
        //Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[text()='This action is definitive']")).isDisplayed());
        commonmethods.waitUntilWebElementToBeClickable(Next_Btn);
        Next_Btn.click();
    }

    public void verifyTemporaryClubClosure() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubActive_checkbox);
        Assert.assertTrue(ClubActive_checkbox.isSelected(), "Club active checkbox should be selected.");
        commonmethods.waitUntilWebElementIsVisible(ClubStatus_fld);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureType_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Temporarily Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureReason_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Maintenance']")).isDisplayed());
        //Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Automation Test']")).isDisplayed());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String todayDate = currentDate.format(formatter);
        WebElement ClosureDateElement = driverContext.Driver.findElement(By.xpath("//span[text()='Closure Date']/ancestor::dt/following-sibling::dd/descendant::slot/lightning-formatted-text"));
        String closureDateText = ClosureDateElement.getText();
        LocalDate parsedEndDate = LocalDate.parse(closureDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedEndDateOnly = parsedEndDate.format(formatter);
        Assert.assertEquals(reformattedEndDateOnly, todayDate, "End date should be today");
    }

}
