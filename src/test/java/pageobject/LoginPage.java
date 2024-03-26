package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (name="username") WebElement txt_username;

	public void setUserName() {
		txt_username.sendKeys("Admin");
	}





}
