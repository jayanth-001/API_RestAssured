package CRUD_Operations_withoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getSingleProject {

	@Test
	public void getSingleProject()
	{
	
		// perform action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_202");
		
		 
		 //validation
		 ValidatableResponse act = resp.then().log().all();
		  int act1= resp.getStatusCode();
		  Assert.assertEquals(act1, 200);
	}
		
	
}
