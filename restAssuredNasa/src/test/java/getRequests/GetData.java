package getRequests;

import org.testng.Assert;
import org.testng.annotations.*;

import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	public String rootURL = "https://images-api.nasa.gov";
	
	@Test
	public void testCurrentStatusCode()
	{
		//interface
		Response responseObj = RestAssured.get(rootURL);
		
		//status code of request
		int currStatusCode = responseObj.getStatusCode();
		System.out.println("Current Status Code: " + currStatusCode);
		Assert.assertEquals(currStatusCode,200);
	}
	
	
	@Test
	public void getSearchBody() {
		
		Response responseObj = RestAssured.get(rootURL + Endpoints.searchEndpoint);
		
		String bodyData = responseObj.asString();
		
		System.out.println("Search Bodfy Response: " + bodyData);
	}

}
