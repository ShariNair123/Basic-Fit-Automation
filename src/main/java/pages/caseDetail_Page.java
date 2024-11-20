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
    WebElement ClubInv_Txt;


    public void verifyLateClubOpeningCaseDetails() {
        driverContext.Driver.navigate().refresh();
        commonmethods.waitForLoad();
        commonmethods.staticWait(2000);
        String clubInvValue = ClubInv_Txt.getText();
        commonmethods.staticWait(2000);
        Assert.assertEquals(accounts_Page.getAccountName(), clubInvValue, "Club Name should be same");
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Test Automation Case']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='MOD']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[normalize-space()='Confirmed [Guard Requested]']")).isDisplayed());
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field'][normalize-space()='Medium']")).isDisplayed());
    }
}
