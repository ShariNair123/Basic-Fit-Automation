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

public class caseDetail_Page {

    public caseDetail_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//records-record-layout-item[@field-label='Club Involved']//div[@class='slds-grid']//span//slot//span//slot")
    WebElement ClubInvLateClubOpening_Txt;
    private @FindBy(xpath = "//span[@class='slds-truncate slds-m-right--xx-small'][normalize-space()='Cases']")
    WebElement Cases_link;
    private @FindBy(xpath = "//table[@aria-label=\"Cases\"]/tbody/tr/th//a/span/slot/span")
    WebElement CasesCA_link;
    private @FindBy(xpath = "//a//span//slot[contains(text(),'Test Automation')]")
    WebElement ClubInvMOD_Txt;
    private @FindBy(xpath = "//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Open']")
    WebElement CaseStatusMOD_Txt;
    private @FindBy(xpath = "//lightning-formatted-text[@data-output-element-id='output-field'][contains(text(),'Test Automation')]")
    WebElement Subject_fld;




    public void verifyLateClubOpeningCaseDetails() {
        driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        String clubInvLateClubOpeningValue = ClubInvLateClubOpening_Txt.getText();
        commonmethods.staticWait(2000);
        Assert.assertEquals(accounts_Page.getAccountName(), clubInvLateClubOpeningValue, "Club Name should be same");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Test Automation Case']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='MOD']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Confirmed [Guard Requested]']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Medium']")).isDisplayed());
    }

    public void selectMODCaseDetails() {
        //driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", Cases_link);
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(CasesCA_link);
        CasesCA_link.click();
    }

    public void verifyMODCaseDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        String clubInvMODValue = ClubInvMOD_Txt.getText();
        Assert.assertEquals(accounts_Page.getAccountName(), clubInvMODValue, "Club Name should be same");
        String caseStatusMOD = CaseStatusMOD_Txt.getText();
        Assert.assertEquals(caseStatusMOD, "Open", "Case Status should be Open");
        String actualSubjectText = Subject_fld.getText();
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String clubName = accounts_Page.getAccountName();
        String expectedSubjectText = todayDate + " - Incident / Accident report - " + clubName;
       Assert.assertEquals(actualSubjectText, expectedSubjectText, "Subject field text does not match the expected format.");
    }

    public void verifyIncidentAccidentCaseDetails() {

        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='New']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Medium']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Prio 1 - Fire']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='SCS']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[normalize-space()='Incident / Accident']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Test Automation Subject']")).isDisplayed());
    }

}
