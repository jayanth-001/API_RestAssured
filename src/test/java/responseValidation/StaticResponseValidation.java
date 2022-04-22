package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponse()
	{
		//pre requisites
		baseURI="http://localhost";
		port=8084;
		 String expData="TY_PROJ_203";
		
		//action
		Response resp = when()
		                .get("/projects");
		
		//validation
		String actData= resp.jsonPath().get("[0].projectId");
		 Assert.assertEquals(actData, expData);
		 System.out.println("data verified");
		 System.out.println(actData);
		  resp.then().log().all();
		 
		
	}
	
}
