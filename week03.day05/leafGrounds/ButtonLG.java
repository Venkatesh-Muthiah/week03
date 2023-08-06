package week03.day04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonLG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// getTitle
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']/span")).click();

		String title1 = "Dashboard";
		String title2 = driver.getTitle();

		if (title1.equals(title2)) {
			System.out.println("Title verified");
		}

		driver.navigate().back();

		boolean enabled = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
		if (enabled) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}

		// location,size
		Point location = driver.findElement(By.id("j_idt88:j_idt94")).getLocation();
		System.out.println("Location: " + location);
		Dimension size = driver.findElement(By.id("j_idt88:j_idt98")).getSize();
		System.out.println("Size: " + size);

		// click image
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']/span")).click();
		
	}

}
