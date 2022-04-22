package responseValidation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation {

	@Test
	public void responseTime()
	{
		//pre requisites
		baseURI = "http://localhost";
		port=8084;
		
		//action
	   Response	resp = when()
		              .get("/projects");
		
		//validation
		  resp.then()
		  .assertThat().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS)
		  .log().all();
		  long tm =resp.time();
		  System.out.println(tm);
		
	}
}
