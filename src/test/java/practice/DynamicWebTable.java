package practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();

		//login

		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(5000);

		//handle human verification
		try{
			driver.findElement(By.xpath("//h1[text()='demo.opencart.com']"));
			WebElement frame = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Widget containing a Cloudflare security challenge']")));
			driver.switchTo().frame(frame);
			////span[text()='Verify you are human']
			//input[type='checkbox']
			//WebElement checkbox = mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
			Actions action= new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("input[type='checkbox']"))).click().build().perform();
			driver.switchTo().defaultContent();
		}
		catch(NoSuchElementException e) {
			System.out.println( "I am not a robot page is not visible");
		}

		//handle pop-up
		Thread.sleep(10000);
		WebElement btn_close = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-close']")));
		btn_close.click();		

		//handle web table
		driver.findElement(By.xpath("//li[@id='menu-sale']")).click();
		driver.findElement(By.xpath("//ul[@class='collapse show']//a[text()='Orders']")).click();

		boolean next_page=true;
		int page_count=1;

		while(next_page) {
			int row=driver.findElements(By.xpath("//table[contains(@class,'table')]/tbody/tr")).size();
			for(int r=1;r<=row;r++) {
				String customer=driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody/tr["+r+"]//td[4]")).getText();
				String status=driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody/tr["+r+"]//td[5]")).getText();
				System.out.println(customer+"  "+status);
			}
			try {
				page_count++;
				WebElement page=driver.findElement(By.xpath("//li[@class='page-item']//a[text()='"+page_count+"']"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", page);
				Thread.sleep(3000);
			}
			catch(NoSuchElementException e) {
				next_page=false;
			}
		}
		
		driver.quit();
		
		
	}
}
