package addPath;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resource.Payload;

import static io.restassured.RestAssured.*;		//add package manually for given, when & then
import static org.hamcrest.Matchers.*;			//add package manually for equalTo method comparision.

//Just adding/ creating a new request with some response level validation 
public class extractJsonResponseInString4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().
				queryParam("key", "qaclick123").
				header("content-type", "application/json").
				body(Payload.getAPIAddPlacePayload())	// here getting the Json data from Payload class
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat()
			.statusCode(200)
			.header("Server", "Apache/2.4.18 (Ubuntu)").header("Content-Length", "194")	// checking whether response coming from correct server.
			.body("scope", equalTo("APP"))	// equalTo - check whether response body has "AAP" in scope.
			.extract().response().asString();
		
		System.out.println("Stored Response : " + response);
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		System.out.println("Extracted Response Place ID : " + placeID);
		
		/*
		 * Here lat path for getString is location.lat { "location": { "lat":
		 * -38.383494, "lng": 33.427362 }, "accuracy": 50, "name": "Natash Gupta22",
		 * "phone_number": "(+91) 1234567890", "address": "Kajupada, Mumbai", "types": [
		 * "shoe park", "shop" ], "website": "http://google.com", "language":
		 * "French-IN" }
		 */

	}

}
