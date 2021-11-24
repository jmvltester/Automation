package deckOfCardsTEst;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Deck_Of_Cards {

	
	@Test(priority=1)
	public void getDeckDetails()
	{
		given()
		.when()
			.get("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("remaining", equalTo(52))
			.header("Content-Type","application/json")
		 	.log().all();
	}
	
	@Test(priority=2)
	public void getDrawCards()
	{
		given()
		.when()
			.get("https://deckofcardsapi.com/api/deck/t17ebtyxgwcn/draw/?count=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			//.assertThat().body("remaining", equalTo(52))
			.header("Content-Type","application/json")
		 	.log().all();
	}

	@Test(priority=3)
	public void getReturnBackDeck()
	{
		given()
		.when()
			.get("https://deckofcardsapi.com/api/deck/t17ebtyxgwcn/return/")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			//.assertThat().body("remaining", equalTo(52))
			.header("Content-Type","application/json")
		 	.log().all();
	}

	@Test(priority=4)
	public void getCorrectNumberCardsInDeck()
	{
		given()
		.when()
			.get("https://deckofcardsapi.com/api/deck/t17ebtyxgwcn/shuffle/?remaining=true")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("remaining", equalTo(52))
			.header("Content-Type","application/json")
		 	.log().all();
	}

}
