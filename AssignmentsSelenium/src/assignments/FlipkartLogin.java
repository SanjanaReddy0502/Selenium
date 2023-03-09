package assignments;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class FlipkartLogin {

	ChromeDriver driver;
	String url = "http://www.flipkart.com";

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		driver.get(url);

	}

	public void loginToFlipkart() {
		driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']//input[@type='text']")).sendKeys("testuser@abc.com");
		
		driver.findElement(By.xpath("//div[@class='_1k3JO2']//button[@fdprocessedid='pecqp7']")).click();
		
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='twjg0k']")).sendKeys("2");
		
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='5pdjw']")).sendKeys("3");
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='wr980e']")).sendKeys("4");
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='gbzth']")).sendKeys("5");
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='w8tvq']")).sendKeys("6");
		driver.findElement(By.xpath("//div[@class='IiD88i _2EZ3Zp']//input[@fdprocessedid='kcokab']")).sendKeys("7");
		
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//button[@type='submit']")).click();
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
public static void main(String[] args) {
		
		FlipkartLogin flipkartLogin = new FlipkartLogin();
		flipkartLogin.invokeBrowser();
		flipkartLogin.loginToFlipkart();
		flipkartLogin.closeBrowser();
		
	}

}

