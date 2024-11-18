package stepdefinitions;

import io.cucumber.java.en.And;
import pages.tempCloseClub_Page;

public class tempCloseClubPageSteps {

    tempCloseClub_Page tempCloseClubPage = new tempCloseClub_Page();

    @And("I click on Close Club button for Temporary Club Closure")
    public void iClickOnCloseClubButton() {
        tempCloseClubPage.clickCloseButton();
    }

    @And("I enter Temporary Closure details without Partial Reopening")
    public void iEnterTemporaryClosureDetailsWithoutPartialReopening() {
        tempCloseClubPage.enterTemporaryClosureDetailsWithoutPartialReopening();
    }

    @And("I click Next for Temporary Club Closure")
    public void iClickNext() {
        tempCloseClubPage.clickNext();
    }

    @And("I click Save for Temporary Club Closure")
    public void iClickSave() {
        tempCloseClubPage.clickSave();
    }

    @And("I verify that the club is closed temporarily without partial reopening")
    public void iVerifyThatTheClubIsClosedTemporarilyWithoutPartialReopening() {
        tempCloseClubPage.verifyTemporaryClubClosureWithoutPartialReopening();
    }

    @And("I check the Partial Reopening fields")
    public void iCheckThePartialReopeningFields() {
        tempCloseClubPage.checkPartialReopeningFields();
    }

}


