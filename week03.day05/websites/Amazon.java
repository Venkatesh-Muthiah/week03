package week03.day05;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Testcase:2(Amazon)
//		===============
//		01) Launch Chrome  
//		02) Load https://www.amazon.in/
//		     add  implicitlyWait
//		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");

//		03) Type "Bags" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");

//		04) Choose the   item in the result (bags for boys)
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();

//		05) Print the total number of results (like 50000)
//		    1-48 of over 50,000 results for "bags for boys"
		System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
				.getText());

//		06) Select the first 2 brands in the left menu
//		    (like American Tourister, Generic)

		List<WebElement> firstBrand = driver.findElements(By.xpath("//i[@class='a-icon a-icon-checkbox']"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", firstBrand.get(2));

		Thread.sleep(10000);

		List<WebElement> secBrand = driver.findElements(By.xpath("//i[@class='a-icon a-icon-checkbox']"));

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", secBrand.get(3));

		Thread.sleep(6000);
		
//		07) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();

//		08) Print the first resulting bag info (name, discounted price)
		List<WebElement> firstElementName = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println(firstElementName.get(0).getText());

		List<WebElement> firstElementPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(firstElementPrice.get(0).getText());

//		09) Get the page title and close the browser(driver.close()) 
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.close();
	}

}
