package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class SnapDeal {

ChromeDriver driver;
	
	String url = "http://www.snapdeal.com";
	public void invokeBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		
		WebElement holdButton = driver.findElement(By.xpath("//div[@class='accountInner']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(holdButton).build().perform();
		actions.clickAndHold();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']")).click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
		userName.isDisplayed();
		userName.isEnabled();
		userName.sendKeys("automationtesting@gmail.com");
		driver.findElement(By.xpath("//button[@id='checkUser']")).click();
}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SnapDeal snapDeal = new SnapDeal();
		snapDeal.invokeBrowser();
		snapDeal.closeBrowser();
	}
}
