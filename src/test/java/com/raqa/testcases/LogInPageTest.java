package com.raqa.testcases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.raqa.TestBase.TestBase;
import com.raqa.pages.RA_REIS;
import com.raqa.pages.RealAnalistLogin;
import com.raqa.pages.TenentSelection;

public class LogInPageTest{ //extends RealAnalistLogin {
	public Properties prop;
	public RealAnalistLogin login;
	public WebDriver driver;
	public WebDriverWait wait;
//	public LogInPageTest() {
//		super();
//	}


	@BeforeMethod
	public void setup() {
		
		//login = new RealAnalistLogin(driver);
		
	}
	@BeforeTest
	public void Pre() {
		System.setProperty("webdriver.chrome.driver", "E:chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://rauat.modeloncloud.com/umg-admin/login");
	}
	
	@Test (priority =0)
	public void loginTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		login.initialization();
		login = new RealAnalistLogin();
		Thread.sleep(5000);
		login.realAnalist_login("sysadmin", "Welcome1"); 
		Thread.sleep(30000);
		
		
		
		}
	
	@Test (priority = 1)
	public void tenentSlection() throws Exception {
		Thread.sleep(30000); 
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
			}catch (Exception e) {
				driver.navigate().refresh();	
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
			
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		TenentSelection tenent = new TenentSelection(driver);
		tenent.clickOnTenentIcan();
		tenent.clickOnReis();
		tenent.clickOnYesInPop_up();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
	}
	@Test(priority = 2)  
	public void medelMadule() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		RA_REIS reis = new RA_REIS(driver);
		reis.modelsMadule();
		reis.clickOnTheAdd();
	} 
	
}
