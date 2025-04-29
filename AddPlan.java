package UBAR_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddPlan extends LogIn  {

	@Test
	public void addplan() throws InterruptedException
	{
 
		
		Actions move = new Actions(driver);
		Thread.sleep(1000);
		move.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).perform();
		Thread.sleep(1000);
		move.moveToElement(driver.findElement(By.xpath("//a[.='Plan']"))).click().perform();
		Thread.sleep(1000);
		
	}
}
