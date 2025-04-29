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

public class Add_CB {

	public static void addCB(WebDriver driver) throws InterruptedException, IOException {

		Thread.sleep(500);
		Actions act = new Actions(driver);
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(500);
		act.moveToElement(driver.findElement(By.xpath("//a[.='CDM']"))).click().perform();
		Thread.sleep(3000);
   
		// Add CB (Charge Basis)
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(3000);
 
		driver.findElement(By.xpath("//input[@id='createCBRecord']")).click();
		Thread.sleep(3000);

		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(inputStream);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("AddCB");

		DataFormatter dataFormatter = new DataFormatter();
		int firstRow = 0;
		int lastRow = 174;
		// Starting index
		int startIndex = 66;
		for (int i = startIndex; i >= firstRow && i <= lastRow; i++) {

			Row row = sheet.getRow(i);

			String cbName = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(500);
			String cbDesc = dataFormatter.formatCellValue(row.getCell(1)); 
			Thread.sleep(500);
			String cbCode = dataFormatter.formatCellValue(row.getCell(2));
			Thread.sleep(500);
			String unitSizeCb = dataFormatter.formatCellValue(row.getCell(3));
			Thread.sleep(500);
			String custAmt2 = dataFormatter.formatCellValue(row.getCell(4));
			Thread.sleep(500);
			String custAmt1 = dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(500);
			String svcPriceCB = dataFormatter.formatCellValue(row.getCell(6));
			Thread.sleep(500);
		//	String fromdate = dataFormatter.formatCellValue(row.getCell(7));
			//Thread.sleep(500);
		//	String todate = dataFormatter.formatCellValue(row.getCell(8));
		//	Thread.sleep(500);


			String Tax = dataFormatter.formatCellValue(row.getCell(7));
			Thread.sleep(500);


			WebElement svcTypeCB = driver.findElement(By.xpath("//select[@id='svcTypeCB']"));
			Thread.sleep(500);
			Select select = new Select(svcTypeCB);
			Thread.sleep(500);
			select.selectByVisibleText("Return");
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@id='cbName']")).sendKeys(cbName);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='cbDesc']")).sendKeys(cbDesc);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='cbCode']")).sendKeys(cbCode);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='unitSizeCb']")).sendKeys(unitSizeCb);
			Thread.sleep(1000);

			WebElement svcUnitCB = driver.findElement(By.xpath("//select[@id='svcUnitCB']"));
			Thread.sleep(500);
			svcUnitCB.click();
			Select unit = new Select(svcUnitCB);
			Thread.sleep(500);
			unit.selectByValue("mg");

			WebElement cbCustCode15 = driver.findElement(By.xpath("//select[@id='cbCustCode15']"));
			Thread.sleep(500);
			Select drop = new Select(cbCustCode15);
			Thread.sleep(500);
			drop.selectByVisibleText("Capsule");

			driver.findElement(By.xpath("//input[@id='custAmt2']")).sendKeys(custAmt2);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='custAmt1']")).sendKeys(custAmt1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='svcPriceCB']")).sendKeys(svcPriceCB);
			Thread.sleep(1000);

			// Get the current date 
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
			String currentDay = currentDate.format(formatter);

			driver.findElement(By.xpath("//i[@id='aFromCalIconCb']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[text()='" + currentDay + "']")).click();
			Thread.sleep(500);


			WebElement tax = driver.findElement(By.xpath("//select[@id='taxTypeDropdownSelectCB']"));
			Thread.sleep(500);
			tax.click();
			Select Taxx = new Select (tax);
			Thread.sleep(500);
			Taxx.selectByVisibleText("Custom Tax (%)");
			Thread.sleep(500);
			 
			

			driver.findElement(By.xpath("//input[@id='taxTypeDropdownFieldValCB']")).sendKeys(Tax);
			Thread.sleep(1000);


			driver.findElement(By.xpath("//button[@id='addCdmBtn']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
			Thread.sleep(1000);
		}

		wb.close();
		inputStream.close();
	}
}
