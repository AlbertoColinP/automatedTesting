package com.globantu.automation.jose_colin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestPost {

	private static final Logger logger =
	        Logger.getLogger(TestPost.class.getName());
	
	@BeforeClass
	@Parameters({"urlPost"})
	public void setUp(String urlPost) {
		
		RestAssured.baseURI = urlPost;
	
		}
	
	@Test
	public void testPostStatus() {
		
		 Map<String,String> user = new HashMap<>();
		 user.put("userId", "100");
		 user.put("id", "5030");
		 user.put("title", "holaa");
		 user.put("body", "aaaaaaaaaaaaaaaaaaa");
		 
		 given()
	        .contentType("application/json")
	        .body(user)
	        .when().post().then()
	        .statusCode(201);
	}
	
	@Test
	public void testPostBody() {
		
		 Map<String,String> user = new HashMap<>();
		 user.put("userId", "100");
		 user.put("id", "5030");
		 user.put("title", "holaa");
		 user.put("body", "aaaaaaaaaaaaaaaaaaa");
		 
		 given()
	        .contentType("application/json")
	        .body(user)
	        .when().post().then()
	        .body("userId",equalTo("100")).body("title", equalTo("holaa"));
	}
	
	@Test
    public void createAndDelete() {
     
		 Map<String,String> user = new HashMap<>();
		 user.put("userId", "100");
		 user.put("id", "5030");
		 user.put("title", "holaa");
		 user.put("body", "aaaaaaaaaaaaaaaaaaa");
        String id = given()
        .contentType("application/json")
        .body(user)
        .when().post().then()
        .extract().path("id");
        logger.log(Level.INFO,id);
        
        given().pathParam("id",1)
        .when().delete(RestAssured.baseURI+"/{id}").then()
        .statusCode(200);

    }
}
