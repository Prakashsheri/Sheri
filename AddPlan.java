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

public class AddPlan { 

	public static void addPlan(WebDriver driver) throws InterruptedException, IOException {


		Thread.sleep(500); 
		Actions act = new Actions(driver);
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.=\"Plan\"]"))).click().perform();
		Thread.sleep(3000); 
         
		// Add new plan   
		driver.findElement(By.xpath("//button[@title='Add New Plan']")).click();
		Thread.sleep(500);   

		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AddPlan");

		DataFormatter dataFormatter = new DataFormatter(); 
		
		 //Range of test cases. 
		int firstRow =0;  
		int lastRow = 200;
		//Starting index
		int startIndex = 101;  
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) {
		//	Row row = sheet.getRow(i);
			Row row = sheet.getRow(i);
			String protocolID = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(500);
			String protocolName = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(500);
			String protocolTitle = dataFormatter.formatCellValue(row.getCell(2));
			Thread.sleep(500);
			String sponsorProtocolID = dataFormatter.formatCellValue(row.getCell(3));
			Thread.sleep(500);
			String piFirstName = dataFormatter.formatCellValue(row.getCell(4));
			Thread.sleep(500);
			String piMiddleName = dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(500);
			String piLastName = dataFormatter.formatCellValue(row.getCell(6));
			Thread.sleep(500);
			String internalIRB = dataFormatter.formatCellValue(row.getCell(7));
			Thread.sleep(500);
			String po = dataFormatter.formatCellValue(row.getCell(8));
			Thread.sleep(500);
			String protocolPhaseStartDate = dataFormatter.formatCellValue(row.getCell(9));
			Thread.sleep(500);
			String protocolClosureDate = dataFormatter.formatCellValue(row.getCell(10));
			Thread.sleep(500); 

			driver.findElement(By.xpath("//input[@id='aPlanId']")).sendKeys(protocolID);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aPlanName']")).sendKeys(protocolName);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aPlanDesc']")).sendKeys(protocolTitle);
			Thread.sleep(500);

			WebElement ProtocolType = driver.findElement(By.xpath("//select[@id='aPlanType']"));
			Select select1 = new Select(ProtocolType);
			Thread.sleep(500);
			select1.selectByValue("284");  
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@id='asponsorId']")).sendKeys(sponsorProtocolID);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='afName']")).sendKeys(piFirstName);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='amName']")).sendKeys(piMiddleName);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='alName']")).sendKeys(piLastName);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aIRBNumber']")).sendKeys(internalIRB);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aPONumber']")).sendKeys(po);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aFromDate']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aFromDate']")).sendKeys(protocolPhaseStartDate);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aToDate']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='aToDate']")).sendKeys(protocolClosureDate);
			Thread.sleep(500);


			//for (int i=0 ; i<=selectElement; i++)
			WebElement selectElement = driver.findElement(By.xpath("//select[@id='aplanStatusType']"));
			Thread.sleep(500);

			// Create a Select object
			Select select = new Select(selectElement);

			// Get the number of options available in the dropdown
			int optionsCount = select.getOptions().indexOf(2);

			// Loop through each option index and select it
			for (int j = 0; j <= optionsCount; j++) {
				select.selectByIndex(j);
				Thread.sleep(500);  // Wait for 0.5 seconds

				// Locate and click the save button
				driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
				Thread.sleep(500);  // Wait for 0.5 seconds

				// Handle the alert
				driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
				Thread.sleep(1000);  // Wait for 1 second afte		
			}

 

			driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();



		}
	}
}

