package testngpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(testngpractice.ExtentReportListener.class)
public class ExtentReportDemo {

	WebDriver driver;
	@Test (priority=1)
	void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test (priority=2)
	void testLogo() {
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Test (priority=3)
	void tearDown() {
		driver.quit();
	}
}
