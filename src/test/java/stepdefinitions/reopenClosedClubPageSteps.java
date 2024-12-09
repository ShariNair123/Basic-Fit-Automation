package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.caseCreation_Page;
import pages.caseDetail_Page;
import pages.reopenClosedClub_Page;

public class reopenClosedClubPageSteps {

    reopenClosedClub_Page reopenClosedClubPage = new reopenClosedClub_Page();

    @And("I click on Reopen Closed Club")
    public void iClickOnReopenClosedClubButton() {
        reopenClosedClubPage.clickReopenClosedClubButton();
    }

    @And("I select Club openings type and Opening hours type")
    public void iSelectClubOpeningsTypeAndOpeningHoursType() {
        reopenClosedClubPage.selectClubOpeningsAndOpeningHoursType();
    }

    @And("I click on Save and Close")
    public void iClickOnSaveAndClose() {
        reopenClosedClubPage.clickOnSaveAndClose();
    }

    @And("I verify that the club has been opened")
    public void iVerifyClubReopen() {
        reopenClosedClubPage.verifyClubReopen();
    }

}
