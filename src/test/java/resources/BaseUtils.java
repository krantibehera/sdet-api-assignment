package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseUtils {

	public static RequestSpecification req;
	public static ResponseSpecification response;

	public static RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public ResponseSpecification responseSpecification() {
		return new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}

	public static String getGlobalValue(String key) throws IOException {
		return DataLoader.getInstance().getValue(key);

	}
}
