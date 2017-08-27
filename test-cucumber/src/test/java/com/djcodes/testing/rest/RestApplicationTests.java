package com.djcodes.testing.rest;


import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin="pretty",
        features = "src/test/resources/",
        glue = "com.djcodes.testing"
)
public class RestApplicationTests {



}
