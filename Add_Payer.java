package UBAR_52_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.debugger.model.ScriptPosition;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Add_Payer {

	public static void addPayer(WebDriver driver) throws InterruptedException, IOException {


		Actions payerActions = new Actions(driver);
		Thread.sleep(1000);
		payerActions.moveToElement(driver.findElement(By.xpath("//a[.=\"Maintenance\"]"))).click().perform();
		Thread.sleep(1000);
		payerActions.moveToElement(driver.findElement(By.xpath("//a[.=\"Payer\"]"))).click().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='addNewPayerm']")).click();
		Thread.sleep(1000);

   
   
		//	driver.manage().deleteAllCookies();
		//	System.out.println(size);
		//	int w = size.getHeight();
		//System.out.println(w);


		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Add_Payer");







		DataFormatter dataFormatter = new DataFormatter(); 
		 //Range of test cases. 
		int firstRow =0; 
		int lastRow = 850;
		//Starting index
		int startIndex = 811; 
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) {
			Row row = sheet.getRow(i);

			String payerID = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(500);
			String accountNo = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(500);
			String accountName = dataFormatter.formatCellValue(row.getCell(2));
			Thread.sleep(500);
			String address1 = dataFormatter.formatCellValue(row.getCell(3));
			Thread.sleep(500);
			String address2 = dataFormatter.formatCellValue(row.getCell(4));
			Thread.sleep(500);
			String address3 = dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(500);
			String city = dataFormatter.formatCellValue(row.getCell(6));
			Thread.sleep(500);
			String zipCode = dataFormatter.formatCellValue(row.getCell(7));
			Thread.sleep(500);
			String email = dataFormatter.formatCellValue(row.getCell(8));
			Thread.sleep(500);
			String workPhone1 = dataFormatter.formatCellValue(row.getCell(9));
			Thread.sleep(500);
			String ext1 = dataFormatter.formatCellValue(row.getCell(10));
			Thread.sleep(500);
			String workPhone2 = dataFormatter.formatCellValue(row.getCell(11));
			Thread.sleep(500);
			String ext2 = dataFormatter.formatCellValue(row.getCell(12));
			Thread.sleep(500);
			String fax = dataFormatter.formatCellValue(row.getCell(13));
			Thread.sleep(500);
			String url = dataFormatter.formatCellValue(row.getCell(14));
			Thread.sleep(500);


			driver.findElement(By.xpath("//input[@id='payerId']")).sendKeys(payerID);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='addPayerAccNo']")).sendKeys(accountNo);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='addPayerAccName']")).sendKeys(accountName);
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerAdd1']")).sendKeys(address1);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerAdd2']")).sendKeys(address2);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerAdd3']")).sendKeys(address3);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerCity']")).sendKeys(city);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerZip']")).sendKeys(zipCode);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerEmail']")).sendKeys(email);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerWorkphone1']")).sendKeys(workPhone1);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='addPayerWorkphone2']")).sendKeys(workPhone2);
//			Thread.sleep(1000);
//
			WebElement Type = driver.findElement(By.xpath("//select[@id='pTypeCode']"));
			Select TypeCode  = new Select(Type);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,200)");







 










			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='addNew1Payer']")).click();
			Thread.sleep(1000);
			// Handle alert if needed
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();

			wb.close();
	        inputStream.close();


		}
		
		
	}
}


