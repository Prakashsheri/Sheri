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

public class Add_CodeList {
	
	public static void addPlan(WebDriver driver) throws InterruptedException, IOException {


	Thread.sleep(1000); 
	Actions act = new Actions(driver);
	Thread.sleep(1000);
	act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
	Thread.sleep(1000);
	act.moveToElement(driver.findElement(By.xpath("//a[.=\"Code List\"]"))).click().perform();
	Thread.sleep(3000);

	// Add new plan logic goes here
	driver.findElement(By.xpath("//button[@title='Add Code List']")).click();
	Thread.sleep(1000);
	File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
	FileInputStream inputStream = new FileInputStream(file);
	Workbook wb = new XSSFWorkbook(inputStream); 
	org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Add_CodeList");

	DataFormatter dataFormatter = new DataFormatter(); 
	for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		Row row = sheet.getRow(i);
		String CodeType = dataFormatter.formatCellValue(row.getCell(0));
		Thread.sleep(1000);
		String CodeSubType = dataFormatter.formatCellValue(row.getCell(1));
		Thread.sleep(1000);
		String CodeDescription = dataFormatter.formatCellValue(row.getCell(2));
		Thread.sleep(1000);
		String CodeValue = dataFormatter.formatCellValue(row.getCell(3));
		Thread.sleep(1000);
		String CodeComment= dataFormatter.formatCellValue(row.getCell(4));
		Thread.sleep(1000);
		

		driver.findElement(By.xpath("//input[@id='codelstType']")).sendKeys(CodeType);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='codelstSubtyp']")).sendKeys(CodeSubType);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='codelstDesc']")).sendKeys(CodeDescription);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='codelstValue']")).sendKeys(CodeValue);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='codelstComments']")).sendKeys(CodeComment);
		Thread.sleep(1000);
		
	 
		
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-custom'])[3]")).click();

	}
	
	}
}
