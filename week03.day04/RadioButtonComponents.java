package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonComponents {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Button1
		driver.findElement(By.xpath("(//label[text()='Edge'])[1]")).click();

		// Button2
		driver.findElement(By.xpath("//label[text()='Bengaluru']")).click();
		String unselected1 = driver.findElement(By.xpath("//label[text()='Chennai']")).getText();
		String unselected2 = driver.findElement(By.xpath("//label[text()='Hyderabad']")).getText();
		System.out.println("Unselected buttons are " + unselected1 + "and " + unselected2);

		// Button3
		WebElement clicked = driver.findElement(By.xpath("//table[@id='j_idt87:console2']//td[3]"));
		System.out.println(clicked.getText() + " is defaultly selected");

		boolean enabled = clicked.isEnabled();
		if (enabled == true) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
		Thread.sleep(3000);
		driver.close();
	}
}