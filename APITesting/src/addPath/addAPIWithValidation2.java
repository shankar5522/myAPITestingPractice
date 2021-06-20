package addPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;		//add package manually for given, when & then
import static org.hamcrest.Matchers.*;			//add package manually for equalTo method comparision.

//Just adding/ creating a new request with some response level validation 
public class addAPIWithValidation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().
			queryParam("key", "qaclick123").
			header("Content-Type", "application/json").
			body("{\r\n" + 
					"  \"location\": {\r\n" + 
					"    \"lat\": -38.383494,\r\n" + 
					"    \"lng\": 33.427362\r\n" + 
					"  },\r\n" + 
					"  \"accuracy\": 50,\r\n" + 
					"  \"name\": \"Neha Gupta2222\",\r\n" + 
					"  \"phone_number\": \"(+91) 1234567890\",\r\n" + 
					"  \"address\": \"Kajupada, Mumbai\",\r\n" + 
					"  \"types\": [\r\n" + 
					"    \"shoe park\",\r\n" + 
					"    \"shop\"\r\n" + 
					"  ],\r\n" + 
					"  \"website\": \"http://google.com\",\r\n" + 
					"  \"language\": \"French-IN\"\r\n" + 
					"}\r\n" + 
					"")
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat()
			.statusCode(200)
			.body("scope", equalTo("APP"))	// equalTo - check whether response body has "AAP" in scope.
			.header("Server", "Apache/2.4.18 (Ubuntu)").header("Content-Length", "194");	// checking whether response coming from correct server.
		
	}

}
