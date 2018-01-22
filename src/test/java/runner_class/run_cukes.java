package runner_class;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/feature_files"},
				 plugin={"pretty"},
				 glue={"step_definations"},
				 format={"html:target/reports"})

public class run_cukes {
	
	
}