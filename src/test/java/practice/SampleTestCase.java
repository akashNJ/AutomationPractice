package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestCase {

	public static void main(String[] args) throws InterruptedException {

		//Launching the browser

		WebDriver driver=new ChromeDriver();

		//maximize the page

		driver.manage().window().maximize();

		//open URL on browser
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//enter username and password
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		//click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		//validation
		String act_label = "";
		try {
			act_label=driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6")).getText();
		}
		catch(NoSuchElementException e) {
			System.out.println("entered into catch block");
		}
		String exp_label="Dashboard";

		if(act_label.equals(exp_label)) {
			System.out.println("test is passed");
		}
		else {
			System.out.println("test is failed");
		}

		//closing the browser
		driver.quit();
	}

}
