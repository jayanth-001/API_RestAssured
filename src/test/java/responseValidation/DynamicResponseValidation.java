package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamicResponse()
	{
		baseURI ="http://localhost";
		port =8084;
		
		String expData = "TY_PROJ_203";
		
		//action
		   Response resp = when()
		   .get("/projects");
		   
		 //Validation
		   List<String>   actData =resp.jsonPath().get("projectId");
		   
		   boolean flag = false;
		   
		   for(String projectId : actData)
		   {
			   if(projectId.equalsIgnoreCase(expData))
			   {
				   flag = true;
			   }
		   }
		   Assert.assertEquals(flag,true);
		   System.out.println("Data verified");
		   
		   resp.then().log().all();
		   
		   
	}
	
}
