package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select single checkbox
		
		//driver.findElement(By.xpath("//input[@id='wednesday']")).click();
		
		//select multiple checkbox
		
		List <WebElement>checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		/*for(WebElement checkbox:checkboxes) {
			checkbox.click();
		}
		*/
		
		//Select first 3 checkboxes
		
		for(int i=0;i<3;i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		//unselect first 3 checkboxes
		for(int i=0;i<checkboxes.size();i++) {
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
		
		
		
	}

}
