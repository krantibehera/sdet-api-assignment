Feature: Validating Users API's

	Background: User generates token for Authorization
		Given User create request specification

	@Sanity
Scenario Outline: Verify all the users list
	When user calls "GetUserAPI" with "GET" http request
	Then the API call got success with status code 200
	And user list is returned
	And check for user with "<userName>"

	Examples:
	|userName|
	|Bret 	 |

	@Sanity
	Scenario Outline: Verify get user details by UserName
		When user calls "GetUserAPI" for "username" "<username>" with "GET" http request
		Then the API call got success with status code 200
		And user list is returned
		And check for user with "<username>"
		And user list size is <size>

		Examples:
			|username|size|
			|Bret 	 |  1 |

	@Sanity
	Scenario Outline: Verify get user details by UserId
		When user calls "GetUserAPI" for "id" "<id>" with "GET" http request
		Then the API call got success with status code 200
		And user list is returned
		And check for user with "<username>"
		And user list size is <size>

		Examples:
			|id  |size|username|
			|1 	 |  1 |Bret    |

	@Sanity
	Scenario Outline: Verify get user details with Invalid userId
		When user calls "GetUserAPI" "id" "<id>" with "GET" http request
		Then the API call got success with status code 404

		Examples:
			|id  |
			|1000|