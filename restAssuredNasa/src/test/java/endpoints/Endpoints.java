package endpoints;

import java.util.Calendar;

public class Endpoints {
	
	
	//API Endpoints 
	
	//SEARCH Endpoint 
	public static String searchEndpoint = "/search?q=q";
	public static String searchKSCCenter = "/search?center=KSC";
	public static String searchDescriptionLaunch36A = "/search?description=At Launch Pad 36A";
	
	public static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	public static String searchLatestTimeStamp = "/search?year_start="+currentYear;
	
	//ASSET Endpoint
	public static String assetEndpoint = "/asset/";
	
	//METADATA Endpoint
	public static String metaDataEndpoint = "/metadata/";
	
	//CAPTIONS Endoint
	public static String captionsEndpoint = "/captions/";
	
}
