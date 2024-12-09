package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions", "base"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@Login or @CaseCreationLateClubOpening or @CaseCreationMOD or @CaseCreationIncidentAccident or @MODClubClosureUnKnown or @MODClubClosureKnown or @InvestigationRequest or @CloseClubPermanently or @CloseClubTemporarilyWithoutPartialReopening or @CloseClubTemporarilyWithPartialReopening")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
