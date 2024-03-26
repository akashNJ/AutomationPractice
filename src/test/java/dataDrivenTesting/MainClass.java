package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		String fileName=System.getProperty("user.dir")+"\\testdata\\DataDriven.xlsx";
		int row_count=ExcelUtility.getRowCount(fileName, "sheet1");
		int cell_count=ExcelUtility.getCellCount(fileName, "sheet1", 0);

		for(int r=1;r<=row_count;r++) {
			String username=ExcelUtility.getData(fileName, "sheet1", r, 0);
			String password=ExcelUtility.getData(fileName, "sheet1", r, 1);

			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(password);
			Thread.sleep(3000);
			String exp=driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value");
			driver.findElement(By.xpath("//input[@id='name']")).clear();
			driver.findElement(By.xpath("//input[@id='email']")).clear();
			if(username.equals(exp)) {
				ExcelUtility.setData(fileName, "sheet1", r, 2, "passed");	
			}

		}

		driver.quit();





	}

}
