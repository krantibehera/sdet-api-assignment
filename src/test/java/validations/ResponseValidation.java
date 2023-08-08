package validations;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Comment;
import pojo.Post;
import pojo.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

public class ResponseValidation {

    private List<Post> allPostsByUser;
    private List<Comment> allCommentsOnUserPosts;

    public void verifyComments(Response response){
        allCommentsOnUserPosts = Arrays.asList(response.getBody().as(Comment[].class));
        String emailRegex = "^(.+)@(.+)$";
        allCommentsOnUserPosts.forEach(comment -> {
            Assert.assertTrue(comment.getEmail().matches(emailRegex));
        });

    }
    public void verifyPost(Response response,int expectedValue){
        allPostsByUser = Arrays.asList(response.getBody().as(Post[].class));
		allPostsByUser.forEach(post -> Assert.assertEquals(Optional.ofNullable(post.getUserId()), Optional.ofNullable(expectedValue)));
    }
    public void verifyStatusCode(Response response,int actualStatusCode){
        assertEquals(response.getStatusCode(),actualStatusCode);
    }
    public void verifyResponseBody(Response response,String keyValue,String Expectedvalue){
        assertEquals(getJsonPath(response,keyValue),Expectedvalue);
    }
    public static String getJsonPath(Response response,String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public void verifyUserList(Response response) {
        List<User> users = Arrays.asList(response.getBody().as(User[].class));
        if (users.size() > 0) {
            Assert.assertTrue("List of user is displayed",true);
        } else
            Assert.fail("No user found");
    }

    public void verifyUserName(Response response,String userName) {
        List<User> users = Arrays.asList(response.getBody().as(User[].class));
        Assert.assertEquals(userName,users.get(0).getUsername());
    }

    public void verifyListSize(Response response,int expectedSize) {
        List<User> users = Arrays.asList(response.getBody().as(User[].class));
        Assert.assertEquals(users.size(),expectedSize);
    }
}


