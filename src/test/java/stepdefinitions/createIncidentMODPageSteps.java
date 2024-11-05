package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.login_Page;
import pages.createIncidentMOD_Page;

import java.io.IOException;

public class createIncidentMODPageSteps {

    createIncidentMOD_Page createIncidentMODPage=new createIncidentMOD_Page();


    @And("I click on MOD Club Closure button")
    public void iClickOnTheMODClubClosureButton() {
    createIncidentMODPage.clickMODClubClosureButton();

    }

    @And("I enter Unknown Incident details")
    public void iEnterUnknownIncidentDetails() {
        createIncidentMODPage.enterUnknownIncidentDetails();
    }

    @And("I enter Known Incident details")
    public void iEnterKnownIncidentDetails() {
        createIncidentMODPage.enterKnownIncidentDetails();
    }

    @And("I click on Submit UnKnown Incident")
    public void iClickOnSubmitUnknownIncident() {
        createIncidentMODPage.submitUnknownIncidentDetails();
    }

    @And("I click on Submit Known Incident")
    public void iClickOnSubmitKnownIncident() {
        createIncidentMODPage.submitKnownIncidentDetails();
    }

    @And("I verify the Incident creation message")
    public void iVerifyIncidentCreationmessage() {
        createIncidentMODPage.verifyIncidentCreationMessage();
    }

    @And("I verify that the Club Operational Status icon is updated")
    public void iVerifyClubOperationalStatusIconIsUpdated() {
        createIncidentMODPage.verifyClubOperationalStatusIcon();
    }

    @And("I verify that the club is closed")
    public void iVerifyClubClosed() {
        createIncidentMODPage.verifyClubClosure();

    }

}
