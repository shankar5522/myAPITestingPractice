package resource;

public class Payload {

	public static String getAPIAddPlacePayload()
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Natash Gupta22\",\r\n" + 
				"  \"phone_number\": \"(+91) 1234567890\",\r\n" + 
				"  \"address\": \"Kajupada, Mumbai\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String getUpdateAddress(String key, String value)
	{
		return "{\r\n" + 
				"\"place_id\":\""+key+"\",\r\n" + 
				"\"address\":\""+value+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	
	/*
	 * when we do not have actual Json response or API is still in under
	 * development. so in that case, Mock Data/ Dummy Data is used.
	 */
	public static String mockJsonCourseDetailsResponse()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 910,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}
	
}
