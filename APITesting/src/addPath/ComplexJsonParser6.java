package addPath;

import io.restassured.path.json.JsonPath;
import resource.Payload;

public class ComplexJsonParser6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(Payload.mockJsonCourseDetailsResponse());

		// 1. Print No of courses returned by API
		int numberOfCourses = js.getInt("courses.size()");
		System.out.println("NO of Courses : " + numberOfCourses);

		// 2.Print Purchase Amount
		int totalPurchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount : " + totalPurchaseAmt);

		// 3. Print Title of the first & third course
		String firstTitleCourse = js.getString("courses[0].title");
		String thirdTitleCourse = js.getString("courses[2].title");
		System.out.println("1st and 3rd Course Title is : " + firstTitleCourse + " and " + thirdTitleCourse);

		// 4. Print All course titles and their respective Prices
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("Course Size : " + noOfCourses);

		String courseName;
		int coursePrice;
		for (int i = 0; i < noOfCourses; i++) {
			courseName = js.getString("courses[" + i + "].title");
			coursePrice = js.getInt("courses[" + i + "].price");
			System.out.println((i + 1) + " Course Name and Price are " + courseName + " and " + coursePrice);
		}

		// 5. Print no of copies sold by RPA Course
		int courseSize = js.getInt("courses.size()");
		System.out.println("5 Course Size : " + courseSize);
		String course;
		int copy;
		for (int i = 0; i < courseSize; i++) {
			course = js.getString("courses[" + i + "].title");
			 if(course.equalsIgnoreCase("RPA"))
			 { 
				 copy = js.getInt("courses[" + i +"].copies");
				 System.out.println("Sold Copy for RPA is : " + copy);
				 break;
			 }
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		System.out.println("Total Purchase Amount : " + totalPurchaseAmt);
		int coursePrices, copies, coursePriceCopies, sum=0;
		for (int i = 0; i < noOfCourses; i++) {
			coursePrices = js.getInt("courses[" + i + "].price");
			copies = js.getInt("courses[" + i + "].copies");
			coursePriceCopies = (coursePrices*copies);
			sum = sum + coursePriceCopies;
		}
		System.out.println("Value of All the Course : " + sum);
		if(sum == totalPurchaseAmt)
		{
			System.out.println("Validation Pass");
		}
		else
		{
			System.out.println("Validation Failed");
		}

	}

}
