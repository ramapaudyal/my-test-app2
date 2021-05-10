package com.mycompany.app.Utilities;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/* class is empty but the annotations do the job */

@RunWith(Cucumber.class)
@CucumberOptions(features = {" . "}, glue = {"com.mycompany.app.StepDefinitions"})
public class TestRunner {
}
