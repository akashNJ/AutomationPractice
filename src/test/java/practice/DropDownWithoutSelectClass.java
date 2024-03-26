package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelectClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
		
		//print all dropdown elements
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//label[@class='checkbox']"));
		System.out.println(options.size());
		
		for(WebElement option:options) {
			String text=option.getText();
			if(text.equals("MySQL")) {
				option.click();
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
