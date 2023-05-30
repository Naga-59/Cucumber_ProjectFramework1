package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {
	public LogOutPage(WebDriver driver){
		super(driver);
	}
	
	//logout option
		@FindBy(xpath="//button[@id='react-burger-menu-btn']")
		WebElement option;
		
		//logout button
		@FindBy(xpath="//a[@id='logout_sidebar_link']")
		WebElement button;
		
		//home_logo
				@FindBy(xpath="//div[@class='app_logo']")
				WebElement home_logo;
		
		public void logoutOption() {
			option.click();
		}
		
		//button
		public void logOutButton() {
			button.click();
		}
		
		//home logo
		public boolean home_logos() {
			boolean logo_home=home_logo.isDisplayed();
			return logo_home;
		}

}
