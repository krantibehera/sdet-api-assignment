package stepDefinations;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.BaseUtils;
import resources.TestDataBuild;
import validations.ResponseValidation;

public class StepDefination extends BaseUtils {
	RequestSpecification res;
	Response response;
	TestDataBuild data =new TestDataBuild();


	@Given("User create request specification")
	public void user_create_request_specification() throws IOException {
         if (this.res == null)
			 this.res=given().spec(requestSpecification());
	}

	@Given("User Create Payload with {int}  {string} {string}")
	public void user_create_Payload_with(int userId, String title, String body) {
		res.body(data.addPost(userId,title,body));
	}
    // GET and POST call without Param
	@When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) throws IOException {
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
			response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
		}
}
	// GET, POST and PUT call with Query Param
	@When("user calls {string} for {string} {string} with {string} http request")
	public void user_calls_for_with_http_request(String resource, String param,String id, String method) throws IOException {
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("PUT")) {
			res.param(param, id);
			response = res.when().put(resourceAPI.getResource());
		} else if(method.equalsIgnoreCase("GET")){
			res.param(param, id);
			response =res.when().get(resourceAPI.getResource());
		} else if (method.equalsIgnoreCase("DELETE")) {
			res.param(param, id);
			response =res.when().delete(resourceAPI.getResource());

		}
	}

	// GET, POST and PUT call with Path Param
	@When("user calls {string} {string} {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String param,String id, String method) throws IOException {
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("PUT")) {
			res.pathParam(param, id);
			response = res.when().put(resourceAPI.getResource() + "{"+param+"}");
		} else if(method.equalsIgnoreCase("GET")){
			res.pathParam(param, id);
			response =res.when().get(resourceAPI.getResource() + "{"+param+"}");
		} else if (method.equalsIgnoreCase("DELETE")) {
			res.pathParam(param, id);
			response =res.when().delete(resourceAPI.getResource() + "{"+param+"}");

		}
	}

	@Then("all the {string} in response body list is {int}")
	public void all_the_in_response_body_list_is(String userId, int expectedValue) {
		new ResponseValidation().verifyPost(response,expectedValue);
	}

	@Then("the user verifies the comments from the response")
	public void the_user_verifies_the_comments_from_the_response() {
		new ResponseValidation().verifyComments(response);
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(int actualStatusCode) {
		new ResponseValidation().verifyStatusCode(response,actualStatusCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		new ResponseValidation().verifyResponseBody(response,keyValue,Expectedvalue);
	}

	@Then("check for user with {string}")
	public void check_for_user_with(String userName) {
		new ResponseValidation().verifyUserName(response,userName);
	}

	@Then("user list is returned")
	public void user_list_is_returned() {
		new ResponseValidation().verifyUserList(response);
	}

	@Then("user list size is {int}")
	public void user_list_size_is(int size) {
		new ResponseValidation().verifyListSize(response,size);
	}


}
