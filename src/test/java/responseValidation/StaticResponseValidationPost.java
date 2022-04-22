package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.Projectlibrary;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationPost {

	@Test
	public void staticResponse()
	{
		 baseURI ="http://localhost";
		 port=8084;
		 
		 String exp="TY_PROJ_808";
		 
		JavaUtility jLib = new JavaUtility();
		 Projectlibrary pLib = new Projectlibrary("Amith", "Dell"+jLib.random(),"Created", 20); 
		 
		Response resp = given()
		   .body(pLib).contentType(ContentType.JSON)
		   
		   .when()
		   .post("/addProject");
		 
	        String act=resp.jsonPath().get("projectId");
	        Assert.assertEquals(act, exp);
	        resp.then().log().all();
		 
		
		 
		 
		 
	}
}
