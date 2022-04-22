package Libraries;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {

	 public JavaUtility jLib = new  JavaUtility();
	 public RestAssuredLibrary rLib = new RestAssuredLibrary();
     public	DatabaseLibrary dLib = new DatabaseLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish connection
		dLib.connectToDB();
		System.out.println("======>Database connection Established");
		
		//Set base URI and Port
		baseURI ="http://localhost";
		port =8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}

}
