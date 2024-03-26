package practice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class LocatorExample {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		Thread.sleep(5000);

		/*//id locator
		driver.findElement(By.id("search_query_top")).sendKeys("t shirt");

		//name locator
		driver.findElement(By.name("submit_search")).click();

		//link text or partial link text
		//driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.partialLinkText("Sign")).click();
		*/
		
		//class name locator...find number of images
		List<WebElement> images=driver.findElements(By.className("item-img"));
		System.out.println(images.size());
		
		//tag name locator..find number of links
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		//close browser
		driver.quit();
		

		






	}

}
