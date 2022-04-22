package CRUD_Operations_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject()
	{
		//step 1:create the pre requisits - response boday
				JSONObject JObj = new JSONObject();
				JObj.put("createdBy","jay1");
				JObj.put("projectName","j3");
				JObj.put("status", "on-going");
				JObj.put("teamSize", 14);
				
				RequestSpecification req = RestAssured.given();
				req.body(JObj);
				req.contentType(ContentType.JSON);
				
		//step 2:perform action
				Response response = req.put("http://localhost:8084/projects/TY_PROJ_414");
				
		//step 3:validate
				
				System.out.println(response.getContentType());
				System.out.println(response.asString());
				System.out.println(response.prettyPrint());
				System.out.println(response.prettyPeek());
	}
}
