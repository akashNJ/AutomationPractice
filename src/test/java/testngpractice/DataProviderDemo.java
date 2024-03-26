package testngpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {

	WebDriver driver;
	@BeforeClass
	void setUp() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregisterresult%2F1");
		driver.manage().window().maximize();
	}

	@Test (dataProvider="dp")
	void login(String mail, String pwd) throws InterruptedException {
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Email")).sendKeys(mail);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Thread.sleep(5000);
		String exp_title="nopCommerce demo store. Register";
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name="dp")
	String[][] data() {
		String [][] data={ 
				{"akash","jadhav"},
				{"abc","123"},
				{"akashj@gmail.com","akashj"}};
		return data;
	}


}
