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

public class Add_Patient {



	public static void addPatient(WebDriver driver) throws InterruptedException, IOException {


		Thread.sleep(1000); 
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Maintenance']"))).click().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//a[.=\"Patient\"]"))).click().perform();
		Thread.sleep(3000);

		// Add new plan logic goes here
		driver.findElement(By.xpath("//button[@title='Add New Patient']")).click();
		Thread.sleep(1000);

		File file = new File("C:\\Users\\psheri\\Desktop\\QA Document\\Automation_Testing_Scripts\\Document_Excel_Files.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(inputStream); 
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Add_Patient");

		DataFormatter dataFormatter = new DataFormatter(); 
		int firstRow =0; 
		int lastRow = 3;
		//Starting index   
		int startIndex = 3; 
		for (int i = startIndex; i >= firstRow  && i <=lastRow ; i++) 
		{

			Row row = sheet.getRow(i);	

			String UniqueIDNumber1 = dataFormatter.formatCellValue(row.getCell(0));
			Thread.sleep(1000);
			String LastName = dataFormatter.formatCellValue(row.getCell(1));
			Thread.sleep(1000);
			String FirstName = dataFormatter.formatCellValue(row.getCell(2));
			Thread.sleep(1000);
			String MiddleName = dataFormatter.formatCellValue(row.getCell(3));
			Thread.sleep(1000);


			String DOB= dataFormatter.formatCellValue(row.getCell(4));
			Thread.sleep(1000);

			String Address1= dataFormatter.formatCellValue(row.getCell(5));
			Thread.sleep(1000);
			String Address2= dataFormatter.formatCellValue(row.getCell(6));
			Thread.sleep(1000);
			String Address3= dataFormatter.formatCellValue(row.getCell(7));
			Thread.sleep(1000);

			String City= dataFormatter.formatCellValue(row.getCell(8));
			Thread.sleep(1000);

			String Zip= dataFormatter.formatCellValue(row.getCell(9));
			Thread.sleep(1000);

			String Email= dataFormatter.formatCellValue(row.getCell(10));
			Thread.sleep(1000);

			String HomePhone= dataFormatter.formatCellValue(row.getCell(11));
			Thread.sleep(1000);

			String CellPhone= dataFormatter.formatCellValue(row.getCell(12));
			Thread.sleep(1000);
			String WorkPhone= dataFormatter.formatCellValue(row.getCell(13));
			Thread.sleep(1000);

			String EmergencyPhone= dataFormatter.formatCellValue(row.getCell(14));
			Thread.sleep(1000);
			String Fax= dataFormatter.formatCellValue(row.getCell(15));
			Thread.sleep(1000);
			String URL= dataFormatter.formatCellValue(row.getCell(16));
			Thread.sleep(1000);


			WebElement UniqueIDType1 = driver.findElement(By.xpath("//select[@id='aUID1Name']"));
			Select MRN = new Select(UniqueIDType1);
			MRN.selectByVisibleText("MRN");

			WebElement PatientTitle  = driver.findElement(By.xpath("//select[@id='aSEType']"));
			Select Mr = new Select(PatientTitle);
			Mr.selectByVisibleText("Mr.");

			driver.findElement(By.xpath("//input[@id='aUID1Value']")).sendKeys(UniqueIDNumber1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSELName']")).sendKeys(LastName);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEFName']")).sendKeys(FirstName);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEMName']")).sendKeys(MiddleName);
			Thread.sleep(1000);

			WebElement Gender  = driver.findElement(By.xpath("//select[@id='aSEGen']"));
			Select gen = new Select(Gender);
			gen.selectByVisibleText("Male");

			driver.findElement(By.xpath("//input[@id='aSEDob']"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEDob']")).sendKeys(DOB);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSEAddress1']")).sendKeys(Address1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEAddress2']")).sendKeys(Address2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEAddress3']")).sendKeys(Address3);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSECity']")).sendKeys(City);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSEZip']")).sendKeys(Zip);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSEEmail']")).sendKeys(Email);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSEHPhone']")).sendKeys(HomePhone);
			Thread.sleep(1000);


			driver.findElement(By.xpath("(//input[@type='text'])[20]")).sendKeys(CellPhone);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@type='text'])[21]")).sendKeys(WorkPhone);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='aSEEPhone']")).sendKeys(EmergencyPhone);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEFax']")).sendKeys(Fax);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='aSEUrl']")).sendKeys(URL);
			Thread.sleep(1000);


			driver.findElement(By.xpath("//button[@id='addNew1SvcdEntity']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();

		}

	}
}















