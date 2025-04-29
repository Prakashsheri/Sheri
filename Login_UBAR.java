package UBAR_52_Package;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_UBAR
{

	//	public static void login() throws InterruptedException
	  public static void login(WebDriver driver) throws InterruptedException
		{
			//Launch Chrome
		    //    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Maven_Project\\UBAR_52\\chromedriver.exe");
			//         WebDriver driver = new ChromeDriver();
			//     

			//Launch FireFox
            //	System.setProperty("webdriver.gechod.driver", "C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Maven_Project\\UBAR_52\\geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
		  
			Thread.sleep(500);
			driver.manage().window().maximize();  
			Thread.sleep(500);
			driver.get("http://localhost:9091/UBAR");
			Thread.sleep(500); 

			driver.findElement(By.id("username")).sendKeys("uday");
			Thread.sleep(1000);

			driver.findElement(By.id("password")).sendKeys("Ubar789");
			Thread.sleep(1000);

			driver.findElement(By.tagName("button")).click();
			Thread.sleep(1000);







		}
	}

