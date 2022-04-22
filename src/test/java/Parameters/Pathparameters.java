package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Pathparameters {

	@Test
	public void getSingleProject()
	{
		//pre-requisites
		baseURI="http://localhost";
		port=8084;
		
		given()
		 .pathParam("pid","TY_PROJ_808")
		 
		 //Actions
		 .when()
		 		.get("/projects/{pid}")
		 		
		 //validation
		 	.then()
		 	.log().all();
	}
	
}
