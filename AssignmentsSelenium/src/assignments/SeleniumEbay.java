package assignments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SeleniumEbay {

	ChromeDriver driver;
	String url = "https://www.ebay.com/";
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yeruv\\Downloads\\chromedriver2\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	public void searchProduct(String product, String category) {
		
		driver.findElement(By.id("gh-ac")).sendKeys(product);
		WebElement categoryDropdownElement = driver.findElement(By.id("gh-cat"));
		Select categorySelect = new Select(categoryDropdownElement);
		categorySelect.selectByVisibleText(category);
		driver.findElement(By.id("gh-btn")).click();
		String result = driver.findElement(By.xpath("//h1[contains(text(),'results for')]")).getText();
	    System.out.println(result);
	}
	
	public void getNthResult(int productNumber) {
		
		String xpathExpression = String.format("//div[@id='srp-river-results']/ul/li[%d]", productNumber);
		String nthProduct = driver.findElement(By.xpath(xpathExpression)).getText();
		System.out.println(nthProduct);
		System.out.println("-------------------------------------------------");
	}
	
	public static void main(String[] args) {
		
		SeleniumEbay seleniumEbay = new SeleniumEbay();
		seleniumEbay.invokeBrowser();
		seleniumEbay.searchProduct("laptops", " Computers/Tablets & Networking");
		seleniumEbay.getNthResult(10);
		
	}
}

