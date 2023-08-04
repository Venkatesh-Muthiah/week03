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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Box1
		WebElement basic = driver.findElement(By.xpath("//span[text()='Basic']"));
		basic.click();

		// Box2
		WebElement notification = driver.findElement(By.xpath("//span[text()='Ajax']"));
		notification.click();

		// Box3
		WebElement java = driver.findElement(By.xpath("//label[text()='Java']"));
		java.click();
		Thread.sleep(3000);
		WebElement python = driver.findElement(By.xpath("//label[text()='Python']"));
		python.click();

		// Box4
		WebElement triState = driver.findElement(By.xpath("//*[@id=\"j_idt87:ajaxTriState\"]/div[2]"));
		triState.click();

		// Box5
		WebElement slidder = driver.findElement(By.className("ui-toggleswitch-slider"));
		slidder.click();

		// Box6
		WebElement checkBox = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt102']/div[1]/input"));
		boolean checkBox1 = checkBox.isEnabled();
		// System.out.println(checkBox1);
		if (checkBox1 == false) {
			System.out.println("Checkbox is disabled");
		} else {
			System.out.println("Checkbox is enabled");
		}

		// Box7
		WebElement cities = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
		cities.click();
		driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[1]/div[1]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();

		driver.close();
	}

}
