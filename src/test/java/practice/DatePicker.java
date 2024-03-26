package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);

		//approach 1
		//driver.findElement(By.id("datepicker")).sendKeys("03/12/2024");

		//approach 2
		driver.findElement(By.id("datepicker")).click();
		

		String mon="December";
		String yr="2025";
		String dt="10";

		while(true) {
			String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement date:dates) {

			if(date.getText().equals(dt)) {
				date.click();
			}
		}



	}

}
