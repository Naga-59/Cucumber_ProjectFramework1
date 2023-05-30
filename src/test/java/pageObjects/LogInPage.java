package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver driver){
		super(driver);
	}
	
	//username
		@FindBy(xpath="//input[@id='user-name']")
		WebElement user;
		
		//password
		@FindBy(xpath="//input[@id='password']")
		WebElement pass;
		
		//submit button
		@FindBy(xpath="//input[@id='login-button']")
		WebElement button;
		
		//Login_log
		@FindBy(xpath="//div[@class='login_logo']")
		WebElement logo;
		
		
		//title
		@FindBy(xpath="//title[contains(text(),'Swag Labs')]")
		WebElement title;
		
		//Actions
		
		public void username(String ur) {
			user.sendKeys(ur);
		}
		
		public void password(String pas) {
			pass.sendKeys(pas);
		}
		
		public void submitButton() {
			button.click();
		}
		
		public boolean logos() {
			boolean logo_result=logo.isDisplayed();
			return logo_result;
		}
		
		public String text_title() {
			String text=title.getText();
			return text;
		}
		
		
		
		public boolean logInLog() {
			boolean l_logo=logo.isDisplayed();
			return l_logo;
		}
	
	
}
