Feature: Validating Post API's

	Background: User generates token for Authorization
		Given User create request specification


	@Sanity
Scenario Outline: Verify if a new post is being succesfully added using AddPostAPI
	Given User Create Payload with <userId>  "<title>" "<body>"
	When user calls "AddPostAPI" with "POST" http request
	Then the API call got success with status code 201
	And "userId" in response body is "<userId>"
	And "title" in response body is "<title>"
	And "body" in response body is "<body>"

	
Examples:
	|userId 	 | title        |body		  |
	|1 			 |  Kranti Post |My First Post|

	@Sanity
Scenario Outline: Verify if Update a Post functionality is working
	Given User Create Payload with <userId>  "<title>" "<body>"
	When user calls "UpdatePostAPI" "id" "<id>" with "PUT" http request
	Then the API call got success with status code 200
	And "userId" in response body is "<userId>"
	And "title" in response body is "<title>"
	And "body" in response body is "<body>"

Examples:
	|userId 	 |title            |body		   |id|
	|1 			 |Kranti Post One  |My Second Post |1 |

@Sanity
Scenario Outline: Verify if an user can reterive a Post using given userID
	When user calls "GetPostAPI" for "userId" "<userId>" with "GET" http request
	Then the API call got success with status code 200
	And all the "userId" in response body list is <userId>

	Examples:
		|userId |
		|1 		|

	@Sanity
Scenario Outline: Verify if an user can delete a Post using given userID
	When user calls "DeletePostAPI" "userId" "<userId>" with "Delete" http request
	Then the API call got success with status code 200

	Examples:
	|userId |
	|1 		|

	@Sanity
Scenario Outline: Verify if an user can reterive a Post using an invalid userID
	When user calls "GetPostAPI" "id" "<id>" with "GET" http request
	Then the API call got success with status code 404
	Examples:
		|id     |
		|101 	|
	

	
	
	
	
	
	

	
	
	