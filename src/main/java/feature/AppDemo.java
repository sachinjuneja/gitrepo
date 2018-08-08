package feature;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AppDemo {
  @Given("^I want to open Google site$")
  public void open_google_page () {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sachi\\Desktop\\chromedriver.exe");
 
  }

  @When("^I open url$")
  public void search_text() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.google.com/xhtml");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("ChromeDriver");
	  searchBox.submit();
  }
}