package Stepdefinatios;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinations {
	
	@Given("a new deck starts with {int} cards")
	public void a_new_deck_starts_with_cards(Integer int1) {
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
	
	@When("Draw cards from the deck {int} times each time draw between {int} and {int} cards at random")
	public void draw_cards_from_the_deck_times_each_time_draw_between_and_cards_at_random(Integer int1, Integer int2, Integer int3) {
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
	
	@When("Return the first drawn card back to the deck")
	public void return_the_first_drawn_card_back_to_the_deck() {
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
	
	@Then("Verify that the correct number of cards are remaining in the deck")
	public void verify_that_the_correct_number_of_cards_are_remaining_in_the_deck() {
		given()
		.when()
			.get("https://deckofcardsapi.com/api/deck/t17ebtyxgwcn/shuffle/?remaining=true")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			//.assertThat().body("remaining", equalTo(52))
			.header("Content-Type","application/json")
		 	.log().all(); 
	}
	
}
