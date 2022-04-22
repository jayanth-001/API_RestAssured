package CRUD_Operation_WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject()
	{
	
		baseURI="http://localhost";
		port=8084;
		
	//step 1:create the pre requisits - response body
			JSONObject JObj1 = new JSONObject();
			JObj1.put("createdBy", "jay1");
			JObj1.put("projectName","Lexus2");
			JObj1.put("status", "on going");
			JObj1.put("teamSize", 15);
			
			given()
			.body(JObj1)
			.contentType(ContentType.JSON)	
			
	//Step 2:Perform the Action
			.when()
			.post("/addProject")
			
		//Step 3: Validate the response
			.then()
			.assertThat()
			.statusCode(201)
			.log().all();
			
	}
}

