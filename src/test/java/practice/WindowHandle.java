package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		

		//enter string in search box

		driver.findElement(By.xpath("//div[@class='wikipedia-searchtable']//input[contains(@class,'input')]")).sendKeys("selenium");
		driver.findElement(By.xpath("//div[@class='wikipedia-searchtable']//input[contains(@class,'button')]")).click();
		List <WebElement> result=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));

		for(int i=0;i<1;i++) {
			result.get(i).click();
		}
		
		//Get window ids
		Set<String> windowids=driver.getWindowHandles();
		Thread.sleep(5000);
		
		//switch windows
		
		//approach 1
		
		/*for(String id:windowids) {
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("Selenium - Wikipedia")|| title.equals("Selenium in biology - Wikipedia")) {
				driver.close();
			}
		}	
		*/
		
		//approach 2
		
		/*List <String>arraylist=new ArrayList<String>(windowids);
		String childwindow=arraylist.get(1);
		driver.switchTo().window(childwindow);
		driver.findElement(By.name("search")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.switchTo().window(arraylist.get(0));
		driver.close();
		*/
		
		
		
		
				
		
		
	}

}
