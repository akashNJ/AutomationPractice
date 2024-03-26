package practice;

import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(5000);

		//get title method
		System.out.println(driver.getTitle());

		//get url method
		System.out.println(driver.getCurrentUrl());

		//get page source method
		//System.out.println(driver.getPageSource());
		
		//get window handle method
		//System.out.println(driver.getWindowHandle());
		
		//get window handles method
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Thread.sleep(5000);
		/*Set<String> windowids=driver.getWindowHandles();
		
		for(String x:windowids) {
			System.out.println(x);
		}
		*/
		
		//close method
		//driver.close();
		
		//quite method
		driver.quit();
		
		







	}

}
