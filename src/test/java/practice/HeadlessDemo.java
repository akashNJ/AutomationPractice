package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
Headless testing - without UI , we can execute test cases backend.
Advantage: faster execution/performance is good
Disadvantage: we can't explore the functionality/ we can't see the actions/validations.
 */
public class HeadlessDemo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless=new");

		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
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

		driver.quit();
	}

}
