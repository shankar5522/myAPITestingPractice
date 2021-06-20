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
	
}
