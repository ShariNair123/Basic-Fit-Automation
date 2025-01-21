package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.commonMethods;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class clubActivity_Page {

    public clubActivity_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//span[@title='Incidents']")
    WebElement Incidents_link;
    private @FindBy(xpath = "//span[@title='MOD Tasks']")
    WebElement UnplannedUnstaffed_link;
    private @FindBy(xpath = "//span[@title='Investigations']")
    WebElement Investigations_link;
    private @FindBy(xpath = "//table[@aria-label=\"Incidents\"]/tbody/tr/th//a/span/slot/span")
    WebElement IncidentClubActivity_link;
    private @FindBy(xpath = "//table[@aria-label=\"MOD Tasks\"]/tbody/tr/th//a/span/slot/span")
    WebElement UnplannedUnstaffedClubActivity_link;
    private @FindBy(xpath = "//span[@title='Maintenance']")
    WebElement Maintenance_link;
    private @FindBy(xpath = "//table[@aria-label=\"Maintenance\"]/tbody/tr/th//a/span/slot/span")
    WebElement MaintenanceClubActivity_link;
    private @FindBy(xpath = "//table[@aria-label=\"Investigations\"]/tbody/tr/th//a/span/slot/span")
    WebElement InvestigationsClubActivity_link;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Status']//lightning-formatted-text[normalize-space()='Submitted']")
    WebElement IncidentStatusValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Status']//lightning-formatted-text[normalize-space()='Pending']")
    WebElement UUStatusValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Status']//lightning-formatted-text[normalize-space()='Submitted']")
    WebElement InvestigationStatusValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Owner']//slot[normalize-space()='RS Tech Club Activity']")
    WebElement IncidentOwnerValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Owner']//slot[normalize-space()='Marc queue']")
    WebElement UUOwnerValue_fld;
    //private @FindBy(xpath = "//span[@class='owner-name slds-grow']//span//slot//span//slot[contains(text(),'Automation Business Support')]")
    //WebElement MntnceOwnerValue_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Club Activity Name']//lightning-formatted-text")
    WebElement ClubActivityName_fld;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Club']//div[@class='slds-form-element__control']//div[@class='slds-grid']//span//slot//span//slot")
    WebElement ClubName_Txt;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Other Description']//lightning-formatted-text[normalize-space()='Automation Text']")
    WebElement UUOtherDescr_txt;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Closure Date']//lightning-formatted-text")
    WebElement UUClosureDate_fld;

/*    private @FindBy(xpath = "//records-record-layout-item[@field-label='Approver']//slot[text()='Automation RM']")
    List<WebElement> Approver_lnk;*/
/*    private @FindBy(xpath = "//records-record-layout-item[@field-label='Regional Manager']//slot[text()='Automation RM']")
    List<WebElement> RM_lnk;*/

    List<WebElement> Approver_lnk = driverContext.Driver.findElements(By.xpath("//records-record-layout-item[@field-label='Approver']//slot[contains(text(), 'Automation RM')]"));
    List<WebElement> RM_lnk = driverContext.Driver.findElements(By.xpath("//records-record-layout-item[@field-label='Regional Manager']//slot[contains(text(), 'Automation RM')]"));

    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Medical']")
    WebElement IncCtgry_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='2']")
    WebElement Impctscre_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Automation Employee CM']")
    WebElement Empname_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Test Incident description']")
    WebElement Incdescr_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Test Other description']")
    WebElement Othrdescr_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Member']")
    WebElement Involved_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Member Involved']")
    WebElement Invlvddescr_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Cardio zone;Spinning room']")
    WebElement Location_txt;
    private @FindBy(xpath = "//lightning-formatted-text[normalize-space()='Test Location']")
    WebElement Lctndescr_txt;
    private @FindBy(xpath = "//div[@class='recordTypeName slds-grow slds-truncate']//span[text()='Investigation']")
    List<WebElement> RecordType_txt;
    private @FindBy(xpath = "//records-record-layout-item[@field-label='Status']//lightning-formatted-text[normalize-space()='Pending']")
    WebElement MntnceStatusValue_fld;
    private @FindBy(xpath = "//input[@name='Partial_Reopening_Required__c']")
    WebElement PartialReopening_chkbox;
    private @FindBy(xpath = "//span[normalize-space()='Club Reporting Start Date']")
    WebElement ClubRprtng_link;
    private @FindBy(xpath = "//records-formula-output[@data-output-element-id='output-field']//lightning-formatted-text[contains(text(),'Maintenance')]")
    List<WebElement> MntnceRecordType_txt;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Partial_Reopening_End_Date__c']//lightning-formatted-text[@data-output-element-id='output-field']")
    WebElement PartialRopngEndDate_text;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Club_Rebuild_Start_Date_change__c']//lightning-formatted-text[@data-output-element-id='output-field']")
    WebElement RebuildStartDate_text;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Club_Rebuild_End_Date_change__c']//lightning-formatted-text[@data-output-element-id='output-field']")
    WebElement RebuildEndDate_text;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Reopening_Date__c']//lightning-formatted-text[@data-output-element-id='output-field']")
    WebElement ReopeningDate_text;
    private @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Partial_Reopening_End_Date__c']//lightning-formatted-text[@data-output-element-id='output-field']")
    WebElement PartialReopeningDate_text;
    List<WebElement> MntnceOwnerValue_fld = driverContext.Driver.findElements(By.xpath("//records-record-layout-item[@field-label='Owner']//slot[contains(text(), 'Automation Business Support')]"));



    LocalDate tomorrow = LocalDate.now().plusDays(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String expectedDateTomorrow = tomorrow.format(formatter);
    LocalDate today = LocalDate.now();
    String expectedDateToday = today.format(formatter);
    LocalDate twoDaysBack = LocalDate.now().minusDays(2);
    String twoDayBack = twoDaysBack.format(formatter);
    LocalDate oneDayBack = LocalDate.now().minusDays(1);
    String aDayBack = oneDayBack.format(formatter);
    LocalDate twoDaysAfter = LocalDate.now().plusDays(2);
    String twoDayAfter = twoDaysAfter.format(formatter);
    LocalDate threeDaysAfter = LocalDate.now().plusDays(3);
    String threeDayAfter = threeDaysAfter.format(formatter);

    public void selectIncidentCARecord() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(Incidents_link);
        Incidents_link.click();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(IncidentClubActivity_link);
        IncidentClubActivity_link.click();
    }

    public void verifyIncidentCAGenericDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);//span[@class='owner-name slds-grow']//span//slot//span//slot[contains(text(),'Automation Business Support')]
        String StatusText = IncidentStatusValue_fld.getText();
        Assert.assertEquals(StatusText, "Submitted", "Status is not Submitted!");
        String IncidentOwnerText = IncidentOwnerValue_fld.getText();
        Assert.assertEquals(IncidentOwnerText, "RS Tech Club Activity", "Owner is not correctly assigned");
        String clubActivityNameText = ClubActivityName_fld.getText();
        Assert.assertFalse(clubActivityNameText.isEmpty(), "Club Activity Name should not be empty");
        String clubNameValue = ClubName_Txt.getText();
        Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue, "Club Name should be same");
        WebElement closureDateElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Closure_Date__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String closureDateText = closureDateElement.getText();
        String closureDateOnly = closureDateText.split(" ")[0];
        LocalDate ClosureDate = LocalDate.parse(closureDateOnly, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedClosureDateOnly = ClosureDate.format(formatter);
        Assert.assertEquals(reformattedClosureDateOnly, expectedDateToday, "Closure Date should be today's date");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Club damage']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Water leakage']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Automation Test']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[normalize-space()='Incident']")).isDisplayed());
    }

    public void verifyIncidentCASpecificDetailsUnknown() {
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Unknown']")).isDisplayed());
        WebElement reopeningDateElement = driverContext.Driver.findElement(By.xpath("//records-record-layout-item[@field-label='Reopening Date']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String reopeningDateText = reopeningDateElement.getText();
        Assert.assertTrue(reopeningDateText.isEmpty(), "The Reopening Date field is not empty");

        WebElement reopeningTimeElement = driverContext.Driver.findElement(By.xpath("//records-record-layout-item[@field-label='Reopening Time']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String reopeningTimeText = reopeningTimeElement.getText();
        Assert.assertTrue(reopeningTimeText.isEmpty(), "The Reopening Time field is not empty");
    }

    public void verifyIncidentCASpecificDetailsKnown() {
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Known']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='08:00']")).isDisplayed());
        WebElement reopeningDateElement = driverContext.Driver.findElement(By.xpath("//records-record-layout-item[@field-label='Reopening Date']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String reopeningDateText = reopeningDateElement.getText();
        LocalDate reopeningDate = LocalDate.parse(reopeningDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedReopeningDate = reopeningDate.format(formatter);
        Assert.assertEquals(reformattedReopeningDate, expectedDateTomorrow, "Reopening Date should be tomorrow's date");
    }

    public void selectUnplannedUnstaffedCARecord() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(UnplannedUnstaffed_link);
        UnplannedUnstaffed_link.click();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(UnplannedUnstaffedClubActivity_link);
        UnplannedUnstaffedClubActivity_link.click();
    }

    public void verifyUnplannedUnStaffedCADetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        String clubActivityNameText = ClubActivityName_fld.getText();
        Assert.assertFalse(clubActivityNameText.isEmpty(), "Club Activity Name should not be empty");
        String clubNameValue = ClubName_Txt.getText();
        Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue, "Club Name should be same");
        String StatusText = UUStatusValue_fld.getText();
        Assert.assertEquals(StatusText, "Pending", "Status is not Pending!");
        //String UUOwnerText = UUOwnerValue_fld.getText();
        //Assert.assertEquals(UUOwnerText, "Marc queue", "Owner is not correctly assigned");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Unplanned Unstaffed']")).isDisplayed());
        String OtherDescr = UUOtherDescr_txt.getText();
        Assert.assertEquals(OtherDescr, "Automation Text", "Other Description field is not populated correctly");
        String closureDateText = UUClosureDate_fld.getText();
        Assert.assertTrue(closureDateText.isEmpty(), "Closure Date should be empty");

        //req start date
        WebElement UUReqStartDatenTimeElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Request_Start_Date_Time__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String uuReqStartDatenTimeText = UUReqStartDatenTimeElement.getText();
        String uuReqStartDateOnly = uuReqStartDatenTimeText.split(" ")[0];
        LocalDate uuReqStartDate = LocalDate.parse(uuReqStartDateOnly, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedStartDateOnly = uuReqStartDate.format(formatter);
        Assert.assertEquals(reformattedStartDateOnly, expectedDateToday, "UU Request Start Date should be today's date");

        //req end date
        WebElement UUReqEndDatenTimeElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Request_End_Date_Time__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String uuReqEndDatenTimeText = UUReqEndDatenTimeElement.getText();
        String uuReqEndDateOnly = uuReqEndDatenTimeText.split(" ")[0];
        LocalDate uuReqEndDate = LocalDate.parse(uuReqEndDateOnly, DateTimeFormatter.ofPattern("d-M-yyyy"));
        String reformattedEndDateOnly = uuReqEndDate.format(formatter);
        Assert.assertEquals(reformattedEndDateOnly, expectedDateTomorrow, "UU Request End Date should be tomorrow's date");
    }

    public void selectInvestigationCARecord() {
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(Investigations_link);
        commonmethods.staticWait(2000);
        Investigations_link.click();
        commonmethods.staticWait(2000);
        commonmethods.waitUntilWebElementIsVisible(InvestigationsClubActivity_link);
        InvestigationsClubActivity_link.click();
    }

    public void verifyInvestigationCADetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        //((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", ClubActivityName_fld);
        String clubActivityNameText = ClubActivityName_fld.getText();
        Assert.assertFalse(clubActivityNameText.isEmpty(), "Club Activity Name should not be empty");
        String clubNameValue = ClubName_Txt.getText();
        Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue, "Club Name should be same");

        String IncCtgry = IncCtgry_txt.getText();
        Assert.assertEquals(IncCtgry, "Medical", "Incident Category field is not populated correctly");
        String Impctscre = Impctscre_txt.getText();
        Assert.assertEquals(Impctscre, "2", "Impact Score field is not populated correctly");

        WebElement startDateElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.Start_Date_Time__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String startDateText = startDateElement.getText();
        String startDateOnly = startDateText.split(" ")[0];
        LocalDate parsedStartDate = LocalDate.parse(startDateOnly, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedStartDateOnly = parsedStartDate.format(formatter);
        Assert.assertEquals(reformattedStartDateOnly, twoDayBack, "Start date should be two days back");
        //Assert.assertEquals(startDateOnly, twoDayBack, "Start date should be two days back");

        WebElement endDateElement = driverContext.Driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Club_Activity__c.End_Date_Time__c']//lightning-formatted-text[@data-output-element-id='output-field']"));
        String endDateText = endDateElement.getText();
        String endDateOnly = endDateText.split(" ")[0];
        LocalDate parsedEndDate = LocalDate.parse(endDateOnly, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedEndDateOnly = parsedEndDate.format(formatter);
        Assert.assertEquals(reformattedEndDateOnly, expectedDateToday, "End date should be today");
        //Assert.assertEquals(endDateOnly, aDayBack, "End date should be one day back");

        String Empname = Empname_txt.getText();
        Assert.assertEquals(Empname, "Automation Employee CM", "Name of the employee is not correct");
        String Incdescr = Incdescr_txt.getText();
        Assert.assertEquals(Incdescr, "Test Incident description", "Incident description is not correct");
        String Othrdescr = Othrdescr_txt.getText();
        Assert.assertEquals(Othrdescr, "Test Other description", "Incident description is not correct");
        String Involved = Involved_txt.getText();
        Assert.assertEquals(Involved, "Member", "Involved field value is not correct");
        String Invlvddescr = Invlvddescr_txt.getText();
        Assert.assertEquals(Invlvddescr, "Member Involved", "Involved description field value is not correct");
        String Location = Location_txt.getText();
        Assert.assertEquals(Location, "Cardio zone;Spinning room", "Location field value is not correct");
        String Lctndescr = Lctndescr_txt.getText();
        Assert.assertEquals(Lctndescr, "Test Location", "Location description field value is not correct");
        String RecordType = RecordType_txt.get(0).getText();
        Assert.assertEquals(RecordType, "Investigation", "Record Type is not Investigation");
        String StatusText = InvestigationStatusValue_fld.getText();
        Assert.assertEquals(StatusText, "Submitted", "Status is not Submitted!");

        //Assert.assertEquals(RM_lnk.size(), 2);
        //Assert.assertEquals(Approver_lnk.size(), 2);
        //Assert.assertEquals(RMValue, ApproverValue, "Approver should be same as Regional Manager");
    }

    public void selectCATempClubClosure() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(5000);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", ClubRprtng_link);
        commonmethods.staticWait(5000);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", Maintenance_link);
        commonmethods.staticWait(2000);
        commonmethods.waitUntilWebElementIsVisible(MaintenanceClubActivity_link);
        MaintenanceClubActivity_link.click();
    }

    public void verifyCATempClubClosureGenericDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        String clubActivityNameText = ClubActivityName_fld.getText();
        Assert.assertFalse(clubActivityNameText.isEmpty(), "Club Activity Name should not be empty");
        //String clubNameValue = ClubName_Txt.getText();
        //Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue,  "Club Name should be same");
        String StatusText = MntnceStatusValue_fld.getText();
        Assert.assertEquals(StatusText, "Pending", "Status is not Pending!");
        //String MntnceOwnerText = MntnceOwnerValue_fld.getText();
        //Assert.assertEquals(MntnceOwnerText, "Automation Business Support", "Owner is not correctly assigned");
        //Assert.assertEquals(MntnceOwnerValue_fld.size(), 0);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Known']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='08:00']")).isDisplayed());
        String MntnceRecordType = MntnceRecordType_txt.get(0).getText();
        Assert.assertEquals(MntnceRecordType, "Maintenance", "Record Type is not Maintenance");


        String rebuildStartDateText = RebuildStartDate_text.getText();
        LocalDate parsedRebuildStartDate = LocalDate.parse(rebuildStartDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedRebuildStartDate = parsedRebuildStartDate.format(formatter);
        Assert.assertEquals(reformattedRebuildStartDate, expectedDateToday, "Rebuild Start Date should be today");

        String rebuildEndDateText = RebuildEndDate_text.getText();
        LocalDate parsedRebuildEndDate = LocalDate.parse(rebuildEndDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedRebuildEndDate = parsedRebuildEndDate.format(formatter);
        Assert.assertEquals(reformattedRebuildEndDate, expectedDateTomorrow, "Rebuild End Date should be tomorrow");

        String reopeningDateText = ReopeningDate_text.getText();
        LocalDate parsedReopeningDate = LocalDate.parse(reopeningDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedReopeningDate = parsedReopeningDate.format(formatter);
        Assert.assertEquals(reformattedReopeningDate, twoDayAfter, "Reopening date should be two days after");
    }

    public void verifyCATempClubClosureSpecificDetailsWithoutPartialReopening() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        Assert.assertFalse(PartialReopening_chkbox.isSelected(), "The Partial Reopening checkbox should be unselected.");
        String PartialRopngEndDateText = PartialRopngEndDate_text.getText();
        Assert.assertTrue(PartialRopngEndDateText.isEmpty(), "The 'Partial Reopening End Date' field is not empty.");
    }

    public void verifyCATempClubClosureSpecificDetailsForPartialReopening() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(4000);
        Assert.assertTrue(PartialReopening_chkbox.isSelected(), "The Partial Reopening checkbox should be selected.");
        String partialReopeningDateText = PartialReopeningDate_text.getText();
        LocalDate parsedPartialReopeningDate = LocalDate.parse(partialReopeningDateText, DateTimeFormatter.ofPattern("d-M-yyyy")); // Parse with single 'd' and 'M'
        String reformattedPartialReopeningDate = parsedPartialReopeningDate.format(formatter);
        Assert.assertEquals(reformattedPartialReopeningDate, threeDayAfter, "Reopening date should be three days after");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Type 1']")).isDisplayed());
    }
}