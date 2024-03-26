package testngpractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
XML - Parallel testing

step1) create test case
step 2) create xml file to run the test
step3) pass browser name parameter from the xml to setup() method
step4 ) execute test case on chrome & edge ( serial execution)
step5 ) execute test case on chrome & edge ( parallel execution)
 */


public class ParallelTestingDemo {


	WebDriver driver;
	@BeforeClass
	@Parameters({"Browser"})
	void setUp(String br) throws InterruptedException {
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test
	void testLogo() {
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}


}
