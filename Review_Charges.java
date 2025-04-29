package UBAR_52_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Review_Charges { 

	public static void reviewcharge(WebDriver driver) throws InterruptedException, IOException {
		Actions move = new Actions(driver);
		Actions aa = new Actions(driver);
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Billing']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Charges']"))).perform();
		Thread.sleep(1000);
		aa.moveToElement(driver.findElement(By.xpath("//a[.='Review Charges']"))).click().perform();
		Thread.sleep(1000); 
     
  
		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("ChangeChargeStatus");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0;   
		int lastRow = 265;
		//Starting index  
		int startIndex = 75;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);



			String protocol = dataFormatter.formatCellValue(row.getCell(0));



   
			driver.findElement(By.xpath("(//a[@title='Advance Search'])[1]")).click();
			Thread.sleep(1000);



			driver.findElement(By.xpath("//input[@id='sPlanName']")).sendKeys(protocol);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[@title='Search'])[5]")).click();
			Thread.sleep(1000);

			
			driver.findElement(By.xpath("(//td[@class='sorting_1']//a[@href='#'])[1]")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='showRsliData1']")).click();
			Thread.sleep(10000);


			driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-edit'])[1]")).click();
            Thread.sleep(1000);

			WebElement status = driver.findElement(By.xpath("//select[@id='blStatusId']"));
			Select change = new Select(status) ;
			change.selectByVisibleText("Billable");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='updateRsli']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			Thread.sleep(2000);
			
		} 


	}
}
