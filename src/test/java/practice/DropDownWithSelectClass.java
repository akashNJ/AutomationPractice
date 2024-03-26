package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithSelectClass {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		WebElement drpdwn=driver.findElement(By.id("country-list"));
		Select drp=new Select(drpdwn);
		
		//using selectByVisibleText method
		//drp.selectByVisibleText("India");
		
		//selectByValue method
		//drp.selectByValue("2");
		
		//selectByIndex method
		drp.selectByIndex(5);
		
		Thread.sleep(5000);
		driver.quit();
	}

}