package UBAR_52_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Attach_Payer {

	public static void attachPayer(WebDriver driver) throws InterruptedException, IOException {


		Thread.sleep(500); 
		Actions act = new Actions(driver); 
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.=\"Plan\"]"))).click().perform();
		Thread.sleep(3000); 
   
		//drop down  
		WebElement status = driver.findElement(By.xpath("//select[@id='planStatusType']"));
		Thread.sleep(1000);
		Select BillingPlanStatus = new Select(status);
		Thread.sleep(1000);
		BillingPlanStatus.selectByValue("999");
		Thread.sleep(1000);
 
		//Search button
		driver.findElement(By.xpath("//button[@id='cppTableSearch']")).click();
		Thread.sleep(1000);
 


		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(inputStream); 
		Thread.sleep(1000);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AttachPayer");

		DataFormatter dataFormatter = new DataFormatter(); 
		Thread.sleep(1000);
		int firstRow =0; 
		int lastRow = 256; 
		//Starting index
		int startIndex = 108; 
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) {
		
			Row row = sheet.getRow(i);
			String Searchplan = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(1000);
			String searchpayer = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(1000);
  



			driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Searchplan);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[.='Payer'])[1]")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//input[@id='srchPayerForCpp']")).sendKeys(searchpayer);
			
			driver.findElement(By.xpath("(//a[@title='Advance Search'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(searchpayer);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@href='#'])[16]")).click();
			
			
			//driver.findElement(By.xpath("//ul[@id='ui-id-7']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[.='Attach Payer']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			Thread.sleep(5000);

			
			
			driver.findElement(By.xpath("(//input[@type='search'])[1]")).clear();
			Thread.sleep(500);
			
			
			
			
		}
	}
}

