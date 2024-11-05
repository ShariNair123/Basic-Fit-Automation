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


public class closeClub_Page {
    public closeClub_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[normalize-space()='Close Club']")
    WebElement CloseClub_Btn;
    private @FindBy(xpath = "//label[text()='Closure Type']/following-sibling::div//select")
    WebElement ClosureType_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Permanently Closed']")
    WebElement PermanentlyClosed_option;
    private @FindBy(xpath = "//label[text()='Closure Reason']/following-sibling::div//select")
    WebElement ClosureReason_Pcklst;
    private @FindBy(xpath = "//select[@class='slds-select']/option[@value='Legal']")
    WebElement ClosureReason_option;
    private @FindBy(xpath = "//input[@name='Club_Closure_Other_Reason']")
    WebElement ClosureReasonDescr_txt;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Next_Btn;
    //private @FindBy(xpath = "//span[@class='slds-form-element__label slds-assistive-text'][normalize-space()='Club active']/parent::label/span[1]")
    //WebElement ClubActive_checkbox;
    private @FindBy(xpath = "//input[@name='Club_active__c']")
    WebElement ClubActive_checkbox;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Closed']")
    WebElement ClubStatus_fld;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Permanently Closed']")
    WebElement ClosureType_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Legal']")
    WebElement ClosureReason_txt;
    private @FindBy(xpath = "//input[@name='Club_Closure_Other_Reason']")
    WebElement ClosureReasonDescr_text;
    private @FindBy(xpath = "//iframe[@title='accessibility title']")
    WebElement ClosureDetailsFrame;
    LocalDate currentDate = LocalDate.now();
    // Define the format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    // Format the current date
    String todayDate = currentDate.format(formatter);
    //String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));



    public void clickCloseButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(CloseClub_Btn);
        CloseClub_Btn.click();
        commonmethods.waitForLoad();
    }

    public void enterPermanentClosureDetails() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClosureDetailsFrame);
        driverContext.Driver.switchTo().frame(ClosureDetailsFrame);
        //Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[text()='Account - Club - Update Closure/Reopening Details']")).isDisplayed());
        commonmethods.waitUntilWebElementToBeClickable(ClosureType_Pcklst);
        commonmethods.staticWait(2000);
        ClosureType_Pcklst.click();
        commonmethods.waitForLoad();
        PermanentlyClosed_option.click();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReason_Pcklst);
        ClosureReason_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReason_option.click();
        ClosureReasonDescr_text.click();
        ClosureReasonDescr_text.sendKeys("Automation Test");
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

    public void verifyPermanentClubClosure() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubActive_checkbox);
        Assert.assertFalse(ClubActive_checkbox.isSelected(), "Club active checkbox should not be selected.");
        //Assert.assertFalse(ClubActive_checkbox.isDisplayed(), "The checkbox should be unchecked, but it is checked.");
        commonmethods.waitUntilWebElementIsVisible(ClubStatus_fld);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureType_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Permanently Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureReason_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Legal']")).isDisplayed());
        //commonmethods.waitUntilWebElementIsVisible(ClosureReasonDescr_text);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Automation Test']")).isDisplayed());

        WebElement ClosureDateElement = driverContext.Driver.findElement(By.xpath("//span[text()='Closure Date']/ancestor::dt/following-sibling::dd/descendant::slot/lightning-formatted-text"));
        String closureDateText = ClosureDateElement.getText();
        LocalDate parsedEndDate = LocalDate.parse(closureDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedEndDateOnly = parsedEndDate.format(formatter);
        Assert.assertEquals(reformattedEndDateOnly, todayDate, "End date should be today");

        //Assert.assertEquals(driverContext.Driver.findElement(By.xpath("//span[text()='Closure Date']/ancestor::dt/following-sibling::dd/descendant::slot/lightning-formatted-text")).getText(), todayDate,"The Closure Date is not today's date.");
    }

}