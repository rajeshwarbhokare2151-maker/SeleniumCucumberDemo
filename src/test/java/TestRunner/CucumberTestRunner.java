package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features/",
	    glue = {"stepDefinations"},
	    plugin = {
	        "pretty",
	        "html:target/htmlreport.html",
	        "json:target/CucumberReports/report.json",
	        "junit:target/CucumberReports/report.xml"
	    }
	)
	public class CucumberTestRunner extends AbstractTestNGCucumberTests { }