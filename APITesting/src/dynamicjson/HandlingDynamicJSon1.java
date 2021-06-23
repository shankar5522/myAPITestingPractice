package dynamicjson;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resource.Payload;

import static io.restassured.RestAssured.*;

//Udemy - Section 7 i.e s

public class HandlingDynamicJSon1 {
	
	@Test(dataProvider = "getBookData")
	public void addBook(String isbn, String aisle)
	{
		//1 - Dynamic of passing the data in a body - Payload.addBook
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all()
			.header("content-type", "application/json")
			.body(Payload.addBook(isbn, aisle)).
		when()
			.post("/Library/Addbook.php").
		then().log().all()
			.assertThat().statusCode(200)
			.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String bookId = js.getString("ID");
		System.out.println("ID for the book " + bookId);	
	}
	
	@DataProvider
	public Object[][] getBookData()
	{
		return new Object[][] {{"abc", "4523"}, {"pqr","4544654"}, {"xyz", "3454645"}};
	}
	
}
