package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorExample {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(5000);

		//tag and id selector

		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("macbook");

		//tag and class selector
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("macbook");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='q']")).clear();

		//tag and attribute selector
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='q']")).clear();
		
		//tag, class and attribute selector
		
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("computer");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='q']")).clear();
		
		
		//close browser
		Thread.sleep(2000);
		driver.quit();



	}

}
