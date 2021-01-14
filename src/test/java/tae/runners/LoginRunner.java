package tae.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/submit_timesheet.feature", glue = "tae.gluecode")
public class LoginRunner {
}