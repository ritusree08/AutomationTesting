package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/CreateOpportunity.feature",glue="stepdef")
public class Executionclass extends AbstractTestNGCucumberTests {

}
