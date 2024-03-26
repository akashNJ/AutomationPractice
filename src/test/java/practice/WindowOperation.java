package practice;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowOperation {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println(logo.getLocation());
		
		driver.manage().window().minimize();
		System.out.println(logo.getLocation());
		
		driver.manage().window().fullscreen();
		System.out.println(logo.getLocation());
		
		Point p=new Point(100,100);
		driver.manage().window().setPosition(p);
		System.out.println(logo.getLocation());

	}

}
