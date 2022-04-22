package CRUD_Operation_WithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class singleProject {

	@Test
	public void singleProject()
	{
		baseURI ="http://localhost";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_205")
		
		.then()
		.log().all();
	}
}
