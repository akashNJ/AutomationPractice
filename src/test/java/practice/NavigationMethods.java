package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//navigate-to method
		URL url=new URL("https://www.amazon.in/");
		driver.navigate().to(url);
		
		//navigate back method
		driver.get("https://www.flipkart.com/");
		driver.navigate().back();
		
		//navigate forward method
		driver.navigate().forward();
		
		//refresh page
		driver.navigate().refresh();
		

		Thread.sleep(5000);
		
		driver.quit();
		
		

	}

}
