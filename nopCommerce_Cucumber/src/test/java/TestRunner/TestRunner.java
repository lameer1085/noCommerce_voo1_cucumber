package TestRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =".//Features/",             //".//Features//Customers.feature",
		//	".//Features/"   --- to run all the feature file. it wil execute all te feature files in that "Feature" folder
		//  {".//Features//Customers.feature",.//Features//Login.feature"}     ---- for multiple files, which are mentioned in the curly braces will run
		
		glue = "stepDefenitions",
		//dryRun = without  real execution it will verify feature file has corresponding stepDefenition file or not  
		dryRun=false,
		monochrome=true, // it will remove unnecessary character in the console window, it will give neat and clean console
		plugin= {"pretty","html:target/test-output"},  //// pretty = to create report pretty
		tags= "@Sanity" //this will run methods with tag name sanity, methods with the tag name regression
			
	)
public class TestRunner {
	
}
