package br.com.origin.exercise.cucumber.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "br.com.origin.exercise.cucumber.stepdefinitions"
)
public class CucumberTestSuite {
}
