package com.djcodes.testing.rest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@LocalServerPort
	private int port;

	private String uri;

	@PostConstruct
	public void init() {
		uri = "http://localhost:" + port;
	}

	@Test
	public void welcomeTest() {
		get(uri + "/employee/welcome").then().assertThat().body(containsString("Welcome"));
	}

	@Test
	public void getEmployeeListValidTest() {
		Employee[] emps = get(uri + "/employee/getEmployeeList").then().statusCode(200).extract().as(Employee[].class);
		assertEquals("Checking if Size is greater than 0", true, emps.length > 0);
	}

	@Test
	public void getEmployeeFoundTest() {
		get(uri + "/employee/4").then().assertThat().statusCode(200).body("name", equalToIgnoringCase("aloy"));
	}

	@Test
	public void getEmployeeNotFoundTest() {
		get(uri + "/employee/21").then().assertThat().statusCode(404);
	}

	@Test
	public void searchBySalaryGreaterThanFoundTest() {
		double amt = 100000.00;
		List<Float> salaraies = given().param("amt", amt).when().post(uri + "/employee/searchBySalaryGreaterThan")
				.then().extract().response().jsonPath().get("salary");

		for (Float salary : salaraies) {
			assertEquals(true, salary > amt);
		}

	}

	@Test
	public void searchBySalaryGreater_NegativeTest_PostWithoutParam() {

		post(uri + "/employee/searchBySalaryGreaterThan").then().assertThat().statusCode(greaterThanOrEqualTo(400));

	}
}
