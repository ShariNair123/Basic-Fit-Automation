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

    @And("I click on New button")
    public void iClickNewButton() {
        caseCreationPage.clickNewButton();
    }

    @And("I select the Record Type as Late Club Opening")
    public void iSelectLateClubOpeningRecordType() {
        caseCreationPage.selectRecordTypeLateClubOpening();
    }

    @And("I verify the auto populated case details")
    public void iVerifyAutoPopulatedLateClubOpeningCaseDetails() {
        caseCreationPage.verifyAutoPopulatedLateClubOpeningCaseDetails();
    }

    @And("I enter the required case test data")
    public void iEnterRequiredLateClubOpeningCaseTestData() {
        caseCreationPage.enterRequiredLateClubOpeningCaseTestData();
    }

    @And("I submit the late club opening case")
    public void iSubmitLateClubOpeningCase() {
        caseCreationPage.submitLateClubOpeningCase();
    }

    @And("I verify the success toast message for case creation")
    public void iVerifyCaseSuccessToastMessage() {
        caseCreationPage.verifyCaseSuccessToastMessage();
    }

}
