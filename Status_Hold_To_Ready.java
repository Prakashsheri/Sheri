package UBAR_52_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Status_Hold_To_Ready {

	public static void Hold(WebDriver driver) throws InterruptedException, IOException  {


		Actions move = new Actions(driver);
		Actions aa = new Actions(driver);
		Thread.sleep(1000); 
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Billing']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Bills']"))).perform();
		Thread.sleep(2000); 
		//aa.moveToElement(driver.findElement(By.xpath("(//a[@class='fullMenuBar'])[5]"))).click().perform();
		aa.moveToElement(driver.findElement(By.xpath("(//a[@class='fullMenuBar'])[5]"))).click().perform();


		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("SearchBills");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0;   
		int lastRow = 30;
		//Starting index  
		int startIndex = 30;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);



			//String protocol = dataFormatter.formatCellValue(row.getCell(0));



			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='showBillingData1']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("(//input[@type='checkBox'])[1]")).click();
			Thread.sleep(3000);


			driver.findElement(By.xpath("//button[@id='changeBillStatus']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();

		} 


	}
}