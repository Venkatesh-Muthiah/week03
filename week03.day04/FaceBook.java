package week03.day04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		*Assignment:1*
//		FaceBook:

		// Step 1: Download and set the path
		// Not required

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://www.facebook.com/");

		// Step 4: Maximise the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Julius");

		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("Caeser");

		// Step 9: Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("1237894560");

		// Step 10: Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("youTooBrutus");

		// Step 11: Handle all the three drop downs
		// day
		WebElement bDate = driver.findElement(By.name("birthday_day"));
		Select bdateDD = new Select(bDate);
		bdateDD.selectByValue("12");

		// month
		WebElement bMonth = driver.findElement(By.name("birthday_month"));
		Select bmonthDD = new Select(bMonth);
		bmonthDD.selectByValue("7");

		// year
		WebElement bYear = driver.findElement(By.name("birthday_year"));
		Select byearDD = new Select(bYear);
		byearDD.selectByValue("1905");

		// Step 12: Select the radio button "Female"
		// ( A normal click will do for this step
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
