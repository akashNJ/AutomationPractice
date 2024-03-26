package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//label[text()='Job Title']//following::i[1]")).click();
		driver.findElement(By.xpath("//span[text()='Chief Financial Officer']")).click();
		
		//success message
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		driver.findElement(By.name("firstName")).sendKeys("test");
		driver.findElement(By.name("lastName")).sendKeys("test");
		driver.findElement(By.xpath("//label[text()='Employee Id']//following::input[@class='oxd-input oxd-input--active']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String toast_message=driver.findElement(By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']/p[contains(@class,'message')]")).getText();
		String str="Successfully Saved";
		if(toast_message.equals(str)) {
			System.out.println("test is passed");
		}
		else {
			System.out.println("test is failed");
		}
		
		driver.quit();
	}

}
