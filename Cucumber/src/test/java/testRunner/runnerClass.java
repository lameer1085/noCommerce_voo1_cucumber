package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D://Java_Selenium//LocalEclipse//Cucumber//Features//OrangeHrm.feature",
		glue="stepDefinitions"
	)
public class runnerClass {

}
