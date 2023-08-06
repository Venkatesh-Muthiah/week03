package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Box1 - Tool
		WebElement tool = driver.findElement(By.xpath("//select[@style='overflow-wrap: break-word; height: 150%;']"));
		Select toolInput = new Select(tool);
		toolInput.selectByIndex(1);

		// Box2 - Country
		WebElement country = driver.findElement(By.id("j_idt87:country_label"));
		country.click();
		Thread.sleep(3000);
		WebElement countryIP = driver.findElement(By.xpath("//li[@data-label='India']"));
		
		countryIP.click();
		Thread.sleep(2000);

		// Box3 - City
		WebElement city = driver.findElement(By.id("j_idt87:city_label"));
		city.click();
		Thread.sleep(3000);
		WebElement cityIP = driver.findElement(By.xpath("//li[@data-label='Chennai']"));
		cityIP.click();

		// Box4 - Course
		WebElement course = driver.findElement(By.id("j_idt87:auto-complete_input"));
		course.sendKeys("Playwright");
		driver.findElement(By.xpath("//span[@id='j_idt87:auto-complete_panel']//li[4]")).click();
		Thread.sleep(3000);

		// Box5 - Language
		WebElement lang = driver.findElement(By.id("j_idt87:lang_label"));
		lang.click();
		Thread.sleep(3000);
		WebElement langIP = driver.findElement(By.xpath("//li[@data-label='Hindi']"));
		langIP.click();
		Thread.sleep(3000);

		// Box6 - OddLanguage
		WebElement OddLang = driver.findElement(By.id("j_idt87:value_label"));
		OddLang.click();
		Thread.sleep(3000);
		WebElement OddLangIP = driver.findElement(By.id("j_idt87:value_3"));
		OddLangIP.click();

		driver.close();
	}

}
