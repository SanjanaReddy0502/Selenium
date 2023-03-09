package assignments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayProject {

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
	public void getAllProducts() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li"));
		Iterator<WebElement> iteratorAllProducts = allProducts.iterator();
		int productLocationX, productLocationY;
		while(iteratorAllProducts.hasNext()) {
			WebElement product = iteratorAllProducts.next();
			productLocationX = product.getLocation().x;
			productLocationY = product.getLocation().y;
			scrollBy(productLocationX, productLocationY);
			System.out.println(product.getText());
			System.out.println("-----------------------------------------------");
			
		}
		
	}
	private void scrollBy(int x, int y) {
		JavascriptExecutor jsEngine = driver;
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		jsEngine.executeScript(jsCommand);
	}
	public static void main(String[] args) {
		
		EbayProject ebayProject = new EbayProject();
		ebayProject.invokeBrowser();
		ebayProject.searchProduct("laptops", " Computers/Tablets & Networking");
		ebayProject.getNthResult(10);
		ebayProject.getAllProducts();
	}
}
