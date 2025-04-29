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
import org.openqa.selenium.interactions.Actions;

public class AllCharges {

	public static void AllBill (WebDriver driver) throws InterruptedException, IOException {

		Actions move = new Actions(driver);
		Actions aa = new Actions(driver);
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Billing']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Bills']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[@href='generate_allbills_ui']"))).click().perform();
		Thread.sleep(1000); 


		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AllCharges");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0;    
		int lastRow = 174; 
		//Starting index  
		int startIndex = 66;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);



			String protocol = dataFormatter.formatCellValue(row.getCell(0));



			driver.findElement(By.xpath("//button[@id='showRsliData1']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(protocol);
			Thread.sleep(1000);


			driver.findElement(By.xpath("(//input[@type='checkBox'])[1]")).click();
			Thread.sleep(1000);




			driver.findElement(By.xpath("//button[@id='generateBill']")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[@id='alertify-ok'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[@id='alertify-ok'])[1]")).click();


		} 
	}
}


