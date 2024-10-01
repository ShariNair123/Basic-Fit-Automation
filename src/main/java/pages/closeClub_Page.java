package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.util.concurrent.TimeUnit;


public class closeClub_Page {
    public closeClub_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[normalize-space()='Close Club']")
    WebElement CloseClub_Btn;
    private @FindBy(xpath = "//select[@id='select-54']")
    WebElement ClosureType_Pcklst;
    private @FindBy(xpath = "//select[@id='select-54']/option[@value='Permanently Closed']")
    WebElement PermanentlyClosed_option;
    private @FindBy(xpath = "//select[@id='select-55']")
    WebElement ClosureReason_Pcklst;
    private @FindBy(xpath = "//select[@id='select-55']/option[@value='Legal']")
    WebElement ClosureReason_option;
    private @FindBy(xpath = "//input[@name='Club_Closure_Other_Reason']")
    WebElement ClosureReasonDescr_txt;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Next_Btn;
    private @FindBy(xpath = "//span[@class='slds-form-element__label slds-assistive-text'][normalize-space()='Club active']")
    WebElement ClubActive_checkbox;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Closed']")
    WebElement ClubStatus_fld;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Permanently Closed']")
    WebElement ClosureType_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Legal']")
    WebElement ClosureReason_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Automation Test']")
    WebElement ClosureReasonDescr_text;



    public void clickCloseButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(CloseClub_Btn);
        CloseClub_Btn.click();
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[text()='This action is definitive']")).isDisplayed());
    }

    public void enterPermanentClosureDetails() {
        commonmethods.waitUntilWebElementToBeClickable(ClosureType_Pcklst);
        ClosureType_Pcklst.click();
        commonmethods.waitForLoad();
        PermanentlyClosed_option.click();
        commonmethods.waitUntilWebElementToBeClickable(ClosureReason_Pcklst);
        ClosureReason_Pcklst.click();
        commonmethods.waitForLoad();
        ClosureReason_option.click();
        ClosureReasonDescr_text.sendKeys("Automation Test");
    }

    public void clickNext() {
        Next_Btn.click();
    }

    public void clickSave() {
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[text()='Account - Club - Update Closure/Reopening Details.']")).isDisplayed());
        commonmethods.waitUntilWebElementToBeClickable(Next_Btn);
        Next_Btn.click();
    }

    public void verifyPermanentClubClosure() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubActive_checkbox);
        Assert.assertFalse(ClubActive_checkbox.isEnabled(), "The checkbox is enabled.");
        commonmethods.waitUntilWebElementIsVisible(ClubStatus_fld);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureType_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Permanently Closed']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureReason_txt);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Legal']")).isDisplayed());
        commonmethods.waitUntilWebElementIsVisible(ClosureReasonDescr_text);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Automation Test']")).isDisplayed());

    }

}