package com.globantu.automation.jose_colin;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGet {
	
	private static final Logger logger =
	        Logger.getLogger(TestGet.class.getName());
	@BeforeClass
	@Parameters({ "urlGet" })
	public void setUp(String url) {
		baseURI = url;
	}

	@Test
	public void basicPingTest() {

		given().when().get().then().statusCode(200);
		String json = given().when().get().asString();

		logger.log(Level.INFO,json);

	}

	@Test
	public void validateContent() {

		given().when().get().then().body(containsString("Leanne Graham"));

		given().when().get().then().body("size", equalTo(10));

		given().when().get().then().body("[0].id", equalTo(1));

		given().when().get().then().body("[0].username", equalTo("Bret")).body("[1].email",
				equalTo("Shanna@melissa.tv"));

	}

	@Test 
	public void validateWithSchema() {

		given().when().get().then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
	}
}
