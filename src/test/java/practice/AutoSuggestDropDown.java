package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> options=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']//span"));
		System.out.println("number of options:"+options.size());
		
		for(WebElement option:options) {
			String text=option.getText();
			if(text.equals("selenium dev")) {
				option.click();
				break;
			}
		}
		

	}

}
