package resources;

import pojo.Post;

public class TestDataBuild {

	public Post addPost(int userId, String title, String body){
		 return Post.builder().userId(userId).title(title).body(body).
				build();
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
