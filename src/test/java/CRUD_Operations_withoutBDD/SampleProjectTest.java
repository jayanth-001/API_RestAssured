package CRUD_Operations_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleProjectTest {

	@Test
	public void getAllProjectTest()
	{
		Response resp =RestAssured.get("http://localhost:8084/projects");
		//System.out.println(resp.asString());
		//resp.prettyPrint();
		resp.then().log().all();
	}
	
}
