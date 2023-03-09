package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignup {
	ChromeDriver driver;
	String url = "https://www.fb.com";
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		String urlFromWebpage = driver.getCurrentUrl();
		if(urlFromWebpage.equals("https://www.facebook.com/")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
	}
	public void signup() {
		
	}

}
