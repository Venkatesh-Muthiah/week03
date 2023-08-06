package week03.day05;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Testcase:1 (AbhiBus)
//		==========
//		01) Launch  Chrome browser 
//		add  implicitlyWait
//		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		02) Load https://www.abhibus.com/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.abhibus.com/");

//		04) Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Chennai");

//		05) Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();

//		06) Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Bangalore");

//		07) Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();

//		08) Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();

		driver.findElement(By.xpath("//a[text()='27']")).click();

//		09) Click Search Buses
		driver.findElement(By.xpath("//a[text()='Search']")).click();

//		09) Print the name of the first resulting bus (use .getText())
		List<WebElement> firstBusName = driver.findElements(By.xpath("//h2[@class='TravelAgntNm ng-binding']"));
		System.out.println(firstBusName.get(0).getText());

//		10) Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//input[@title='SLEEPER']")).click();

		driver.findElement(By.linkText("Modify Search")).click();

//		11) Print the first resulting bus seat count(Example:35 Seats Available)(use .getText())
		List<WebElement> seatCount = driver.findElements(By.xpath("//p[@class='noseats AvailSts ng-binding']"));
		System.out.println(seatCount.get(0).getText());

//		12) Click SelectSeat
		List<WebElement> selectSeat = driver.findElements(By.xpath("//span[text()='Select Seat']"));
		selectSeat.get(0).click();

//		13) Choose any one Available seat
		List<WebElement> availableSeat = driver.findElements(By.xpath("//a[@class='tooltip tooltipstered']"));
		driver.executeScript("arguments[0].click();", availableSeat.get(5));

//		14) Print Seats Selected ,Total Fare
		System.out.println(driver.findElement(By.xpath("//span[@id='seatnos']")).getText());

		System.out.println(driver.findElement(By.xpath("//span[@id='ticketfare']")).getText());

//		15) Select Boarding Point  and Dropping Point
		WebElement bPoint = driver.findElement(By.xpath("//select[@id='boardingpoint_id']"));
		Select bpDD = new Select(bPoint);
		bpDD.selectByIndex(4);

		WebElement dPoint = driver.findElement(By.xpath("//select[@id='droppingpoint_id']"));
		Select dpDD = new Select(dPoint);
		dpDD.selectByIndex(3);

//		16) Get the Title of the page(use .getTitle())
		System.out.println(driver.getTitle());

//		17) Close the browser
		Thread.sleep(4000);
		driver.close();

	}

}
