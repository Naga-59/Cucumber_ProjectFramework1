package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= {".//Features/"},
		glue="stepDefinitions",
		plugin= {"pretty",
				 "html:reports/report2.html",
				 "json:reports/report2.json",
				 "rerun:target/rerun.txt",
		},
		dryRun=false,
		monochrome=true,
		tags = "@sanity"
		
		)
public class TestRunner {

	
}
