package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
JavaScriptExecutor  --- Interface

executeScript() -->  
we can execute java script statemetns in selenium using this method

 */

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		JavascriptExecutor  js=(JavascriptExecutor)driver;
		WebElement txt_name=driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value','testuser');",txt_name );

		WebElement male_rd=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click();",male_rd );

		WebElement check_box=driver.findElement(By.xpath("//input[@id='sunday']"));
		js.executeScript("arguments[0].click();", check_box);

		WebElement button=driver.findElement(By.xpath("//button[@onclick='myFunctionConfirm()']"));
		js.executeScript("arguments[0].click();", button);
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(3000);
		al.accept();

		driver.quit();
	}

}
