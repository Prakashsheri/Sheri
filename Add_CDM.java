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

public class Add_CDM { 

	public static void addCdm(WebDriver driver) throws InterruptedException, IOException {
		Actions move = new Actions(driver);
		move.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(1000);
		move.moveToElement(driver.findElement(By.xpath("//a[.='CDM']"))).click().perform();
		Thread.sleep(1000); 
 
		driver.findElement(By.xpath("//button[@title='Add New CDM']")).click();
		Thread.sleep(1000);  

		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file); 
		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AddCDM");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0;   
		int lastRow = 500;
		//Starting index 
		int startIndex = 246;   
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);
    


			String protocol = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(1000);
			String svcName = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(500);
//			String svcLbName = dataFormatter.formatCellValue(row.getCell(2));
//			Thread.sleep(500);
//			String svcDesc = dataFormatter.formatCellValue(row.getCell(3));
//			Thread.sleep(500);
//			String svcCode = dataFormatter.formatCellValue(row.getCell(4));
//			Thread.sleep(500);
			String unitSize = dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(500);
			String searchCB = dataFormatter.formatCellValue(row.getCell(6));





			driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-search'])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(protocol);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@href='#'])[12]")).click();
			Thread.sleep(1000); 

			WebElement drop = driver.findElement(By.xpath("//select[@id='svcType']"));
			Thread.sleep(500);
			Select select = new  Select(drop) ;
			Thread.sleep(500);
			select.selectByVisibleText("Return");
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@id='svcName']")).sendKeys(svcName);
			Thread.sleep(500);
//			driver.findElement(By.xpath("//input[@id='svcLbName']")).sendKeys(svcLbName);
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//input[@id='svcDesc']")).sendKeys(svcDesc);
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//input[@id='svcCode']")).sendKeys(svcCode);
//			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='unitSize']")).sendKeys(unitSize);
			Thread.sleep(500);
			


			WebElement dropp = driver.findElement(By.xpath("//select[@id='svcUnit']"));
			Thread.sleep(500);
			Select unit = new   Select (dropp);
			Thread.sleep(500);
			unit.selectByVisibleText("Unit");
			Thread.sleep(500);

			WebElement dropp3 = driver.findElement(By.xpath("//select[@id='custCode15']"));
			Thread.sleep(500);
			Select formulation = new Select (dropp3);
			Thread.sleep(500);
			formulation.selectByVisibleText("Powder");

			WebElement dropp4  = driver.findElement(By.xpath("//select[@id='priceType']"));
			Thread.sleep(500);
			Select chargebases = new Select (dropp4);
			Thread.sleep(500);
			chargebases.selectByVisibleText("Quantity Based");
			Thread.sleep(500);


			driver.findElement(By.xpath("//a[@id='showServiceAdSrch']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(searchCB);
			Thread.sleep(2000);


			driver.findElement(By.xpath("(//a[@href='#'])[16]")).click();
			Thread.sleep(2000);
			WebElement BillingFrequency = driver.findElement(By.xpath("//select[@id='freqCode']"));
			Thread.sleep(1000);
			Select Frequency = new Select(BillingFrequency); 
			Thread.sleep(1000);
			Frequency.selectByVisibleText("Annual");
			Thread.sleep(1000); 

			driver.findElement(By.xpath("//button[@id='addCdmBtn']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			Thread.sleep(2000);
			 
		}  
 

	}
}
