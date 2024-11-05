package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;
import utilities.constant;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//button[@aria-label='Search']/parent::div")
    WebElement Search_Item_Fld;
    private @FindBy(xpath = "//a[@href='/secur/logout.jsp']")
    WebElement logout_Label;
    private @FindBy(xpath = "//input[contains(@placeholder,'Search')]/ancestor::lightning-input/descendant::input")
    WebElement extendedSearch_Field;
    private @FindBy(xpath = "//button[contains(@title,'Close Basic-Fit ')]")
    List<WebElement> close_Btns;






    commonMethods commonmethods=new commonMethods();
    accounts_Page ap=new accounts_Page();
    public void verifyHomePageTitle()
    {
        commonmethods.verifyPageTitle(constant.HOME_PAGE_TITLE);
    }

    public void SearchForItem() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        //adding the below 1 line temporary for testing
        //accounts_Page.setAccountName("Basic-Fit Lyon3000 Test Automation");
        commonmethods.staticWait(8000);
        for(WebElement ele: close_Btns)
        {
            commonmethods.clickByJS(ele);
            commonmethods.staticWait(2000);
        }
        //driverContext.Driver.navigate().refresh();
        //commonmethods.staticWait(10000);
        commonmethods.waitForLoad();
        //driverContext.Driver.navigate().refresh();
        //commonmethods.staticWait(10000);
        commonmethods.waitUntilWebElementIsVisible(Search_Item_Fld);
        Search_Item_Fld.click();
        //Search_Item_Fld.sendKeys(accounts_Page.getAccountName());
        commonmethods.waitUntilWebElementIsVisible(extendedSearch_Field);
        extendedSearch_Field.sendKeys(accounts_Page.getAccountName());
        commonmethods.staticWait(5000);
        int size = driverContext.Driver.findElements(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).size();
        for (int i=1; size<1; i++)
        {
            commonmethods.staticWait(8000);
            extendedSearch_Field.clear();
            extendedSearch_Field.sendKeys(accounts_Page.getAccountName());
            commonmethods.staticWait(8000);
            //driverContext.Driver.findElement(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).click();
            size = driverContext.Driver.findElements(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).size();
        }
        //else
            driverContext.Driver.findElement(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).click();
        //System.out.println();

    }


    public void performLogout() {
        //commonmethods.waitUntilWebElementToBeClickable(logout_Label);
        //logout_Label.click();
        //System.out.println();
        driverContext.Driver.navigate().refresh();
        commonmethods.staticWait(4000);
        try{
            commonmethods.clickByJS(logout_Label);
        }catch (Exception e) {
            driverContext.Driver.findElement(By.xpath("//img[@title='User']")).click();
            commonmethods.clickByJS(driverContext.Driver.findElement(By.xpath("//a[text()='Settings']/following-sibling::a")));
        }

    }
}
