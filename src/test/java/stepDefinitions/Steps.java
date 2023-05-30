package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LogInPage;
import pageObjects.LogOutPage;

public class Steps {
	//driver
	WebDriver driver;
	
	//log4j
	Logger logger;
	
	//common properties
	ResourceBundle rb;
	String br;
	
	//loginpage
	LogInPage lp;
	
	//logoutpage
	LogOutPage lo;
	
	@Before
	public void setup() {
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("scenario status ===>"+scenario.getStatus());
		if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		logger.info("***browser launching ***");
	    if(br.equalsIgnoreCase("chrome")) {
	    	driver=new ChromeDriver();
	    }
	    else if(br.equalsIgnoreCase("edge")) {
	    	driver=new EdgeDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@Given("Opens URL {string}")
	public void opens_url(String url) {
	    logger.info("*** URL Is launching***");
		driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enter valid Username as {string}")
	public void user_enter_valid_username_as(String user) {
	    logger.info("*** Username Entered ***");
		lp=new LogInPage(driver);
	    lp.username(user);
	    
	}

	@When("User enter the valid Password as {string}")
	public void user_enter_the_valid_password_as(String pass) {
		logger.info("*** Password Entered ***");
		lp.password(pass);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		
		lp.submitButton();  
		logger.info("*** successfully submitted the loginbutton ***");
		
	}
 
	@Then("User navigates to Main page")
	public void user_navigates_to_main_page() {
	    lo=new LogOutPage(driver);
	    boolean applogo=lo.home_logos();
	    Assert.assertEquals(true, applogo);
	    logger.info("*** successfully entered the app page ***");
		
	    lo.logoutOption();
	    lo.logOutButton();
	    boolean loginlogo=lp.logos();
	    Assert.assertEquals(true, loginlogo);
	    logger.info("*** successfully logout the app ***");
		
	}
}
