package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		Thread.sleep(5000);
		
		//isDisplayed method
		WebElement log=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println(log.isDisplayed());
		
		//isEnabled method
		WebElement txtsearch=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(txtsearch.isEnabled());
		
		//isSelected method
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		WebElement male_rdbtn=driver.findElement(By.xpath("//input[@id='gender-male']"));
		System.out.println(male_rdbtn.isSelected());
		
		System.out.println("after selection...........");
		male_rdbtn.click();
		System.out.println(male_rdbtn.isSelected());
		
		driver.quit();
		
	}

}
