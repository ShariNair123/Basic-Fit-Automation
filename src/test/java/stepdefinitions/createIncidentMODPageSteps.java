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

    @And("I click on Submit")
    public void iClickOnSubmit() {
        createIncidentMODPage.submitIncidentDetails();
    }

    @And("I verify that the Incident is created")
    public void iVerifyIncidentCreation() {
        createIncidentMODPage.verifyIncidentCreation();
    }

    @And("I verify that the Account page is updated")
    public void iVerifyAccountPageIsUpdated() {
        createIncidentMODPage.verifyAccountPage();
    }
}
