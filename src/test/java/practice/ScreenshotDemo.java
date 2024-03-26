package practice;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		//full page screenshort
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\AKAJADHA\\eclipse-workspace\\AutomationProject\\screenshots\\main.png");
		Files.copy(src, trg);
		 */

		//element screenshot\

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		File src=logo.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\AKAJADHA\\eclipse-workspace\\AutomationProject\\screenshots\\logo.png");
		Files.copy(src, trg);
		Thread.sleep(5000);
		driver.quit();
	}

}
