package Demo.Demo;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class Sample {

	public static void main(String[] args) {
		
		
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();

			// Make a request to the server by specifying the method Type and the method URL.
			// This will return the Response from the server. Store the response in a variable.
			//Response response = httpRequest.request(Method.GET, "/Chennai");

			// Now let us print the body of the message to see what response
			// we have recieved from the server
			//String responseBody = response.getBody().asString();
			//System.out.println("Response Body is =>  " + responseBody);
			
			Response response = httpRequest.get("/Hyderabad");
			
			String contentType = response.header("Content-Type");
			
			System.out.println("Content Type Value: " + contentType);
			
			String serverType = response.header("Server");
			
			System.out.println("Server Value: " + serverType);
			
			String contentEncoding = response.header("Content-Encoding");
			
			System.out.println("Content-Encoding Value: " + contentEncoding);
			
			int statusCode = response.getStatusCode();
			
			System.out.println("status code is equal to" + statusCode);
			Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);

			ResponseBody body = response.getBody();
					
			System.out.println("Response Body is = " + body.asString());		
						
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sachi\\Desktop\\chromedriver.exe");

			  WebDriver driver = new ChromeDriver();
			  driver.get("http://www.google.com/xhtml");
			  //Thread.sleep(5000);  // Let the user actually see something!
			  WebElement searchBox = driver.findElement(By.name("q"));
			  searchBox.sendKeys("ChromeDriver");
			  searchBox.submit();
			  //Thread.sleep(5000);  // Let the user actually see something!
			  //driver.quit();
					
	}

}
