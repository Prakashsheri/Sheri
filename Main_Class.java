package UBAR_52_Package;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main_Class  {  

	public static void main(String[] args) throws InterruptedException, IOException {
		// Initialize WebDriver instance
		//  WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver(); 

		// Call login method from Login_UBAR class passing the WebDriver instance
		Login_UBAR.login(driver);

		// Call addPlan method from AddPlan class passing the WebDriver instance
			AddPlan.addPlan(driver);
		//Add_Payer.addPayer(driver);   
		//Attach_Payer.attachPayer(driver);  
		//	Add_Service_Master.addService(driver);		  
		//	Add_CB.addCB(driver);   
		//	Add_CDM.addCdm(driver); 
		//	Add_Patient.addPatient(driver); 
		//Charge_Capture.chargecapture(driver);  
		//chargecaptureHL7.chargecapture1(driver);
		//	Review_Charges.reviewcharge(driver); 
		//GivenProtocolBill.GivenBill(driver);
		//AllCharges.AllBill(driver);
		//	Status_Hold_To_Ready.Hold(driver);
		//	SearchBill.Searchbills(driver); 
		//Received_Payment.ReceivedAmount(driver);


		// Close the WebDriver instance when done
		//driver.quit();
	}
}
