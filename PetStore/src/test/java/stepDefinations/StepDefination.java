package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;

public class StepDefination extends Utils{
	

	@Given("Pet Store Payload")
	public void pet_store_payload() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.baseURI ="http://petstore-demo-endpoint.execute-api.com/";
		String response = given().log().all().when().get("petstore/pets").then().extract().response().asString().LogResponseTo(log);
		System.out.println(response);
		
		
		
		
	}
	

	@When("user calls petstore API with {string} http request")
	public void user_calls_petstore_api_with_http_request(String method) {
		
	}

	
	@Then("the API calls is success with the status code {int}")
	public void the_api_calls_is_success_with_the_status_code(Integer int1) {
	
		assertEquals(response.getStatusCode(),200);
	}

}
