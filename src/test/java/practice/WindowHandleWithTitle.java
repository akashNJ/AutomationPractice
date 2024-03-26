package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleWithTitle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("newTabBtn")).click();

		Set<String> windowids=driver.getWindowHandles();
		for(String id:windowids) {
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("AlertsDemo - H Y R Tutorials")) {
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='bmc-btn']")).click();

		Set<String> newids=driver.getWindowHandles();
		for(String id:newids) {
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("Yadagiri Reddy is Content Creator | Technical Blogger | YouTuber")) {
				break;

			}

		}
		driver.findElement(By.xpath("//input[@placeholder='Name or @yoursocial']")).sendKeys("welcome");
		Thread.sleep(3000);
		driver.close();

		for(String id:newids) {
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("AlertsDemo - H Y R Tutorials")) {
				driver.close();
				break;	
			}
		}


	}

}
