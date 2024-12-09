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

public class caseCreation_Page {

    public caseCreation_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//span[normalize-space()='Cases']")
    WebElement Cases_title;
    private @FindBy(xpath = "//span[@class='slds-truncate'][normalize-space()='Cases']")
    WebElement CMAppCases_title;
    private @FindBy(xpath = "//div[@title='New']")
    WebElement NewCase_Btn;
    private @FindBy(xpath = "//span[normalize-space()='Agent HC Belgium (Dutch)']")
    WebElement AgentDutch_lbl;
    private @FindBy(xpath = "//label[.//span[text()='Late Club Opening']]//span[@class='slds-radio--faux']")
    WebElement LateClubOpening_RdoBtn;
    private @FindBy(xpath = "//span[normalize-space()='Incident / Accident']/ancestor::label//input[@type='radio']")
    WebElement IncidentAccident_RdoBtn;
    private @FindBy(xpath = "//span[normalize-space()='MOD']/ancestor::label//input[@type='radio']")
    WebElement MOD_RdoBtn;
    private @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement Next_Btn;
    private @FindBy(xpath = "//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly recordlayout_in_editing_mode is-stacked']//slot[contains(text(),'Automation RS')]")
    WebElement CaseOwnerlteclbopng_Txt;
    private @FindBy(xpath = "//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_stacked']//slot[contains(text(),'Automation MOD')]")
    WebElement CaseOwnerMOD_Txt;
    private @FindBy(xpath = "//div[@class='slds-form-element__control']//slot[contains(text(),'Automation MARC')]")
    WebElement CaseOwnerIncAcc_Txt;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.RecordTypeId']//span[contains(text(),'Late Club Opening')]")
    WebElement CaseRecordTypelteclbopng_Txt;
    private @FindBy(xpath = "//div[@class='recordTypeName slds-grow slds-truncate']//span[contains(text(),'MOD')]")
    WebElement CaseRecordTypeMOD_Txt;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Club_Involved__c']//div//input[@placeholder='Search Accounts...']")
    WebElement ClubInv_lkup;
    private @FindBy(xpath = "//li[@role='presentation']//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']")
    WebElement ClubInv_option;
    private @FindBy(xpath = "//input[@name='Web_Form_Club_Cost_Center__c']")
    WebElement CostCenter_txt;
    private @FindBy(xpath = "//input[@name='Subject']")
    WebElement Subject_txt;
    private @FindBy(xpath = "//input[@name='Summary__c']")
    WebElement Summary_txt;
    private @FindBy(xpath = "//button[@aria-label='Case Origin']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement CaseOrigin_option;
    private @FindBy(xpath = "//lightning-base-combobox-item[@data-value='MOD']")
    WebElement SelectCaseOrigin_drpdwn;
    private @FindBy(xpath = "//button[@aria-label='Incident category']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement IncidentCtgry_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Incident category']//lightning-base-combobox-item[@data-value='Medical']")
    WebElement IncidentCtgry_option;
    private @FindBy(xpath = "//button[@aria-label='Incident sub-category' and @data-value='--None--']")
    WebElement IncidentSubCtgry_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Incident sub-category']//lightning-base-combobox-item[@data-value='Injury']")
    WebElement IncidentSubCtgry_option;
    private @FindBy(xpath = "//button[@aria-label='Impact score']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement ImpactScore_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Impact score']//lightning-base-combobox-item[@data-value=\"2\"]")
    WebElement ImpactScore_option;
    private @FindBy(xpath = "//textarea[@class='slds-textarea']")
    WebElement MODDesc_txt;
    private @FindBy(xpath = "//button[@aria-label='Investigation outcome category']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement InvstgtnOutcome_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Investigation outcome category']//lightning-base-combobox-item[@data-value='Theft']")
    WebElement InvstgtnOutcome_option;
    private @FindBy(xpath = "//button[@aria-label='Investigation outcome sub-category']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement InvstgtnOutcomeSubCtgry_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Investigation outcome sub-category']//lightning-base-combobox-item[@data-value='Staff belongings']")
    WebElement InvstgtnOutcomeSubCtgry_option;
    private @FindBy(xpath = "//button[@aria-label='Outcome']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement Outcome_option;
    private @FindBy(xpath = "//div[@aria-label='Outcome']//lightning-base-combobox-item[@data-value='Confirmed [Guard Requested]']")
    WebElement SelectCaseOutcome_drpdwn;
    private @FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='Club_opened_at__c']")
    WebElement ClubOpenDate_cldr;
    private @FindBy(xpath = "//textarea[@class='slds-textarea']")
    WebElement Description_txt;
    private @FindBy(xpath = "//div[normalize-space()='People involved']")
    WebElement PeopleInvolved_lbl;
    private @FindBy(xpath = "//span[@title='Member']")
    WebElement Member_optn;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.People_involved__c']//button[@title='Move to Chosen']")
    WebElement PplInvChosen_btn;
    private @FindBy(xpath = "//div[normalize-space()='Emergency services involved']")
    WebElement EmrgncySrvcs_lbl;
    private @FindBy(xpath = "//span[@title='Police']")
    WebElement Police_optn;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Emergency_services_involved__c']//button[@title='Move to Chosen']")
    WebElement EmSrChosen_btn;




    private @FindBy(xpath = "//button[@aria-label='Technical Outcome']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement TechnicalOutcome_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Technical Outcome']//lightning-base-combobox-item[@data-value='False alarm']")
    WebElement TechnicalOutcome_option;
    private @FindBy(xpath = "//button[@aria-label='Technical component affected']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement TechnicalCmpnt_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Technical component affected']//lightning-base-combobox-item[@data-value='Fire system']")
    WebElement TechnicalCmpnt_option;
    private @FindBy(xpath = "//button[@aria-label='Technical outcome description']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement TchnclOtcmeDesc_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Technical outcome description']//lightning-base-combobox-item[@data-value='External fire system']")
    WebElement TchnclOtcmeDesc_option;
    private @FindBy(xpath = "//button[@aria-label='Responsible department']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement RspnsbleDept_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Responsible department']//lightning-base-combobox-item[@data-value=\"IT\"]")
    WebElement RspnsbleDept_option;
    private @FindBy(xpath = "//button[@aria-label='Restored by itself?']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement Restored_drpdwn;
    private @FindBy(xpath = "//div[@aria-label='Restored by itself?']//span//span[normalize-space()=\"Yes\"]")
    WebElement Restored_option;
    private @FindBy(xpath = "//div[@aria-label='RS Report']//div[@class='slds-rich-text-area__content slds-grow slds-text-color-weak standin']")
    WebElement RSReport_fld;
    private @FindBy(xpath = "//div[@aria-label='RS Report']//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-grow slds-text-color_weak']")
    WebElement RSReport_txt;
    private @FindBy(xpath = "//div[@aria-label='RS Technical Report']//div[@class='slds-rich-text-area__content slds-grow slds-text-color-weak standin']")
    WebElement RSTechReport_fld;
    private @FindBy(xpath = "//div[@aria-label='RS Technical Report']//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-grow slds-text-color_weak']")
    WebElement RSTechReport_txt;
    private @FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='Date_and_time_of_the_incident__c']")
    WebElement IncDate_fld;
    private @FindBy(xpath = "//input[@class='slds-combobox__input slds-input slds-combobox__input-value']")
    WebElement IncTime_fld_drpdwn;
    private @FindBy(xpath = "//button[@aria-label='MARC Priority']//span[@class='slds-truncate'][normalize-space()='--None--']")
    WebElement MARCPriority_drpdwn;
    private @FindBy(xpath = "//lightning-base-combobox-item[@data-value='Prio 1 - Fire']")
    WebElement MARCPriority_optn;
    private @FindBy(xpath = "//button[@aria-label='Reported through']")
    WebElement RprtdThru_drpdwn;
    private @FindBy(xpath = "//lightning-base-combobox-item[@data-value='SCS']")
    WebElement RprtdThru_optn;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Further_Details__c']//textarea[@class='slds-textarea']")
    WebElement MARCDesc_txt;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Description']//textarea[@class='slds-textarea']")
    WebElement IncAccDesc_txt;




    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String formattedDateToday = today.format(formatter);
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");



    private @FindBy(xpath = "//button[@name='SaveEdit']")
    WebElement Save_btn;
    private @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    WebElement CaseCreation_ToastMessage;


    public void goToCasesPage() {
        //commonmethods.staticWait(2000);
        commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(Cases_title);
        commonmethods.staticWait(3000);
        commonmethods.clickByJS(Cases_title);
        //Cases_title.click();
    }

    public void goToCMAppCasesPage() {
        //commonmethods.staticWait(2000);
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        try {
            WebElement popupMessage = (driverContext.Driver.findElement(By.xpath("//span[normalize-space()='Continue logging into Omni-Channel?']")));
            if (popupMessage.isDisplayed()) {
                WebElement cancelButton = (driverContext.Driver.findElement(By.xpath("//button[normalize-space()='Cancel']")));
                cancelButton.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Popup not displayed, proceeding without action.");
        }
        commonmethods.staticWait(3000);
        commonmethods.clickByJS(CMAppCases_title);
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

    public void verifyRecordTypeMOD() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        //commonmethods.waitUntilWebElementIsVisible(LateClubOpening_RdoBtn);
        Assert.assertTrue(MOD_RdoBtn.isSelected(), "The MOD radio button should be selected.");
        Next_Btn.click();
    }

    public void verifyRecordTypeIncidentAccident() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        //commonmethods.waitUntilWebElementIsVisible(LateClubOpening_RdoBtn);
        Assert.assertTrue(IncidentAccident_RdoBtn.isSelected(), "The Incident Accident radio button should be selected.");
        Next_Btn.click();
    }

    public void verifyAutoPopulatedLateClubOpeningCaseDetails() {
        //commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(CaseOwner_Txt);
        commonmethods.staticWait(4000);
        String caseOwnerLateClubOpening = CaseOwnerlteclbopng_Txt.getText();
        Assert.assertEquals(caseOwnerLateClubOpening, "Automation RS", "Case Owner should be Automation RS");
        String caseRecordTypeLateClubOpening = CaseRecordTypelteclbopng_Txt.getText();
        Assert.assertEquals(caseRecordTypeLateClubOpening, "Late Club Opening", "Case Record Type should be Late Club Opening");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Status']//span[@class='slds-truncate'][normalize-space()='New']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Category']//span[@class='slds-truncate'][normalize-space()='Incident / Accident']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[@class='slds-truncate'][normalize-space()='Club']")).isDisplayed());
    }

