package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.createIncidentMOD_Page;
import pages.login_Page;
import pages.investigationRequest_Page;

import java.io.IOException;

public class investigationRequestPageSteps {

    investigationRequest_Page investigationRequestPage=new investigationRequest_Page();

    @And("I click on Request Investigation button")
    public void iClickOnRequestInvestigationButton() {
        investigationRequestPage.clickInvestigationRequestButton();
    }

    @And("I enter Investigation request details")
    public void iEnterInvestigationRequestDetails() {
        investigationRequestPage.enterInvestigationRequestDetails();
    }

    @And("I Submit Investigation request")
    public void iClickOnSubmitInvestigationRequest() {
        investigationRequestPage.submitInvestigationRequestDetails();
    }
}
