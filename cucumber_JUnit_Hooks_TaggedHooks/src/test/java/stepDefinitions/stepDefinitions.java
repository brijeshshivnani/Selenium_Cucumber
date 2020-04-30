package stepDefinitions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import cucumber.api.java.After;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import cucumber.api.java.Before;


public class stepDefinitions {
	static WebDriver driver;
	
	@Before("@FirstTest")
	public void setup() {
		System.setProperty("webdriver.chrome.driver","src//main/chromedriver");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get("https://www.just-eat.co.uk");
		 
	}
	
	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String url) throws Throwable {


	}

	@Given("^I want food in \"([^\"]*)\"$")
	public void i_want_food_in(String postcode) throws Throwable {
		 driver.findElement(By.name("postcode")).sendKeys(postcode);
//		 driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(postcode);
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String postcode) throws Throwable {
		WebElement abc = driver.findElement(By.xpath("(//h1[@class='c-locationHeader-title'])[1]"));
		String actualPostcode = abc.getText();
		System.out.println(">>>>"+ actualPostcode);
		assertTrue(actualPostcode.contains(postcode));
//		assert.assertEquals(driver.findElement(By.xpath("//h1[@class='c-locationHeader-title']")).getText(),postcode);
		String restaurant_count = driver.findElement(By.xpath("//span[@data-search-count='openrestaurants']")).getAttribute("data-search-count-orig");
		assertFalse(restaurant_count.equalsIgnoreCase("0"));
	}
	
	@After
	public void tearDown() {
	    driver.quit();
	}

	
	 @Given("^this is the first step$")
	 public void This_Is_The_First_Step(){
	 System.out.println("This is the first step");
	 }
	 
	 @When("^this is the second step$")
	 public void This_Is_The_Second_Step(){
	 System.out.println("This is the second step");
	 }
	 
	 @Then("^this is the third step$")
	 public void This_Is_The_Third_Step(){
	 System.out.println("This is the third step");
	 }


}
