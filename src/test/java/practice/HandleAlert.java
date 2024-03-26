package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlert {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		//switch to alert

		/*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

		//example 1
	 	//using implicit wait
	 	 
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());

		//using switch to method
		 
		//Alert alertwindow=driver.switchTo().alert();

		System.out.println(alertwindow.getText());

		//accept method
		//alertwindow.accept();

		//dismiss method
		//alertwindow.dismiss();
		 */

		//example 2
		
		//using implicit wait
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
		
		alertwindow.sendKeys("welcome");
		//alertwindow.accept();		
		
		alertwindow.dismiss();
		
		String act_text=driver.findElement(By.id("result")).getText();
		
		if(act_text.contains("welcome")) {
			System.out.println("test is passed");
		}
		else {
			System.out.println("test is failed");
		}



	}

}
