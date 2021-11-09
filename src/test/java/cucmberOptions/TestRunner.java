package cucmberOptions;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) if run without testng
@CucumberOptions(
		features = "src/test/java/features/Olx.feature",
		glue = "stepDefinitions" )

// extends AbstractTestNGCucumberTests if running with testng
public class TestRunner extends AbstractTestNGCucumberTests {

}
