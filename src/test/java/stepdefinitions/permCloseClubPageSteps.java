package stepdefinitions;

import io.cucumber.java.en.And;
import pages.permCloseClub_Page;

public class permCloseClubPageSteps {

    permCloseClub_Page permCloseClubPage = new permCloseClub_Page();

    @And("I click on Close Club button for Permanent Club Closure")
    public void iClickOnCloseClubButton() {
        permCloseClubPage.clickCloseButton();
    }

    @And("I enter Permanent Closure details")
    public void iEnterPermanentClosureDetails() {
        permCloseClubPage.enterPermanentClosureDetails();
    }

    @And("I click Next for Permanent Club Closure")
    public void iClickNext() {
        permCloseClubPage.clickNext();
    }

    @And("I click Save for Permanent Club Closure")
    public void iClickSave() {
        permCloseClubPage.clickSave();
    }

    @And("I verify that the club is closed permanently")
    public void iVerifyThatTheClubIsClosedPermanently() {
        permCloseClubPage.verifyPermanentClubClosure();
    }

}
