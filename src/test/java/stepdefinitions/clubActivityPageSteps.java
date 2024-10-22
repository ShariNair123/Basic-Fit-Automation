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

    @And("I select the Club Activity record created")
    public void iSelectClubActivityRecord() {
        clubActivityPage.selectClubActivityRecord();
    }

    @And("I verify the Club Activity details")
    public void iVerifyClubActivityDetails() {
        clubActivityPage.verifyClubActivityDetails();
    }

}
