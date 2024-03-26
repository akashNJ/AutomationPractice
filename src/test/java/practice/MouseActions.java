package practice;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*Mouse hover  -	 moveToElement(Element)
Right click      -  contextClick(Element)
Double click  - doubleClick(Element)
Drag and drop - dragAndDrop()
slider --- dragAndDropBy(Element, x,y);


Actions - class provided by selenium webdriver.

build() - create an action
perform() - can complete the action


<input  id='abc' > testing</input>      testing - inner text
findElement(Loc).getText()  ----- testing
findElement(Loc).getAttribute('value')   - return nothing

<input id='abc' value='testing' />       no innertext
findElement(Loc).getText()   - return nothing
findElement(Loc).getAttribute('value') --- testing


getText() --- returns inner text of the element

getAttribute("value") --- testing
getAttribute("id") ------ abc

build().perform()
perfom()
 */

public class MouseActions{

	public static void main(String[] args) throws InterruptedException {

		//mouse hover

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		WebElement desktop=driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[text()='Mac (1)']"));

		Actions act=new Actions(driver);
		//act.moveToElement(desktop).moveToElement(mac).click().build().perform();
		act.moveToElement(desktop).moveToElement(mac).click().perform();
		 */

		//right click

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act=new Actions(driver);
		act.contextClick(button).perform();
		 */		 


		//double click

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		Thread.sleep(5000);
		driver.navigate().refresh();
		driver.manage().window().maximize();


		WebElement frame=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("welcome");
		WebElement button=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions act=new Actions(driver);		
		act.doubleClick(button).perform();
		String field2=driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");

		if(field2.equals("welcome")) {
			System.out.println("test is passed");
		}
		else {
			System.out.println("test is failed");
		}
		 */


		//drag and drop

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();

		WebElement source=driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='box103']"));
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
		 */ 

		//drag and drop by

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		//min slider
		WebElement min_slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		System.out.println(min_slider.getLocation());
		Actions act=new Actions(driver);
		act.dragAndDropBy(min_slider, 50, 250).perform();
		System.out.println(min_slider.getLocation());

		//max slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println(max_slider.getLocation());
		act.dragAndDropBy(max_slider, -50, 250).perform();
		System.out.println(max_slider.getLocation());
		 */

		//action vs actions

		/*WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act=new Actions(driver);

		//act.contextClick(button).perform();

		Action action=act.contextClick(button).build();
		action.perform();
		 */








	}

}
