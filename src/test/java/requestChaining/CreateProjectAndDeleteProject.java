package requestChaining;

import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.Projectlibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndDeleteProject {

	@Test
	public void requestChaining()
	{
		//Step1:Create a project using POJO class
		 JavaUtility jLib = new JavaUtility();
		 Projectlibrary pLib = new Projectlibrary("Jeevan","google "+jLib.random(), "completed", 50);
		 baseURI="http://localhost";
		 port=8084;
		 
		 Response resp = given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		 .when()
		 .post("/addProject");
		 
		 //captured the project Id
		 String proId = resp.jsonPath().get("projectId");
		 System.out.println(proId);
		 resp.then().log().all();
		 
		 //Create a get request and pass proId as Path
		 given()
		 .pathParam("pid", proId)
		 .when()
		 .delete("/projects/{pid}")
		 .then()
		 .assertThat().statusCode(204).log().all();
		 
	}
}
