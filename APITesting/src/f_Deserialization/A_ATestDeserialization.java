package f_Deserialization;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import d_resource.Payload;

public class A_ATestDeserialization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D://Jar//driver//chromedriver_win32//chromedriver.exe"); WebDriver driver=
		 * new ChromeDriver(); driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss"
		 * ); driver.findElement(By.cssSelector("[type='email']")).sendKeys(
		 * "shankargupta5522@gmai.com");
		 * driver.findElement(By.cssSelector("[type='email']")).sendKeys(Keys.ENTER);
		 * Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("[type='password']")).sendKeys(
		 * "Shankar5522");
		 * driver.findElement(By.cssSelector("[type='password']")).sendKeys(Keys.ENTER);
		 * Thread.sleep(5000); String url=driver.getCurrentUrl();
		 * System.out.println(url); String partialcode=url.split("code=")[1]; String
		 * code=partialcode.split("&scope")[0]; System.out.println(code);
		 */
		 

		/*
		 * Get the code by hitting the URL in incognizone mode from above driver.get() method and login with
		 * your email id and password and next blank page will open then get the code
		 * from their
			https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss
		 */
		String code = "4%2F0AY0e-g6tZgvZYvy1ULsJO4jOIo73UUy1qu9BMKlHrsPRTqoUnIwQGriksbrIPPlqTw93tw";
		String response = given().urlEncodingEnabled(false).queryParams("code", code)

				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("grant_type", "authorization_code").queryParams("state", "verifyfjdss")
				.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
				when().log().all()
					.post("https://www.googleapis.com/oauth2/v4/token").asString();
	
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);
		
		
		
		A_MainPOJOClass getDetailsObject = given()
					.queryParams("access_token", accessToken)
					.expect().defaultParser(Parser.JSON).		// Tell the Rest Assured in which format you need the response for the serlization					
				when().get("https://rahulshettyacademy.com/getCourse.php") //.log().all() method won't support if using the defaultParser(Parser.JSON)
					.as(A_MainPOJOClass.class);                // this process is call as Serilization as set the data into POJO class
		
		// this process is call as De-Serilization as get the data into POJO class
		System.out.println("LinkedIn from the Main POJO Class : " + getDetailsObject.getLinkedIn());
		
		//we need 1st index title of course from Array
		System.out.println("Get the Course Title from 1st Index : " + getDetailsObject.getCourses().getApi().get(1).getCourseTitle());		
	
		//get the price of Coursr Title having "Soap......"
		List<B2_APIGetCoursePOJOClass> apiObject = getDetailsObject.getCourses().getApi();
		String courseTitle, price;
		for(int i=0; i<(apiObject.size()); i++)
		{
			courseTitle = apiObject.get(i).getCourseTitle();
			if(courseTitle.equalsIgnoreCase("soapui webservices testing"))
			{
				price = apiObject.get(i).getPrice();
				System.out.println("Price of SOAP course : " + price);
			}
		}
		
		//print all the course title of Webautomation course
		System.out.println("Web Automation COurse Title are : ");
		List<B1_WebAutomationGetCoursePOJOClass> listwebAutomation = getDetailsObject.getCourses().getWebAutomation();
		String webAutomationCourseTitle;
		for(int i=0; i<(listwebAutomation.size()); i++)
		{
			webAutomationCourseTitle = listwebAutomation.get(i).getCourseTitle();
			System.out.print(webAutomationCourseTitle + ", ");
		}
		
	}

}
