package g_serialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class A_SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B_MainSerlizationPOJOClass obj = new B_MainSerlizationPOJOClass();
		obj.setAccuracy(50);
		obj.setName("Shankarlal GUpta");
		obj.setPhone_number("(+91) 865 541 3053");
		obj.setAddress("Kajupada, Behram-baug, jogeshwari(W)");
		obj.setWebsite("http://google.com");
		obj.setLanguage("French-IN");
		
		List<String> listTypes = new ArrayList<String>();
		listTypes.add("shoe park");
		listTypes.add("shop");
		obj.setTypes(listTypes);
		
		C_LocationSerlizationPOJO locationOjb = new C_LocationSerlizationPOJO();
		locationOjb.setLat(-38.383494);
		locationOjb.setLng(33.427362);
		obj.setLocation(locationOjb);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").log().all().
		body(obj).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
		
		System.out.println("RESPONSE " + response);

	}

}
