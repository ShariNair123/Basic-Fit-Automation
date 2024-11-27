package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.caseDetail_Page;
import pages.createIncidentMOD_Page;
import pages.clubActivity_Page;

public class caseDetailPageSteps {

    caseDetail_Page caseDetailPage=new caseDetail_Page();

    @And("I verify the created Late Club Opening case details")
    public void iVerifyLateClubOpeningCaseDetails() {
        caseDetailPage.verifyLateClubOpeningCaseDetails();
    }

    @And("I select the MOD Case Club Activity record created")
    public void iSelectMODCaseDetails() {
        caseDetailPage.selectMODCaseDetails();
    }

    @And("I verify the MOD Case Club Activity record details")
    public void iVerifyMODCaseDetails() {
        caseDetailPage.verifyMODCaseDetails();
    }
}
