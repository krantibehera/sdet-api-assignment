Feature: Validating Comment API's

	Background: User generates token for Authorization
		Given User create request specification

	@Sanity
Scenario Outline: Verify if an user can view all the comments in the post using GetCommentAPI
	When user calls "GetCommentAPI" with "GET" http request
	Then the API call got success with status code 200
	And the user verifies the comments from the response

	Examples:
	|userId |
	|1 		|

	@Sanity
Scenario Outline: Verify if an user can reterive a post comment for a given userID using GetCommentAPI
	When user calls "GetCommentAPI" for "id" "<id>" with "GET" http request
	Then the API call got success with status code 200
	And the user verifies the comments from the response

		Examples:
		|id     |
		|2 		|

	@Sanity
Scenario Outline: Verify if an user can reterive a post comment for a given userID using GetCommentAPI
	When user calls "GetCommentAPI" for "postId" "<postId>" with "GET" http request
	Then the API call got success with status code 200
	And the user verifies the comments from the response

		Examples:
			|postId |
			|1 		|