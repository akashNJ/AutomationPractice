package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPageWithJS {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		//scroll down action
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000);");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(3000);
		
		//full scroll down action
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(3000);
		
		
		//scroll upto exact element
		WebElement button=driver.findElement(By.xpath("//input[@id='datepicker']"));
		js.executeScript("arguments[0].scrollIntoView();", button);
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(3000);
		
		//full scroll up action
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
	
		

	}

}
