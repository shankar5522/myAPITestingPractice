package addPath;

import io.restassured.RestAssured;
import resource.Payload;

import static io.restassured.RestAssured.*;		//add package manually for given, when & then
import static org.hamcrest.Matchers.*;			//add package manually for equalTo method comparision.

//Just adding/ creating a new request with some response level validation 
public class addAPIAddPlaceDataPayloadFromAnotherClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().
			queryParam("key", "qaclick123").
			header("Content-Type", "application/json").
			body(Payload.getAPIAddPlacePayload())	// here getting the Json data from Payload class
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat()
			.statusCode(200)
			.body("scope", equalTo("APP"))	// equalTo - check whether response body has "AAP" in scope.
			.header("Server", "Apache/2.4.18 (Ubuntu)").header("Content-Length", "194");	// checking whether response coming from correct server.
		
	}

}
