package UBAR_52_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Received_Payment {



	public static void ReceivedAmount (WebDriver driver) throws InterruptedException, IOException {
		Actions move = new Actions(driver);
		Actions aa = new Actions(driver);
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='A/R']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Receive Payment']"))).click().perform();
		Thread.sleep(1000); 
 

		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(1000);


		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Received_Payment");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0;   
		int lastRow = 3;
		//Starting index  
		int startIndex = 1;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);



			String protocol = dataFormatter.formatCellValue(row.getCell(0));




			driver.findElement(By.xpath("//input[@id='aPayerIdTA']")).sendKeys(protocol);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@id='ui-id-4']")).click();
			Thread.sleep(1000);


			WebElement PaymentMethod = driver.findElement(By.xpath("//select[@id='aPmtId']"));
			Thread.sleep(10000);
			Select payment = new Select(PaymentMethod);
			payment.selectByVisibleText("Credit Card");




			// Get the current date
			//			            LocalDate currentDate = LocalDate.now();
			//			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
			//			            String currentDay = currentDate.format(formatter);
			//			
			//			          
			//			             driver.findElement(By.xpath("//i[@id='trnEffCalIcon']")).click();
			//			             Thread.sleep(500);
			//			             driver.findElement(By.xpath("//a[text()='" + currentDay + "']")).click();
			//			             Thread.sleep(500);


			LocalDate localdate = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("D");
			String currentday = localdate.format(format);

            driver.findElement(By.xpath("//i[@id='trnEffCalIcon']"));

            driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']"));
          //  ui-state-default ui-state-highlight


			//			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			//			Thread.sleep(2000);

		}
	}
}



