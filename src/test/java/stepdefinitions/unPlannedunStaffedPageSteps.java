package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.login_Page;
import pages.unPlannedunStaffed_Page;

import java.io.IOException;

public class unPlannedunStaffedPageSteps {

    unPlannedunStaffed_Page unPlannedunStaffedPage = new unPlannedunStaffed_Page();

    @And("I click on Request to MARC button")
    public void iClickOnRequestToMARCButton() {
        unPlannedunStaffedPage.clickRequestToMARCButton();
    }

    @And("I enter UnPlanned UnStaffed request details")
    public void iEnterUnPlannedUnStaffedRequest() {
        unPlannedunStaffedPage.enterUnPlannedUnStaffedRequestDetails();
    }

    @And("I confirm the request creation")
    public void iConfirmRequestCreation() {
        unPlannedunStaffedPage.confirmRequestCreation();
    }
}
