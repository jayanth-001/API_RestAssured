package differentWaysToPOST;

import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import projectLibrary.Projectlibrary;

public class CreateProjectUsingPOJO {

	@Test
	public void createProjectUsingPOJO()
	{
		JavaUtility jLib=new JavaUtility();
		
		Projectlibrary pLib = new Projectlibrary("Jayanth", "AllNations "+jLib.random(), "on going", 10);
		 
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