    public void verifyAutoPopulatedMODCaseDetails() {
        //commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(CaseOwner_Txt);
        commonmethods.staticWait(5000);
        String caseOwnerMOD = CaseOwnerMOD_Txt.getText();
        Assert.assertEquals(caseOwnerMOD, "Automation MOD", "Case Owner should be Automation MOD");
        String caseRecordTypeMOD = CaseRecordTypeMOD_Txt.getText();
        Assert.assertEquals(caseRecordTypeMOD, "MOD", "Case Record Type should be MOD");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Status']//span[@class='slds-truncate'][normalize-space()='New']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//force-record-output-picklist[normalize-space()='Medium']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//force-record-output-picklist[normalize-space()='RS Club Incidents / Accidents']")).isDisplayed());
    }

    public void verifyAutoPopulatedIncidentAccidentCaseDetails() {
        //commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(CaseOwner_Txt);
        commonmethods.staticWait(3000);
        String caseOwnerIncAcc = CaseOwnerIncAcc_Txt.getText();
        Assert.assertEquals(caseOwnerIncAcc, "Automation MARC", "Case Owner should be Automation MARC");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//button[@aria-label='Status']//span[@class='slds-truncate'][normalize-space()='New']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//force-record-output-picklist[normalize-space()='Medium']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//div[@class='recordTypeName slds-grow slds-truncate']//span[contains(text(),'Incident / Accident')]")).isDisplayed());
    }

