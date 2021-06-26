package c_getPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;		//add package manually for given, when & then

public class getAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//take the query -> place_id from addAPI.java
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123").queryParam("place_id", "9d8e3576a5a98e6a7b39766e9c6ae8ec")
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);

	}

}
