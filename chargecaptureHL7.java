package UBAR_52_Package;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class chargecaptureHL7
{
	public static void chargecapture1(WebDriver driver) throws InterruptedException, IOException
	{

	
	
		
			Actions act = new Actions(driver);	
			Thread.sleep(1000);
			act.moveToElement(driver.findElement(By.xpath("//a[.='Billing']"))).perform();
			Thread.sleep(1000);

			act.moveToElement(driver.findElement(By.xpath("//a[.='Charges']"))).click().perform();
			Thread.sleep(1000);
			act.moveToElement(driver.findElement(By.xpath("//a[.='Charge Capture']"))).click().perform();
			Thread.sleep(1000); 
	 
	  

			File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
			FileInputStream inputStream = new FileInputStream(file);

			Workbook wb = new XSSFWorkbook(inputStream); 
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("ChargeCapture");

			DataFormatter dataFormatter = new DataFormatter(); 
			int firstRow =0; 
			int lastRow = 900;
			//Starting index   
			int startIndex = 500;  
			for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
			{

				Row row = sheet.getRow(i);

				Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-search'])[1]")).click();
				Thread.sleep(1000);

				String protocol = dataFormatter.formatCellValue(row.getCell(0));
				String svcQty = dataFormatter.formatCellValue(row.getCell(1));
//				String crComment = dataFormatter.formatCellValue(row.getCell(2));
//				String trnDetails = dataFormatter.formatCellValue(row.getCell(3));
//				String visitDetails = dataFormatter.formatCellValue(row.getCell(4));


				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(protocol);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//a[@href='#'])[13]")).click();
				Thread.sleep(2000);

				// Get the current date
//				LocalDate currentDate = LocalDate.now();
//				Thread.sleep(1000);
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
//				Thread.sleep(1000);
//				String currentDay = currentDate.format(formatter);
//				Thread.sleep(1000);
	//
//				driver.findElement(By.xpath("//input[@id='trnDate']")).click();
//				Thread.sleep(1000);
				

				WebElement ServiceType = driver.findElement(By.xpath("//select[@id='svcType']"));
				Thread.sleep(1000);
				Select Service = new Select(ServiceType); 
				Thread.sleep(1000);
				Service.selectByVisibleText("Return");

				driver.findElement(By.xpath("//a[@id='svcModelMCC']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//a[@href='#'])[17]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='svcQty']")).sendKeys(svcQty);
				Thread.sleep(1000);
//				driver.findElement(By.xpath("//input[@id='crComment']")).sendKeys(crComment);
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("//input[@id='trnDetails']")).sendKeys(trnDetails);
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("//input[@id='visitDetails']")).sendKeys(visitDetails);
				Thread.sleep(1000); 
				driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
				Thread.sleep(1000);
				
				



			}
		}
	}




