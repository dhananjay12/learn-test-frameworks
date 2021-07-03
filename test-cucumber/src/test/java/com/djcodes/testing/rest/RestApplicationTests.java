package com.djcodes.testing.rest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", "html:target/cucumber/index.html", "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/",
		glue = "com.djcodes.testing.rest",
		monochrome = true
)
public class RestApplicationTests {



}
