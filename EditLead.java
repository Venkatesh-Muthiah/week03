package week03.day03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		*Assignment 2:Edit Lead*
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/");

//	    2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//	    3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

//	    4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//	    5. Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();

//	    6. Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();

//	    7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Microsoft");

//	    8. Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sachin");

//	    9. Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Tendulkar");

//	    10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ramesh");

//	    11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Cricket");

//	    12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Cricket player");

//	    13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sr10@gmail.com");

//	    14. Select State/Province as NewYork Using Visible Text
		WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDD = new Select(State);
		stateDD.selectByVisibleText("New York");

//	    15. Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();

//	    16. Click on edit button
		driver.findElement(By.linkText("Edit")).click();

//	    17. Clear the Description Field using .clear()
		driver.findElement(By.id("updateLeadForm_description")).clear();

//	    18. Fill ImportantNote Field with Any text
		driver.findElement(By.name("importantNote")).sendKeys("2011 worldcup");

//	    19. Click on update button 
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();

//	    20. Get the Title of Resulting Page. refer the video  using driver.getTitle()
		String expectedTitle = "View Lead | opentaps CRM";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Expected result page is displayed");
		} else {
			System.out.println("Expected result page is not displayed");
		}
	}

}
