package week03.day04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputLG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.leafground.com/input.xhtml");

		driver.findElement(By.name("j_idt88:name")).sendKeys("Fernando");

		driver.findElement(By.name("j_idt88:j_idt91")).sendKeys(",India");

		if (driver.findElement(By.name("j_idt88:j_idt93")).isEnabled()) {
			System.out.println("Text box is enabled");
		} else {
			System.out.println("Text box is disabled");
		}

		driver.findElement(By.name("j_idt88:j_idt95")).clear();

		System.out.println("Retrieved text: " + driver.findElement(By.name("j_idt88:j_idt97")).getAttribute("value"));

		WebElement eMail = driver.findElement(By.name("j_idt88:j_idt99"));
		eMail.sendKeys("321@testleaf.com");
		eMail.sendKeys(Keys.TAB + "Hello folks!");

		driver.findElement(By.name("j_idt106:thisform:age")).sendKeys(Keys.ENTER);

		String errorMsgE = "Age is mandatory";
		String errorMsgA = driver.findElement(By.className("ui-message-error-detail")).getText();

		if (errorMsgE.equals(errorMsgA)) {
			System.out.println("Error message confirmed");
		} else {
			System.out.println("Error message is not confirmed");
		}

		driver.navigate().back();

		WebElement labelCheck = driver.findElement(By.xpath("//label[text()='Username']"));

		Point location1 = labelCheck.getLocation();

		driver.findElement(By.name("j_idt106:float-input")).click();

		Point location2 = labelCheck.getLocation();

		if (location1.equals(location2)) {
			System.out.println("Same location");
		} else {
			System.out.println("Location changed successfully");
		}

		driver.findElement(By.name("j_idt106:auto-complete_input")).sendKeys("Fernando");

		driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//li[3]")).click();

		String dob = "27/07/1981";
		driver.findElement(By.name("j_idt106:j_idt116_input")).sendKeys(dob);
		String date27 = driver.findElement(By.linkText("27")).getText();

		if (dob.contains(date27)) {
			System.out.println("Same date is picked");
		} else {
			System.out.println("Date mismatch");
		}

		WebElement number = driver.findElement(By.name("j_idt106:j_idt118_input"));
		number.sendKeys("5");

		driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/a")).click();

		String newNumber = number.getText();

		if (number.equals(newNumber)) {
			System.out.println("Both numbers are same");
		} else {
			System.out.println("Both numbers are different");
		}

		driver.findElement(By.name("j_idt106:slider")).sendKeys("35");

//		WebElement slideCheck = driver
//				.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
//
//		String actualResult = slideCheck.getAttribute("style");
//
//		if (actualResult.contains("35")) {
//			System.out.println("Slider verified successfully");
//		}

		driver.findElement(By.id("j_idt106:j_idt122")).click();
		boolean keyboard = driver.findElement(By.xpath("//div[contains(@class,'shadow keypad-popup')]")).isDisplayed();
		if (keyboard) {
			System.out.println("keyboard is displayed");
		} else {
			System.out.println("keyboard is not displayed");
		}

	}

}
