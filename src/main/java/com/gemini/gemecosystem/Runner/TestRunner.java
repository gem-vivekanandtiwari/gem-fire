package com.gemini.gemecosystem.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/Feature.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "json:target/Myreports/report.json"}

)

public class TestRunner {


}