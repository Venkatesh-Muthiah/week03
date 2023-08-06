package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Box1
		driver.findElement(By.xpath("//span[text()='Basic']")).click();

		// Box2
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();

		// Box3
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Python']")).click();

		// Box4
		driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/parent::div//div[2]")).click();

		// Box5
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		// Box6
		WebElement box6 = driver
				.findElement(By.xpath("//h5[text()='Verify if check box is disabled']/parent::div//div[2]"));
		boolean enabled=box6.isSelected();
		
		System.out.println(enabled);
		if (enabled==false) {
			System.out.println("Checkbox is disabled");
		} else {
			System.out.println("Checkbox is enabled");
		}

		// Box7
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Filter Input']/parent::div/parent::div//div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();

		driver.close();
	}

}
