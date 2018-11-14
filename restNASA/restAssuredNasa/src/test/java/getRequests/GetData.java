package getRequests;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testCurrentStatusCode()
	{
		//interface
		Response responseObj = RestAssured.get("https://images-api.nasa.gov");
		
		
		//status code of request
		int currStatusCode = responseObj.getStatusCode();
		System.out.println("Current Status Code: " + currStatusCode);
		Assert.assertEquals(currStatusCode,200);
	}
	
	
	

}
