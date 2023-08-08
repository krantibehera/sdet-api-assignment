package resources;
public enum APIResources {
	
	AddPostAPI("/posts"),
	UpdatePostAPI("/posts/"),
	GetPostAPI("/posts/"),
	DeletePostAPI("/posts/"),
	GetCommentAPI("/comments/"),
	GetUserAPI("/users/");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
