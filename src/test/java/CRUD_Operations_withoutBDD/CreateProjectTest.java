package CRUD_Operations_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void createProjectTest()
	{
		//step 1:create the pre requisits - response body
		JSONObject JObj = new JSONObject();
		JObj.put("createdBy","jay");
		JObj.put("projectName","j2");
		JObj.put("status", "completed");
		JObj.put("teamSize", 12);
		
		RequestSpecification req = RestAssured.given();
		req.body(JObj);
		req.contentType(ContentType.JSON);
		
		//Step 2:Perform the Action
		Response response = req.post("http://localhost:8084/addProject");
		
		//Step 3: Validate the response
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}
		
}

