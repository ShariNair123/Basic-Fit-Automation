package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.login_Page;
import pages.closeClub_Page;

import java.io.IOException;

public class closeClubSteps {

    closeClub_Page closeClubPage = new closeClub_Page();

    @And("I click on Close Club button")
    public void iClickOnCloseClubButton() {
        closeClubPage.clickCloseButton();
    }

    @And("I enter Permanent Closure details")
    public void iEnterPermanentClosureDetails() {
        closeClubPage.enterPermanentClosureDetails();
    }

    @And("I click Next")
    public void iClickNext() {
        closeClubPage.clickNext();
    }

    @And("I click Save")
    public void iClickSave() {
        closeClubPage.clickSave();
    }

    @And("I verify that the club is closed permanently")
    public void iVerifyThatTheClubIsClosedPermanently() {
        closeClubPage.verifyPermanentClubClosure();
    }

}
