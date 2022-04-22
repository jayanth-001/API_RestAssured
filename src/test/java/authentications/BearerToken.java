package authentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerToken()
	{
		baseURI ="https://api.github.com";
		JSONObject jObj=new JSONObject();
		jObj.put("name","Sdet30_restAssured");
		
		given()
		  .auth()
		  .oauth2("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")
		  .body(jObj)
		  .contentType(ContentType.JSON)
		  
		  .when()
		  .post("/user/repos")
		  
		  .then().log().all();
	}
}
