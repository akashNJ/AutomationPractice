package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		//first window id
		String first_window=driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();

		Set<String> windowids=driver.getWindowHandles();
		String second_window="";
		for(String id:windowids) {
			if(!id.equals(first_window)) {
				driver.switchTo().window(id);
				second_window=id;
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='bmc-btn']")).click();
		
		Set<String> new_windows=driver.getWindowHandles();
		for(String id:new_windows) {
			if(!id.equals(first_window) && !id.equals(second_window)) {
				driver.switchTo().window(id);
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//input[@placeholder='Name or @yoursocial']")).sendKeys("welcome");
		driver.switchTo().window(second_window);
		driver.close();
		
		

	}

}
