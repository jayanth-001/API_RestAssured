package CRUD_Operation_WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {

	@Test
	public void updateProject()
	{
		 JavaUtility jLib = new JavaUtility();
		
		baseURI="http://localhost";
		port=8084;
		
		//step 1:create the pre requisits - response body
		JSONObject JObj1 = new JSONObject();
		JObj1.put("createdBy", "jayanth");
		JObj1.put("projectName","Nexus" +jLib.random());
		JObj1.put("status", "on going");
		JObj1.put("teamSize", 15);
		 
		given()
		.body(JObj1)
		.contentType(ContentType.JSON)
		
	 
		//step 2:perform action
		.when()
		.put("/projects/TY_PROJ_605")
		
		//step 3:
		.then()
		.assertThat()
		.log().all()
		.statusCode(200);
	}
	
}
