package com.raqa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.raqa.TestBase.TestBase;
import com.raqa.pages.RealAnalistLogin;

public class LoginDemo {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		TestBase ts = new TestBase();
		
		ts.initialization();
		
	}
	
	@Test
	public void Checking() {
		
		RealAnalistLogin  ra = PageFactory.initElements(driver, RealAnalistLogin.class);
		
		ra.realAnalist_login("sysadmin", "Welcome1");

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	
}
