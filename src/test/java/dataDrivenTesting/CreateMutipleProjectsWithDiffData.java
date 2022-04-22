package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Libraries.JavaUtility;
import io.restassured.http.ContentType;
import projectLibrary.Projectlibrary;

import static io.restassured.RestAssured.*;

public class CreateMutipleProjectsWithDiffData {

	@Test(dataProvider = "getData")
	
	public void createMultipleProjects(String createdBy,String projectID,String status,int teamSize)
	{
	     JavaUtility jLib = new JavaUtility();
	     Projectlibrary pLib =new Projectlibrary(createdBy, projectID+jLib.random(),status, teamSize);
	     
	     baseURI= "http://localhost";
	     port=8084;
	     
	     given()
	      .body(pLib)
	      .contentType(ContentType.JSON)
	      
	      //Action
	      .when()
	      .post("/addProject")
	      
	      //validation
	      .then().log().all();
	      
	}
	
	@DataProvider(name ="getData")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Jayanth";
		data[0][1]="dell";
		data[0][2]="Created";
		data[0][3]=20;
		
		data[1][0]="Jayanth_1";
		data[1][1]="HP";
		data[1][2]="Created";
		data[1][3]=25;
		
		data[2][0]="Jayanth_2";
		data[2][1]="Lenovo";
		data[2][2]="Created";
		data[2][3]=30;
		
		
		return data ;
	}
	
}
