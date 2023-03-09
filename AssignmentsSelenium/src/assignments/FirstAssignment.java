package assignments;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstAssignment {

	ChromeDriver driver;
	
	String url = "https://iamneo.ai/";
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	
	}
	public void verifyPageTitle() {
		String expectedTitle = "We are Hiring!";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}
	public void navigateCommands() {
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		String urlFromWebpage = driver.getCurrentUrl();
		System.out.println(urlFromWebpage);
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	public void closeBrowser() {
		driver.quit();
	}
	public static void main(String[] args) {
		FirstAssignment fa = new FirstAssignment();
		fa.invokeBrowser();
		fa.verifyPageTitle();
		fa.navigateCommands();
		fa.closeBrowser();
	}
}
