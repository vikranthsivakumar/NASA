package getRequests;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.*;

import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	public String rootURL = "https://images-api.nasa.gov";

	@Test(priority=0)
	public void testCurrentStatusCode() {
		// interface
		Response responseObj = RestAssured.get(rootURL);

		// status code of request
		int currStatusCode = responseObj.getStatusCode();
		System.out.println("Current Status Code: " + currStatusCode);
		// print success if endpoint is successfull
		if (currStatusCode == 200) {
			System.out.println("Success");
		}
		Assert.assertEquals(currStatusCode, 200);
	}

	
	@Test
	public void getSearchBody() {

		Response responseObj = RestAssured.get(rootURL + Endpoints.searchEndpoint);

		String bodyData = responseObj.asString();

		System.out.println("Search Bodfy Response: " + bodyData);
	}

	/*
	 * Ideally we would want to have a config file that has a flag set to switch the
	 * different centers/places.
	 */

	@Test
	public void getSearchCenterKSC() {
		Response responeObjCenter = RestAssured.get(rootURL + Endpoints.searchKSCCenter);

		String centerBody = responeObjCenter.asString();
		System.out.println("Search with Center Defined" + centerBody);
		Assert.assertTrue(centerBody.contains("KSC"));

	}

	/*This test below is not very critical but it is just to demonstrate that the description
	 * can be used to particularly identified through the body.
	 */
	@Test
	public void getDescriptionLaunchPad36A() {
		Response responeObjDescription = RestAssured.get(rootURL + Endpoints.searchDescriptionLaunch36A);

		String descriptionBody = responeObjDescription.asString();
		System.out.println("Search with Description 'LaunchPad 36A' Defined" + descriptionBody);
		Assert.assertTrue(descriptionBody.contains("Pad 36A"));

	}
	
	@Test
	public void searchCurrentYear() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("Current Year is: " + currentYear);
		
		Response responseObjCurrTime = RestAssured.get(rootURL + Endpoints.searchLatestTimeStamp);
		String currentYearStamp = responseObjCurrTime.asString();
		System.out.println("Search Results with current Year" + currentYearStamp);
		Assert.assertTrue(currentYearStamp.contains("2018"));
	}
	
	

}
