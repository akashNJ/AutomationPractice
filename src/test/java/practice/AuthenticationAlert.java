package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//use injection method to handle this type of alert
		// https://admin:admin@the-internet.herokuapp.com/basic_auth
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		String act_text=driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		String exp_text="Congratulations! You must have the proper credentials.";
		
		if(act_text.equals(exp_text)) {
			System.out.println("test is passed");
		}
		else {
			System.out.println("test is failed");
		}

	}

}
