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

public class Add_Service_Master {

	public static void addService(WebDriver driver) throws InterruptedException, IOException {


		Thread.sleep(500); 
		Actions act = new Actions(driver);
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.=\"Service Master\"]"))).click().perform();
		Thread.sleep(3000);    
 
		// Add Service Master 
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(500);
   
		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AddServiceMaster");
 
		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0; 
		int lastRow = 11; 
		//Starting index 
		int startIndex = 11;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{
		
			Row row = sheet.getRow(i);
			String protocolID = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(500);
			String svcmName = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(500);
			String svcmDesc = dataFormatter.formatCellValue(row.getCell(2));
			Thread.sleep(500);
			String svcmCode = dataFormatter.formatCellValue(row.getCell(3));
			Thread.sleep(500);
			String unitSize = dataFormatter.formatCellValue(row.getCell(4));
			Thread.sleep(500);
			String smDrugId = dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(500);
			String smDrugLabelNm = dataFormatter.formatCellValue(row.getCell(6));
			Thread.sleep(500);
 


		//	driver.findElement(By.xpath("//input[@id='smAddPlan']")).sendKeys(protocolID);
			
			driver.findElement(By.xpath("(//a[@title='Advance Search'])[2]")).click();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(protocolID);
			Thread.sleep(500);
			driver.findElement(By.xpath("(//a[@href='#'])[11]")).click();
			Thread.sleep(500);

			WebElement ServiceType = driver.findElement(By.xpath("//select[@id='svcmType']"));
			Thread.sleep(500);
			Select select = new Select (ServiceType);
			Thread.sleep(500);
			select.selectByVisibleText("Return");
			Thread.sleep(500);
			
			
			driver.findElement(By.xpath("//input[@id='svcmName']")).sendKeys(svcmName);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='svcmDesc']")).sendKeys(svcmDesc);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='svcmCode']")).sendKeys(svcmCode);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='unitSize']")).sendKeys(unitSize);
			Thread.sleep(1000);

			WebElement ServiceUnit = driver.findElement(By.xpath("//select[@id='svcmUnit']"));
			Thread.sleep(500);
			Select unit = new Select(ServiceUnit); 
			Thread.sleep(500);
			unit.selectByValue("mg");

			
			WebElement formulation = driver.findElement(By.xpath("//select[@id='formulation']"));
			Thread.sleep(500);
            Select drop = new Select(formulation);
        	Thread.sleep(500);
            drop.selectByVisibleText("Capsule");
            
            
            driver.findElement(By.xpath("//input[@id='smDrugId']")).sendKeys(smDrugId);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='smDrugLabelNm']")).sendKeys(smDrugLabelNm);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			
			
            
            

		}
	}
}

