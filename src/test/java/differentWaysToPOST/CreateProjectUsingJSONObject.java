package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject {

	
	@Test
	public void createProjectUsingJSONObject()
	{
	
		JavaUtility jLib=new JavaUtility();
		
		baseURI="http://localhost";
		port=8084;
		
	//step 1:create the pre requisits - response body
			JSONObject JObj1 = new JSONObject();
			JObj1.put("createdBy", "jayanth");
			JObj1.put("projectName","Lexus2 "+ jLib.random());
			JObj1.put("status", "on going");
			JObj1.put("teamSize", 20);
			
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
