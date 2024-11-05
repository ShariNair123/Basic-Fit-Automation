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

public class investigationRequest_Page {

    public investigationRequest_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//button[@type='button'][normalize-space()='Request Investigation']")
    WebElement InvestigationRequest_btn;
    private @FindBy(xpath = "//iframe[@title='accessibility title']")
    WebElement InvReqDetailsFrame;
    private @FindBy(xpath = "//div[@class='slds-form-element__control']//div[@part='input-text']//input[contains(@placeholder,'Automation RM')]")
    WebElement Approver_Txt;
    private @FindBy(xpath = "//input[@name='Name_of_the_employee_on_duty_job_title']")
    WebElement EmployeeName_Txt;
    private @FindBy(xpath = "//select[@name='Impact_score']")
    WebElement Impactscore_drpdwn;
    private @FindBy(xpath = "//select[@name='Impact_score']/option[@value='X2']")
    WebElement Impactscore_option;
    private @FindBy(xpath = "//select[@name='Incident_category']")
    WebElement IncCtgry_drpdwn;
    private @FindBy(xpath = "//select[@name='Incident_category']/option[@value='Medical']")
    WebElement IncCtgry_option;
    private @FindBy(xpath = "//div[@class='slds-form-element__control']//label[@id='CHECKBOX-LABEL-0-116']//span[@class='slds-checkbox_faux']")
    WebElement AllInv_chkbox;
    private @FindBy(xpath = "//input[@name='Involved_Description']")
    WebElement Invdescr_txt;
    private @FindBy(xpath = "//input[@name='Description_of_the_Incident']")
    WebElement Incdescr_txt;
    private @FindBy(xpath = "//span[text()='Cardio zone']/ancestor::label/preceding-sibling::input[@type='checkbox']")
    WebElement Cardio_chkbox;
    private @FindBy(xpath = "//span[text()='Spinning room']/ancestor::label/preceding-sibling::input[@type='checkbox']")
    WebElement Spinning_chkbox;
    private @FindBy(xpath = "//input[@name='Location_Description']")
    WebElement Locdescr_txt;
    private @FindBy(xpath = "//input[@name='Other_description']")
    WebElement Otherdescr_txt;
    private @FindBy(xpath = "//button[normalize-space()='Submit Investigation Request']")
    WebElement Submit_btn;
    private @FindBy(xpath = "//lightning-datepicker[@class='slds-form-element']//input[@name='Start_Date_Time']")
    WebElement StartDatenTime_clndr;
    private @FindBy(xpath = "//lightning-datepicker[@class='slds-form-element']//input[@name='End_Date_Time']")
    WebElement EndDatenTime_clndr;
    LocalDate today = LocalDate.now();
    LocalDate twoDaysBack = LocalDate.now().minusDays(2);
    LocalDate oneDayBack = LocalDate.now().minusDays(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");




    public void clickInvestigationRequestButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementToBeClickable(InvestigationRequest_btn);
        InvestigationRequest_btn.click();
        commonmethods.waitForLoad();
    }

    public void enterInvestigationRequestDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        commonmethods.waitUntilWebElementIsVisible(InvReqDetailsFrame);
        driverContext.Driver.switchTo().frame(InvReqDetailsFrame);

        commonmethods.staticWait(2000);
        String approverValue = Approver_Txt.getAttribute("value");
        Assert.assertEquals(approverValue, "Automation RM", "Approver should be Automation RM");

        //write an assertion to verify that the same Club RM is populated as Approver
        EmployeeName_Txt.click();
        EmployeeName_Txt.sendKeys("Automation Employee CM");
        Impactscore_drpdwn.click();
        Impactscore_option.click();
        IncCtgry_drpdwn.click();
        IncCtgry_option.click();

        StartDatenTime_clndr.click();
        String startDate = twoDaysBack.format(formatter);
        WebElement startDateElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + startDate + "']"));
        startDateElement.click();
        commonmethods.scrollIntoTheViewAndClick(EndDatenTime_clndr);

        //String endDate = oneDayBack.format(formatter);
        //WebElement endDateElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + endDate + "']"));
        //endDateElement.click();


        String endDate = today.format(formatter);
        WebElement endDateElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + endDate + "']"));
        endDateElement.click();


        AllInv_chkbox.click();
        Invdescr_txt.sendKeys("Member Involved");
        Incdescr_txt.sendKeys("Test Incident description");
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].click();", Cardio_chkbox);
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].click();", Spinning_chkbox);
        Locdescr_txt.sendKeys("Test Location");
        Otherdescr_txt.sendKeys("Test Other description");
    }

    public void submitInvestigationRequestDetails() {
        Submit_btn.click();
    }

}


