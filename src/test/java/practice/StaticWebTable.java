package practice;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//count number of row in table
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//System.out.println(rows);
		
		//count number of columns in table
		
		int column=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		//System.out.println(column);
		
		//read specific row and column data
		
		String text=driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
		//System.out.println(text);
		
		//read data from all rows and columns
		
		/*System.out.println("BookName"+" "+"Author"+" "+"Subject"+" "+"Price");
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=column;c++) {
				String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		*/
		
		//print book name whose author name is amod
		
		String book_name=driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
		System.out.println(book_name);
		
		//find sum of prices of all the books
		
		int sum=0;
		for(int r=2;r<=rows;r++) {
				String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
				sum=sum+Integer.parseInt(price);
		}
		System.out.println(sum);
		
		
	}

}
