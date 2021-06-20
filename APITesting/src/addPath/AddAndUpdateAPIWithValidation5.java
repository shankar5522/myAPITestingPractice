package addPath;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resource.Payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

//here we are adding and updating the same API for the address details.
public class AddAndUpdateAPIWithValidation5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		//TO add the API
		String response = given()
			.queryParam("key", "qaclick123")
			.header("content-type", "application/json")
			.body(Payload.getAPIAddPlacePayload())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
		
		System.out.println("Extracted Response : " + response);
		
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		System.out.println("Extrated JSOn path for PlaceID response : " + placeID);

		//TO update the API and verify as well.
		given().log().all()
			.queryParam("key", "qaclick123")
			.header("content-type", "application/json")
			.body(Payload.getUpdateAddress(placeID, "Shankar Update Address"))
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
			.body("msg", equalTo("Address successfully updated"));
			
		// TO get the updated Details.
		String updatedResponse = given()
			.queryParam("key", "qaclick123")
			.queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat()
			.statusCode(200)
			.body("address", equalTo("Shankar Update Address"))
			.extract().response().asString();
		
		JsonPath updatedJS = new JsonPath(updatedResponse);
		String updatedAddress = updatedJS.getString("address");
		Assert.assertEquals(updatedAddress, "Shankar Update Address");
		
	}

}
