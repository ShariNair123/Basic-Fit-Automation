package pages;

import base.driverContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class caseCreation_Page {

    public caseCreation_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//a[@title='Cases']")
    WebElement Cases_title;
    private @FindBy(xpath = "//div[@title='New']")
    WebElement NewCase_Btn;
    private @FindBy(xpath = "//span[normalize-space()='Agent HC Belgium (Dutch)']")
    WebElement AgentDutch_lbl;
    private @FindBy(xpath = "//label[.//span[text()='Late Club Opening']]//span[@class='slds-radio--faux']")
    WebElement LateClubOpening_RdoBtn;
    private @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement Next_Btn;
    private @FindBy(xpath = "//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly recordlayout_in_editing_mode is-stacked']//slot[contains(text(),'Automation RS')]")
    WebElement CaseOwner_Txt;
    private @FindBy(xpath = "//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly recordlayout_in_editing_mode is-stacked']//span[contains(text(),'Late Club Opening')]")
    WebElement CaseRecordType_Txt;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Club_Involved__c']//div//input[@placeholder='Search Accounts...']")
    WebElement ClubInv_lkup;
    private @FindBy(xpath = "//li[@role='presentation']//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']")
    WebElement ClubInv_option;
    private @FindBy(xpath = "//input[@name='Subject']")
    WebElement Subject_txt;
    private @FindBy(xpath = "//button[@aria-label='Case Origin']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement CaseOrigin_option;
    private @FindBy(xpath = "//lightning-base-combobox-item[@data-value='MOD']")
    WebElement SelectCaseOrigin_drpdwn;
    private @FindBy(xpath = "//button[@aria-label='Outcome']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement Outcome_option;
    private @FindBy(xpath = "//div[@aria-label='Outcome']//lightning-base-combobox-item[@data-value='Confirmed [Guard Requested]']")
    WebElement SelectCaseOutcome_drpdwn;
    private @FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='Club_opened_at__c']")
    WebElement ClubOpenDate_cldr;
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
    private @FindBy(xpath = "//textarea[@class='slds-textarea']")
    WebElement Description_txt;
    private @FindBy(xpath = "//button[@name='SaveEdit']")
    WebElement Save_btn;
    private @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    WebElement CaseCreation_ToastMessage;


    public void goToCasesPage() {
        //commonmethods.staticWait(2000);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(Cases_title);
        Cases_title.click();
    }

    public void clickNewButton() {
        //commonmethods.staticWait(2000);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(NewCase_Btn);
        NewCase_Btn.click();
    }

    public void selectRecordTypeLateClubOpening() {
        commonmethods.staticWait(2000);
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        //commonmethods.waitUntilWebElementIsVisible(LateClubOpening_RdoBtn);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", AgentDutch_lbl);
        commonmethods.staticWait(4000);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", LateClubOpening_RdoBtn);
        //LateClubOpening_RdoBtn.click();
        Next_Btn.click();
    }

    public void verifyAutoPopulatedLateClubOpeningCaseDetails() {
        //commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(CaseOwner_Txt);
        commonmethods.staticWait(2000);
        String caseOwner = CaseOwner_Txt.getText();
        Assert.assertEquals(caseOwner, "Automation RS", "Case Owner should be Automation RS");
        String caseRecordType = CaseRecordType_Txt.getText();
        Assert.assertEquals(caseRecordType, "Late Club Opening", "Case Record Type should be Late Club Opening");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Status']//span[@class='slds-truncate'][normalize-space()='New']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Category']//span[@class='slds-truncate'][normalize-space()='Incident / Accident']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[@class='slds-truncate'][normalize-space()='Club']")).isDisplayed());
    }

    public void enterRequiredLateClubOpeningCaseTestData() {
        ClubInv_lkup.sendKeys(accounts_Page.getAccountName());
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubInv_option);
        commonmethods.staticWait(5000);
        ClubInv_option.click();
        Subject_txt.sendKeys("Test Automation Case");
        CaseOrigin_option.click();
        SelectCaseOrigin_drpdwn.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", Outcome_option);
        Outcome_option.click();
        SelectCaseOutcome_drpdwn.click();
        ClubOpenDate_cldr.click();
        String todayDate = today.format(formatter);
        WebElement todayElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + todayDate + "']"));
        todayElement.click();
        //select club opened at date
        Description_txt.sendKeys("Test Automation Description");
    }

    public void submitLateClubOpeningCase() {
      Save_btn.click();
    }

    public void verifyCaseSuccessToastMessage() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(5000);
        commonmethods.waitUntilWebElementIsVisible(CaseCreation_ToastMessage);
        Assert.assertTrue(CaseCreation_ToastMessage.getText().contains("was created"));
        //refresh the screen
    }

}
