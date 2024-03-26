package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksDemo {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int broken_links=0;
		for(WebElement link:links) {
			String hrefattr=link.getAttribute("href");
			if(hrefattr.equals(null) || hrefattr.equals("") ) {
				System.out.println("href attribute value is empty for:"+link.getText());
				continue;
			}
			
			//open connection and connect to server
			URL ul=new URL(hrefattr);
			URLConnection con = ul.openConnection();
			
			//type casting
			HttpURLConnection http=(HttpURLConnection)con;
			int code=http.getResponseCode();
			if(code>=400) {
				System.out.println(link.getText()+" "+hrefattr+"===>"+" "+"is broken link");
				broken_links++;
			}
			else {
				System.out.println(link.getText()+" "+hrefattr+"===>"+" "+"is not broken link");
			}
			
		}
		
		

	}

}
