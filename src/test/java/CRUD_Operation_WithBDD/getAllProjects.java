package CRUD_Operation_WithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getAllProjects {

	@Test
	public void getAllProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects")
		
		.then()
		.log().all();
		
		
	}
}