    public void enterRequiredLateClubOpeningCaseTestData() {
        ClubInv_lkup.sendKeys(accounts_Page.getAccountName());
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(ClubInv_option);
        commonmethods.staticWait(5000);
        ClubInv_option.click();
        Subject_txt.sendKeys("Test Automation Case");
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", CaseOrigin_option);
        //CaseOrigin_option.click();
        commonmethods.staticWait(2000);
        SelectCaseOrigin_drpdwn.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", Outcome_option);
        Outcome_option.click();
        SelectCaseOutcome_drpdwn.click();
        //ClubOpenDate_cldr.click();
        //String todayDate = today.format(formatter);
        //WebElement todayElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + todayDate + "']"));
        //todayElement.click();
        //select club opened at date
        Description_txt.sendKeys("Test Automation Description");
    }

    public void enterRequiredMODCaseTestData() {
        //ClubInv_lkup.sendKeys(accounts_Page.getAccountName());
        CostCenter_txt.sendKeys(accounts_Page.getCostCenter());
        commonmethods.waitForLoad();
        //commonmethods.waitUntilWebElementIsVisible(ClubInv_option);
        //commonmethods.staticWait(5000);
        //ClubInv_option.click();
        Summary_txt.sendKeys("Test Summary");
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", IncidentCtgry_drpdwn);
        commonmethods.staticWait(1000);
        IncidentCtgry_option.click();
        IncidentSubCtgry_drpdwn.click();
        IncidentSubCtgry_option.click();
        ImpactScore_drpdwn.click();
        ImpactScore_option.click();
        MODDesc_txt.sendKeys("MOD Description Text");
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", InvstgtnOutcome_drpdwn);
        InvstgtnOutcome_option.click();
        InvstgtnOutcomeSubCtgry_drpdwn.click();
        InvstgtnOutcomeSubCtgry_option.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", PeopleInvolved_lbl);
        Member_optn.click();
        PplInvChosen_btn.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", EmrgncySrvcs_lbl);
        Police_optn.click();
        EmSrChosen_btn.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", RSReport_fld);
        RSReport_fld.click();
        //RSReport_txt.sendKeys("RS Report Automation");
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].innerText = 'RS Report Automation';", RSReport_txt);
        commonmethods.staticWait(2000);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", TechnicalOutcome_drpdwn);
        TechnicalOutcome_option.click();
        TechnicalCmpnt_drpdwn.click();
        TechnicalCmpnt_option.click();
        TchnclOtcmeDesc_drpdwn.click();
        TchnclOtcmeDesc_option.click();
        RspnsbleDept_drpdwn.click();
        RspnsbleDept_option.click();
        Restored_drpdwn.click();
        Restored_option.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", RSTechReport_fld);
        RSTechReport_fld.click();
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].innerText = 'RS Tech Report Automation';", RSTechReport_txt);
    }

    public void enterRequiredIncidentAccidentCaseTestData() {
        //ClubInv_lkup.sendKeys(accounts_Page.getAccountName());
        CostCenter_txt.sendKeys(accounts_Page.getCostCenter());
        commonmethods.waitForLoad();
        Subject_txt.sendKeys("Test Automation Subject");
        IncDate_fld.click();
        IncDate_fld.clear();
        IncDate_fld.sendKeys(formattedDateToday);
        //IncTime_fld_drpdwn.click();
        //IncTime_fld_drpdwn.clear();
        //IncTime_fld_drpdwn.sendKeys("0:00");
        MARCPriority_drpdwn.click();
        MARCPriority_optn.click();
        RprtdThru_drpdwn.click();
        RprtdThru_optn.click();
    }

    public void submitCase() {
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
