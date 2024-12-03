package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;
import pages.caseCreation_Page;
import pages.caseDetail_Page;


public class caseCreationPageSteps {

    caseCreation_Page caseCreationPage=new caseCreation_Page();

    @And("I can navigate to Cases page")
    public void iNavigateToCasesPage() {
        caseCreationPage.goToCasesPage();
    }

    @And("I can navigate to Cases page in CM App")
    public void iNavigateToCasesPageInCMApp() {
        caseCreationPage.goToCMAppCasesPage();
    }

    @And("I click on New button")
    public void iClickNewButton() {
        caseCreationPage.clickNewButton();
    }

    @And("I select the Record Type as Late Club Opening")
    public void iSelectLateClubOpeningRecordType() {
        caseCreationPage.selectRecordTypeLateClubOpening();
    }

    @And("I verify that the MOD Record Type is automatically selected")
    public void iVerifyAutomaticRecordSelectionOfMODRecordType() {
        caseCreationPage.verifyRecordTypeMOD();
    }

    @And("I verify that the Incident Accident Record Type is automatically selected")
    public void iVerifyIncidentAccidentRecordType() {
        caseCreationPage.verifyRecordTypeIncidentAccident();
    }

    @And("I verify the auto populated case details for Late Club Opening")
    public void iVerifyAutoPopulatedLateClubOpeningCaseDetails() {
        caseCreationPage.verifyAutoPopulatedLateClubOpeningCaseDetails();
    }

    @And("I verify the auto populated case details for MOD Record Type")
    public void iVerifyAutoPopulatedMODCaseDetails() {
        caseCreationPage.verifyAutoPopulatedMODCaseDetails();
    }

    @And("I verify the auto populated case details for Incident Accident Record Type")
    public void iVerifyAutoPopulatedIncidentAccidentCaseDetails() {
        caseCreationPage.verifyAutoPopulatedIncidentAccidentCaseDetails();
    }

    @And("I enter the required case test data for Late Club Opening")
    public void iEnterRequiredLateClubOpeningCaseTestData() {
        caseCreationPage.enterRequiredLateClubOpeningCaseTestData();
    }

    @And("I enter the required case test data for MOD Record Type")
    public void iEnterRequiredMODCaseTestData() {
        caseCreationPage.enterRequiredMODCaseTestData();
    }

    @And("I enter the required case test data for Incident Accident")
    public void iEnterRequiredIncidentAccidentCaseTestData() {
        caseCreationPage.enterRequiredIncidentAccidentCaseTestData();
    }

    @And("I submit the case")
    public void iSubmitCase() {
        caseCreationPage.submitCase();
    }

    @And("I verify the success toast message for case creation")
    public void iVerifyCaseSuccessToastMessage() {
        caseCreationPage.verifyCaseSuccessToastMessage();
    }

}
