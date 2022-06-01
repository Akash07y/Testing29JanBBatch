package testPack;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClass.ApplicationHeader;
import pomClass.LoginPage;

public class TestClass1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite TestClass 1");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest TestClass 1");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass TestClass 1");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod TestClass 1");
	}
	
	@Test
	public void testB() throws InterruptedException  {
		
		System.out.println("test B TestClass 1");
	}
	
	@Test  
	public void testA() {
		
		System.out.println("test A TestClass 1");

	}
	
	@Test  
	public void testF() {
		
		System.out.println("test F TestClass 1");

	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("afterMethod TestClass 1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass TestClass 1");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest TestClass 1");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite TestClass 1");
	}

	

}
