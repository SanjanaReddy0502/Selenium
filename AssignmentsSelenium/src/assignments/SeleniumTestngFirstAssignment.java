package assignments;

import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTestngFirstAssignment {

ChromeDriver driver;
	
	String url = "https://iamneo.ai/";
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	
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
		SeleniumTestngFirstAssignment fa = new SeleniumTestngFirstAssignment();
		fa.invokeBrowser();
		fa.navigateCommands();
		fa.closeBrowser();
	}
}

