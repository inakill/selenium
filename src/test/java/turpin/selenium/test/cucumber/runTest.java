package turpin.selenium.test.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions( 
			features={"src/test/resources/"}
		  ) 
	
//Specifying pretty as a format option ensure that HTML report will be generated. 
//When we specify html:target/Destination - It will generate the HTML report inside the Destination folder, in the target folder of the maven project. 

public class runTest { }