package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandling {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.name("mytext3")).sendKeys("abc");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()='I am a human']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.name("mytext3")).sendKeys("123");
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.name("mytext1")).sendKeys("welcome");
		

	}

}
