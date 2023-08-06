package week03.day04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Acme {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		*Assignment:3*
//		===================

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");

//		2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");

//		3. Enter Password as "leaf@12"
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");

//		4. Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

//		5. Get the title of the page and print
		System.out.println("Title of this page is: " + driver.getTitle());

//		6. Click on Log Out
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);
		
//		7. Close the browser (use -driver.close())
		driver.close();

	}

}
