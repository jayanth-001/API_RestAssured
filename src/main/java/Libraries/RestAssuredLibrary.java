package Libraries;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;





/**
 * this class consists of generic methods related to restassured
 * @author Jay
 *
 */
public class RestAssuredLibrary {
	
	/**
	 * This method will return the json path
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath(Response resp, String jsonPath)
	{  
		String value = resp.jsonPath().get(jsonPath);
		return value;
      
	}
}
