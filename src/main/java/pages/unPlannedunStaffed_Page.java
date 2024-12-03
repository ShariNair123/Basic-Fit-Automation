package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class unPlannedunStaffed_Page {

    public unPlannedunStaffed_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//button[normalize-space()='Request To MARC']")
    WebElement RequestToMARC_Btn;
    private @FindBy(xpath = "//flowruntime-lwc-field//div[1]//label[contains(text(),'Name')]/following-sibling::div//input[@class='slds-input']")
    WebElement ClubName_Txt;
    private @FindBy(xpath = "//select[@name='Request_Type']")
    WebElement RequestType_Drpdwn;
    private @FindBy(xpath = "//option[@value='unplannedUnstaffedRequestTypeChoices.Unplanned Unstaffed']")
    WebElement RequestType_option;
    private @FindBy(xpath = "//flowruntime-lwc-field//div[1]//label[contains(text(),'Status')]/following-sibling::div//input[@class='slds-input']")
    WebElement RequestStatus_Drpdwn;
    private @FindBy(xpath = "//lightning-datepicker[@class='slds-form-element']//input[@name='Request_Start_Date_Time']")
    WebElement RequestStartDatenTime_fld;
    private @FindBy(xpath = "//lightning-datepicker[@class='slds-form-element']//input[@name='Request_End_Date_Time']")
    WebElement RequestEndDatenTime_fld;


    //DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM"); // For month
    //DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy"); // For year
    //DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");// For day
    //String todayMonth = today.format(monthFormatter);
    //String todayYear = today.format(yearFormatter);
    //String todayDay = today.format(dayFormatter);


    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String formattedDateToday = today.format(formatter);

    LocalDate tomorrow = LocalDate.now().plusDays(1);
    String formattedDateTomorrow = tomorrow.format(formatter);


    //LocalDate tomorrow = LocalDate.now().plusDays(1);
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");


    private @FindBy(xpath = "//input[@name='Other_Description']")
    WebElement OtherDescr_txt;
    private @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement Continue_Btn;
    private @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement Confirm_Btn;




    public void clickRequestToMARCButton() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(RequestToMARC_Btn);
        RequestToMARC_Btn.click();
        commonmethods.waitForLoad();
    }

    public void enterUnPlannedUnStaffedRequestDetails() {
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        String clubNameValue = ClubName_Txt.getAttribute("value");
        Assert.assertFalse(clubNameValue.isEmpty(), "Club Name field should not be empty");
        Assert.assertEquals(accounts_Page.getAccountName(), clubNameValue,  "Club Name should be same");
        commonmethods.waitUntilWebElementToBeClickable(RequestType_Drpdwn);
        RequestType_Drpdwn.click();
        commonmethods.waitForLoad();
        RequestType_option.click();
        String requestStatusValue = RequestStatus_Drpdwn.getAttribute("value");
        Assert.assertEquals(requestStatusValue , "Pending",  "Request Status should be Pending");
        RequestStartDatenTime_fld.click();
        RequestStartDatenTime_fld.clear();
        RequestStartDatenTime_fld.sendKeys(formattedDateToday);


        //String todayDateXPath = "//td[@role='gridcell' and @data-month='" + todayMonth + "' and @data-year='" + todayYear + "']//span[text()='" + todayDay + "']";
        //WebElement todayElement = driverContext.Driver.findElement(By.xpath(todayDateXPath));
        //todayElement.click();

        //String todayDate = today.format(formatter);
        //WebElement todayElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + todayDate + "']"));
        //todayElement.click();
        commonmethods.scrollIntoTheViewAndClick(RequestEndDatenTime_fld);
        RequestEndDatenTime_fld.click();
        RequestEndDatenTime_fld.clear();
        RequestEndDatenTime_fld.sendKeys(formattedDateTomorrow);


        //RequestEndDatenTime_clndr.click();
        //String tomorrowDate = tomorrow.format(formatter);
        //WebElement tomorrowElement = driverContext.Driver.findElement(By.xpath("//td[@role='gridcell']//span[text()='" + tomorrowDate + "']"));
        //tomorrowElement.click();
        OtherDescr_txt.sendKeys("Automation Text");
        Continue_Btn.click();
    }

    public void confirmRequestCreation() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//p[contains(text(),'Please confirm your intent to create an Unplanned ')]")).isDisplayed());
        Confirm_Btn.click();
    }

}
