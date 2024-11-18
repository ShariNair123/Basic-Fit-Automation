package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.createIncidentMOD_Page;
import pages.clubActivity_Page;

public class clubActivityPageSteps {

    clubActivity_Page clubActivityPage=new clubActivity_Page();

    @And("I select the Incident Club Activity record created")
    public void iSelectIncidentCARecord() {
        clubActivityPage.selectIncidentCARecord();
    }

    @And("I verify the Club Activity details generic for Incidents")
    public void iVerifyIncidentCAGenericDetails() {
        clubActivityPage.verifyIncidentCAGenericDetails();
    }

    @And("I verify the Club Activity details specific for Unknown Incidents")
    public void iVerifyIncidentCASpecificDetails() {
        clubActivityPage.verifyIncidentCASpecificDetailsUnknown();
    }

    @And("I verify the Club Activity details specific for Known Incidents")
    public void iVerifyIncidentCASpecificDetailsKnown() {
        clubActivityPage.verifyIncidentCASpecificDetailsKnown();
    }

    @And("I select the UnPlanned UnStaffed Club Activity record created")
    public void iSelectUnplannedUnstaffedCARecord() {
        clubActivityPage.selectUnplannedUnstaffedCARecord();
    }

    @And("I verify the Club Activity details for the UnPlanned UnStaffed request created")
    public void iVerifyUnplannedUnStaffedCADetails() {
        clubActivityPage.verifyUnplannedUnStaffedCADetails();
    }

    @And("I select the Investigation Club Activity record created")
    public void iSelectInvestigationCARecord() {
        clubActivityPage.selectInvestigationCARecord();
    }

    @And("I verify the Investigation CA record created")
    public void iVerifyInvestigationCARecordDetails() {
        clubActivityPage.verifyInvestigationCADetails();
    }

    @And("I select the Club Activity record created for temporary club closure without partial reopening")
    public void iSelectTempCARecordDetailsWithoutPartialReopening() {
        clubActivityPage.selectCATempClubClosureWithoutPartialReopeningDetails();
    }

    @And("I verify the Club Activity record created for temporary club closure without partial reopening")
    public void iVerifyTempCARecordDetailsWithoutPartialReopening() {
        clubActivityPage.verifyCATempClubClosureWithoutPartialReopeningDetails();
    }

}
