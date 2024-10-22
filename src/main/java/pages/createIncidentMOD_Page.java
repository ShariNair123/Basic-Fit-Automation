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
import java.util.concurrent.TimeUnit;

public class createIncidentMOD_Page {

    public createIncidentMOD_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[@name='Account.MOD_club_closure']")
    WebElement MODClubClosure_btn;
    private @FindBy(xpath = "//label[text()='Closure reason']/following-sibling::div//select")
    WebElement ClosureReason_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Club damage']")
    WebElement ClosureReason_option;
    private @FindBy(xpath = "//label[text()='Closure reason sub-category']/following-sibling::div//select")
    WebElement ClosureReasonSubCtgry_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Water leakage']")
    WebElement ClosureReasonSubCtgry_option;
    private @FindBy(xpath = "//input[@name='dp_Other_Description']")
    WebElement OtherDescr_txt;
    private @FindBy(xpath = "//select[@name='dp_Reopening_type']")
    WebElement ReopeningType_dropdown;
    private @FindBy(xpath = "//select[@name='dp_Reopening_type']/option[@value='reopeningTypeChoices.Unknown']")
    WebElement ReopeningType_unknown;
    private @FindBy(xpath = "//select[@name='dp_Reopening_type']/option[@value='reopeningTypeChoices.Known']")
    WebElement ReopeningType_known;
    private @FindBy(xpath = "//input[@name='dp_Reopening_Date']")
    WebElement ReopeningDate_clndr;
    private @FindBy(xpath = "//select[@name='dp_Reopening_time']")
    WebElement ReopeningTime_clndr;
    private @FindBy(xpath = "//option[@value='reopeningTimeChoices.08:00']")
    WebElement ReopeningTimeSelect_drpdwn;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Submit_btn;
    private @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement Submit_button;
    private @FindBy(xpath = "//button[normalize-space()='Finish']")
    WebElement Finish_btn;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Closed']")
    WebElement ClubStatus_fld;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Temporarily Closed']")
    WebElement ClosureType_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Incident']")
    WebElement ClosureReason_txt;
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");




    public void clickMODClubClosureButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementToBeClickable(MODClubClosure_btn);
        MODClubClosure_btn.click();
        commonmethods.waitForLoad();
    }

    public void enterUnknownIncidentDetails() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReason_Pcklst);
        ClosureReason_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReason_option.click();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReasonSubCtgry_Pcklst);
        ClosureReasonSubCtgry_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReasonSubCtgry_option.click();
        OtherDescr_txt.click();
        OtherDescr_txt.sendKeys("Automation Test");
        ReopeningType_dropdown.click();
        ReopeningType_unknown.click();

    }

    public void enterKnownIncidentDetails() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReason_Pcklst);
        ClosureReason_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReason_option.click();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReasonSubCtgry_Pcklst);
        ClosureReasonSubCtgry_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReasonSubCtgry_option.click();
        OtherDescr_txt.click();
        OtherDescr_txt.sendKeys("Automation Test");
        ReopeningType_dropdown.click();
        ReopeningType_known.click();
        commonmethods.scrollIntoTheViewAndClick(ReopeningDate_clndr);
        //ReopeningDate_clndr.click();
        String tomorrowDate = tomorrow.format(formatter);
        WebElement tomorrowElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + tomorrowDate + "']"));
        tomorrowElement.click();
        commonmethods.scrollIntoTheViewAndClick(ReopeningTime_clndr);
        //ReopeningTime_clndr.click();
        ReopeningTimeSelect_drpdwn.click();

    }

    public void submitUnknownIncidentDetails() {
        Submit_btn.click();
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//p[contains(text(),'Reopening date is unknown, do you want to continue')]")).isDisplayed());
        Submit_button.click();
        commonmethods.staticWait(2000);
    }

    public void submitKnownIncidentDetails() {
        Submit_btn.click();
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//p[contains(text(),'You are about to submit the incident, do you want to continue?')]")).isDisplayed());
        Submit_button.click();
        commonmethods.staticWait(2000);
    }

    public void verifyIncidentCreationMessage() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(5000);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[contains(text(),'The incident was created.')]")).isDisplayed());
        Finish_btn.click();
    }

    public void verifyClubOperationalStatusIcon() {
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//img[@alt='Closed']")).isDisplayed());
    }

    public void verifyClubClosure() {
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubStatus_fld);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureType_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Temporarily Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureReason_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Incident']")).isDisplayed());

    }
}
