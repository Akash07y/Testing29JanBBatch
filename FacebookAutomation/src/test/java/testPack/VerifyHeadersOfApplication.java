package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.Utility;
import browser.Base;
import pomClass.ApplicationHeader;
import pomClass.LoginPage;

public class VerifyHeadersOfApplication {

	WebDriver driver ;
	LoginPage loginPage ;
	ApplicationHeader applicationHeader ;
	
	int testID ;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();	
		}
		if(browserName.equals("Firefox"))
		{
			driver = Base.openFirefoxBrowser();	
		}
		if(browserName.equals("Opera"))
		{
			driver = Base.openOperaBrowser();	
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
	}
	
	@BeforeClass
	public void creatPOMObject() {
		loginPage = new LoginPage(driver);
		applicationHeader  = new ApplicationHeader(driver);
	}
	
	@BeforeMethod
	public void loginToApplication()	{
		driver.get("http://desktop-b2220qc/login.do");
		
		String data = Utility.getDataFromExcelsheet(); // userName => sheet row cell 
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet(); // password => sheet row cell 
		loginPage.sendPasswordName(data);
		
		loginPage.selectKeepMeLogin();
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void verifyTaskButton() {
		
		// Global variable 
		testID = 123;
		
		SoftAssert soft = new SoftAssert();
		
		applicationHeader.openTaskPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		soft.assertEquals(url, "http://desktop-b2220qc/tasks/otasklist.do", "URL is not correct");
		soft.assertEquals(title, "actiTIME - Open Tasks");
		soft.assertAll();
	}
	
	@Test
	public void verifyReportButton() {
		testID = 365;
		
		applicationHeader.openReportsPage();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("http://desktop-b2220qc/reports/reports.do") &&  title.equals("actiTIME - Open Tasks actiTIME - Saved Reports")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result)	{
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(); // testID
		}
		applicationHeader.clickOnLogout();
	}
	
	@AfterClass
	public void clearObjects() {
		loginPage = null;
		applicationHeader = null;
	}
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null ;
		System.gc();  // garbeg collector 
	}
}
