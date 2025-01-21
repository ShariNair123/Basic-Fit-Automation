package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions", "base"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@CaseCreationIncidentAccident or @CaseCreationLateClubOpening or @CaseCreationMOD or @Login or @MODClubClosureUnKnown or @MODClubClosureKnown")

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
