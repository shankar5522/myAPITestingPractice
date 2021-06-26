package b_dynamicjson;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

// Here passing the data from file i.e from external source.
public class PassingJsonAsFile2 {

	@Test
	public void passJsonViaFileInsteadOfPayload() throws IOException
	{
		//Convert File into Byte then Byte to String because we need to pass the Josn data in the String format in a body
		String filePath = "C:\\Users\\SG0310417\\git\\myAPITestingPractice\\APITesting\\src\\dynamicjson\\ExternalJsonFile2.json";
		Path path = Paths.get(filePath);
		byte byteFile[] = Files.readAllBytes(path);
		System.out.println("Coverted JSON to String Data : " + byteFile);
		
		//String jsonData = byteFile.toString();  // no, don't do this, it returns the address of the object in memory
		String jsonData = new String(byteFile, StandardCharsets.UTF_8);
		System.out.println("Coverted JSON to String Data : " + jsonData);
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().
			queryParam("key", "qaclick123").
			header("Content-Type", "application/json").
			body(jsonData)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);

	}
	
}
