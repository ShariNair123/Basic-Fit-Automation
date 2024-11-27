package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions", "base"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@Login or @CaseCreationLateClubOpening or @MODClubClosureUnKnown or @MODClubClosureKnown or @InvestigationRequest or @CloseClubPermanently or @CloseClubTemporarilyWithoutPartialReopening or @CloseClubTemporarilyWithPartialReopening or @RequestToMARCUnPlannedUnStaffed")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
