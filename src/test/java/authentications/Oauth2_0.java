package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {

	@Test
	public void oAuth2_0()
	{
		//create a request to generate access token
		Response resp = given()
		  .formParam("client_id","SDET30CoopsAPI!")
		  .formParam("client_secret","8e450ef1f116e298555b4e99045229c7")
		  .formParam("grant_type", "client_credentials")
		  .formParam("redirect_uri","http://example.com")
		  .formParam("code","authorization_code")
		  
		  .when()
		     .post("http://coop.apps.symfonycasts.com/token");
		  // resp.then().log().all();
		
		//Capture the access token from the response of the above request
		 String token =resp.jsonPath().get("access_token");	
		 System.out.println(token);
		 
		 //create another request and use the token to access the APIs
		 given()
		   .auth().oauth2(token)
		   .pathParam("USER_ID", 3123)

		   .when()
		     .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		     
		     .then().log().all();
	}

	
}
