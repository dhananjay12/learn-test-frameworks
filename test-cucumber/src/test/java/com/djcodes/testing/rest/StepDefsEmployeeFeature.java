package com.djcodes.testing.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepDefsEmployeeFeature {
	@Autowired
	private TestRestTemplate restTemplate;


	private ResponseEntity<String> response;

	
	@Given("^employee services are up$")
	public void checkIfEmployeeServicesAreUp() {
		System.out.println("Employee services are up");
	}
	
	@When("^the client calls /employee/welcome$")
	public void requestWelcome() {
		response = restTemplate.exchange("/employee/welcome", HttpMethod.GET, null, String.class);
	}
	
	@When("^the client calls the search api with an (.*)$")
	public void getEmployee(String input) {
		response = restTemplate.exchange("/employee/"+input, HttpMethod.GET, null, String.class);
	}

	@Then("^the client receives status code of (\\d+)$")
	public void shouldGetResponseWithHttpStatusCode(int statusCode) {
		assertThat(statusCode,is(equalTo(response.getStatusCodeValue())));
	}

	@And("^the client receives string containing \"(.*)\"$")
	public void theResponseShouldContainTheMessage(String message) {
		assertThat(response.getBody(),containsString(message));
	}
}
