package Parameters;

import org.testng.annotations.Test;

import Libraries.JavaUtility;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingFormParameter {

	@Test
	public void createProject()
	{
		JavaUtility jLib=new JavaUtility();
		
	     baseURI ="http://localhost";
	     port =8084;
	     
	     given()
	     .formParam("createdBy","Jayanth")
	     .formParam("projectname","Lenovo_IdeaPad"+jLib.random())
	     .formParam("status","completed")
	     .formParam("teamsize", 20)
	     
	     .when()
	       .post("/addProject")
	       
	      .then().log().all(); 
	}
}
