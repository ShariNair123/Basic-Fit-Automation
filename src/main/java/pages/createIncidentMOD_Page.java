package pages;

import base.driverContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.util.List;
import java.util.Map;
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
    private @FindBy(xpath = "//select[@id='select-944']/option[@value='Club damage']")
    WebElement ClosureReason_option;
    private @FindBy(xpath = "//label[text()='Closure reason sub-category']/following-sibling::div//select")
    WebElement ClosureReasonSubCtgry_Pcklst;
    private @FindBy(xpath = "//select[@id='select-946']/option[@value='Water leakage']")
    WebElement ClosureReasonSubCtgry_option;
    private @FindBy(xpath = "//input[@name='dp_Other_Description']")
    WebElement OtherDescr_txt;
    private @FindBy(xpath = "//select[@name='dp_Reopening_type']")
    WebElement ReopeningType_dropdown;
    private @FindBy(xpath = "//select[@name='dp_Reopening_type']/option[@value='reopeningTypeChoices.Unknown']")
    WebElement ReopeningType_unknown;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Submit_btn;
    private @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement Submit_button;
    private @FindBy(xpath = "//button[normalize-space()='Finish']")
    WebElement Finish_btn;


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

    public void submitIncidentDetails() {
        Submit_btn.click();
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//p[contains(text(),'Reopening date is unknown, do you want to continue')]")).isDisplayed());
        Submit_button.click();
    }

    public void verifyIncidentCreation() {
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[contains(text(),'The incident was created.')]")).isDisplayed());
        Finish_btn.click();
    }

    public void verifyAccountPage() {
        commonmethods.staticWait(3000);
        commonmethods.waitForLoad();
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("(//img[@alt='Closed'])[2]]")).isDisplayed());
    }
}
