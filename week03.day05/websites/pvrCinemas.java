package week03.day05;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class pvrCinemas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Testcase 3 (PVR cinemas)
//		==========
//		01) Launch the Url  https://www.pvrcinemas.com/

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.pvrcinemas.com/");

//		02) Click  on Movie Library
		
		//driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		//driver.findElement(By.xpath("(//button[@aria-label='Close']//i)[1]")).click();
		
		driver.findElement(By.className("nav-icon")).click();
		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();

//		03) Select the City -->chennai
		Select cityDD = new Select(driver.findElement(By.xpath("//select[@name='city']")));
		cityDD.selectByVisibleText("Chennai");

//		04) Select the Genre-->Animation
		Select genre = new Select(driver.findElement(By.xpath("//select[@name='genre']")));
		genre.selectByVisibleText("ANIMATION");

//		05) Select the Language-->english
		Select language = new Select(driver.findElement(By.xpath("//select[@name='lang']")));
		language.selectByVisibleText("ENGLISH");

//		06) Click on Apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();

//		07) Click on first resulting animation movie
		Thread.sleep(9000);

		List<WebElement> firstResult = driver.findElements(By.xpath("//div[@class='movie-wrapper ng-star-inserted']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", firstResult.get(0));

//		08) Click proceed to book
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();

//		09) Enter the all fields  cinema , Name, date, Prefered show time, no of seats, food and beverages,Email and Mobile

		Select cinema = new Select(driver.findElement(By.xpath("//select[@id='cinemaName']")));
		cinema.selectByVisibleText("SPI Sathyam Chennai");

		driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']")).click();
		driver.findElement(By.xpath("//span[text()='27']")).click();

		Select timings = new Select(driver.findElement(By.xpath("//select[@name='timings']")));
		timings.selectByVisibleText("09:00 PM - 12:00 AM");

		driver.findElement(By.name("noOfTickets")).sendKeys("2");

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mithran");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("will&jack@gmail.com");

		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9124632027");

		Select fnB = new Select(driver.findElement(By.xpath("//select[@name='food']")));
		fnB.selectByVisibleText("Yes");

		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("2 Large Popcorn");

//		10) Click on copy to self 
		driver.findElement(By.xpath("//span[text()='Copy To Self']")).click();

//		11) Click on  Send Request
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();

//		12) Click cancel 
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();

//		13) Close the OTP dialog
		driver.findElement(By.className("swal2-close")).click();

//		14) Verify the title of the page
		System.out.println("Title of Page: " + driver.getTitle());

	}

}
