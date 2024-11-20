package stepdefinitions;

import io.cucumber.java.en.And;
import pages.tempCloseClub_Page;

public class tempCloseClubPageSteps {

    tempCloseClub_Page tempCloseClubPage = new tempCloseClub_Page();

    @And("I click on Close Club button for Temporary Club Closure")
    public void iClickOnCloseClubButton() {
        tempCloseClubPage.clickCloseButton();
    }

    @And("I enter Temporary Closure details")
    public void iEnterTemporaryClosureDetails() {
        tempCloseClubPage.enterTemporaryClosureDetails();
    }

    @And("I enter the Partial Reopening field values")
    public void iEnterPartialReopeningFieldValues() {
        tempCloseClubPage.enterPartialReopeningFieldValues();
    }

    @And("I click Next for Temporary Club Closure")
    public void iClickNext() {
        tempCloseClubPage.clickNext();
    }

    @And("I click Save for Temporary Club Closure")
    public void iClickSave() {
        tempCloseClubPage.clickSave();
    }

    @And("I verify that the club is closed temporarily")
    public void iVerifyThatTheClubIsClosedTemporarily() {
        tempCloseClubPage.verifyTemporaryClubClosure();
    }

    @And("I check the Partial Reopening fields for Without Partial Reopening scenario")
    public void iCheckThePartialReopeningFieldsForWithoutPartialReopeningScenario() {
        tempCloseClubPage.checkPartialReopeningFieldsForWithoutPartialReopeningScenario();
    }

}


