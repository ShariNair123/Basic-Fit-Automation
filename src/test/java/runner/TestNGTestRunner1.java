package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features1",
        glue = {"stepdefinitions", "base"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@InvestigationRequest or @CloseClubPermanently or @CloseClubTemporarilyWithoutPartialReopening or @CloseClubTemporarilyWithPartialReopening or @ReOpenClosedClub or @RequestToMARCUnPlannedUnStaffed")
public class TestNGTestRunner1 extends AbstractTestNGCucumberTests {
}
