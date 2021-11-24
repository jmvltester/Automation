Feature: Verify PetStore API

Scenario: Verify the status of the petstore API calls
	Given Pet Store Payload
	When user calls petstore API with "GET" http request
	Then the API calls is success with the status code 200
	