package com.raqa.trail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.raqa.util.Utilities;
import com.sun.org.apache.xml.internal.security.signature.Manifest;

public class Logind_and_use {
	static String checkSumValue = "78e15a30cb5ec3306753cdecbe1e68cd463b64f2f8607b88a2940a96d47fbd01";
	public static Select s;
	public static String hubze;
	public static String manifesto = "C:\\Users\\Nagasesha Reddy\\Desktop\\RealAnalist\\Manifest File NRZ v6.3.0.csv";
	public static String modelIO = "C:\\Users\\Nagasesha Reddy\\Desktop\\RealAnalist\\IO File v 6.3.0.xlsx";
	public static Robot robot;
	public static StringSelection stringselection;
	public static JavascriptExecutor js;
	public static WebDriver driver;
	public static WebDriverWait wait;

//	public static void getStringValue() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//		LocalDateTime now = LocalDateTime.now();
//		String stringdata = dtf.format(now);
//
//	}

	public static Utilities utility;

//	public static void manageModelStatus() {
//		driver.findElement(By.id("hm_lp_vview")).click(); // manage / modify
//
//		String versionExpected = driver
//				.findElement(By.xpath(
//						"//*[@class='ag-row ag-row-odd ag-row-selected ag-row-level-0']//div[contains(text(),'1.1')]"))
//				.getText();
//		String actualVersion = "1.1";
//		if (versionExpected.equalsIgnoreCase(actualVersion)) {
//			System.out.println("version : " + actualVersion);
//		} else {
//			System.out.println("version : " + versionExpected);
//		}
//	}
	@BeforeTest
	public void logInAndClickModel() throws Exception {
		utility = new Utilities();
		hubze = utility.renameFile();
		System.out.println(hubze);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.get("https://rauat.modeloncloud.com/umg-admin/login");
	}
		@Test(priority =0)
		public void logIn() throws Exception {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
		driver.findElement(By.name("j_username")).sendKeys("sysadmin");
		driver.findElement(By.name("j_password")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//*[@class='login button']/child::a/input")).click();
//		try {
//			driver.navigate().refresh();	
//		}catch (Exception e) {
//			driver.navigate().refresh();
//		}
		driver.navigate().refresh();

		// WebElement tenent =driver.findElement(By.xpath("//*[@class='glyphicon
		// glyphicon-user']"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
		System.out.println("apply");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@class='dropdown notifications-menu']/a/i")).click(); // tenent

		System.out.println("close");
		driver.findElement(By.xpath("//*[@class='menu']/child::li[8]")).click(); // for REIS
		// driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[text()='Yes']")).click(); // popup
		// driver.findElement(By.xpath("//*[text()='No']")).click(); //popup
		Thread.sleep(30000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
		Thread.sleep(10000);
		driver.findElement(By.id("hm_lft_sdbar_Models")).click(); // models

	}
		@Test(priority = 1)
	public static void addAndCreateNewVersionModel() throws Exception {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		driver.findElement(By.id("hm_lp_smp")).click(); // add
		// driver.findElement(By.id("hm_lp_vview")).click(); //manage / modify
//		String expect = driver.findElement(By.xpath("//div[@class='ag-row ag-row-even ag-row-level-0 ag-row-selected']//*[text()='PUBLISHED']")).getText();
//		String atual = "PUBLISHED";
//		if(expect.equalsIgnoreCase(atual)) {
//			System.out.println(atual);
//		}
		Thread.sleep(8000);
//		driver.findElement(By.xpath("//div[@class='ag-row ag-row-even ag-row-level-0 ag-row-selected']//*[text()='Automation']")).click();
		driver.findElement(By.id("createNewVersionTab")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("modelName_fv_sel")).click();
		driver.findElement(By.xpath("(//*[@id='modelName_fv_sel'])[1]/child::option[2]")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("minorVer_hv")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("majorVersions_hv")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@id='majorVersions_hv'])[1]/child::option[2]")).click();
//		driver.findElement(By.id("version_desc_fv")).sendKeys("autoTest");
		driver.findElement(By.xpath("(//*[@tooltip='Upload Document'])[1]")).click();
		robot = new Robot();
		robot.setAutoDelay(3000);
		stringselection = new StringSelection("C:\\Users\\Nagasesha Reddy\\Desktop\\testRealAnalyse.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("success");

//		s = new Select(driver.findElement(By.id("pr_lng")));
		// Thread.sleep(10000);
		// driver.findElement(By.id("clr_btn")).click();
		driver.findElement(By.id("add_artifacts_btn1")).click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		driver.findElement(By.xpath(
				"(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload tar.gz/zip file'])[1]"))
				.click();

		Utilities.fileUpload(hubze);

		driver.findElement(
				By.xpath("(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload .csv file'])[1]"))
				.click();
		robot = new Robot();
		robot.setAutoDelay(3000);
		stringselection = new StringSelection(manifesto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(
				"(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload .xslx or .xml file'])[1]"))
				.click();
		Utilities.fileUpload(modelIO);
		driver.findElement(By.id("checksum_fv")).sendKeys(checkSumValue);
		driver.findElement(By.id("saveVersionBtn1")).click();

		String testReportExpected = driver.findElement(By.xpath("//*[@class='badge badge-success ng-binding']"))
				.getText();
		System.out.println(testReportExpected);
		String actual = "Tested & Saved";
		if (testReportExpected.equalsIgnoreCase(actual)) {
			System.out.println("Tested & Saved");
		} else {
			System.out.println("in-complete");
		}
	}
		@Test(priority = 2)
	public static void manageModelStatus() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		driver.findElement(By.id("hm_lp_vview")).click(); // manage / modify

		String versionExpected = driver.findElement(By.xpath("//div[contains(text(),'1.1')]")).getText();
		String actualVersion = "1.1";
		if (versionExpected.equalsIgnoreCase(actualVersion)) {
			System.out.println("version : " + actualVersion);
		} else {
			System.out.println("version : " + versionExpected);
		}

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");

		String beforePublishStatus = driver
				.findElement(By.xpath("//*[text()='2019-Sep-18 22:14']/following-sibling::div[1]")).getText();
		System.out.println("before publish : " + beforePublishStatus);
		driver.findElement(By.xpath("//*[text()='2019-Sep-18 22:14']")).click();

		driver.findElement(By.id("vl_publish")).click();

		driver.findElement(By.xpath("//*[contains(text(),'Yes')]")).click();

		String expectedResult = driver.findElement(By.xpath("//*[text()='Version published successfully.']")).getText();
		String actuvaluresult = "Version published successfully.";
		if (expectedResult.equalsIgnoreCase(actuvaluresult)) {
			System.out.println("Version published successfully.");
		}
		String afterPunlishStatus = driver
				.findElement(By.xpath("//*[text()='2019-Sep-18 22:14']/following-sibling::div[1]")).getText();
		System.out.println("after publish : " + afterPunlishStatus);

	}
	 	
	public static void CreateNewModel() throws Exception {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		driver.findElement(By.id("hm_lp_smp")).click(); // add
		//driver.findElement(By.id("createNewModelTab")).click();
		driver.findElement(By.id("modelName_fv")).sendKeys("Selenium");
		driver.findElement(By.id("model_desc_fv")).sendKeys("SeleniumTester");
		driver.findElement(
				By.xpath("(//*[@class='btn btn-primary btn-sm btn-file ng-scope' and @tooltip='Upload Document'])[1]"))
				.click();
		Utilities.fileUpload("C:\\Users\\Nagasesha Reddy\\Desktop\\testRealAnalyse.txt");
		driver.findElement(By.id("pr_lng")).click();
		driver.findElement(By.xpath("(//*[@class='ng-binding ng-scope' and @value='R'])[1]")).click();
		driver.findElement(By.id("pr_lng_version_new_model")).click();
		driver.findElement(By.xpath("(//*[@class='ng-binding ng-scope' and @value='R-3.3.2'])[1]")).click();
		driver.findElement(By.id("add_artifacts_btn")).click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		driver.findElement(By.xpath(
				"(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload tar.gz/zip file'])[1]"))
				.click();

		Utilities.fileUpload(hubze);

		driver.findElement(
				By.xpath("(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload .csv file'])[1]"))
				.click();
		robot = new Robot();
		robot.setAutoDelay(3000);
		stringselection = new StringSelection(manifesto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(
				"(//*[@class='btn btn-primary btn-sm btn-file ng-scope'and @tooltip='Upload .xslx or .xml file'])[1]"))
				.click();
		Utilities.fileUpload(modelIO);
		driver.findElement(By.id("checksum_fv")).sendKeys(checkSumValue);
		
		driver.findElement(By.id("saveVersionBtn")).click();
		
		String testReportExpected = driver.findElement(By.xpath("//*[@class='badge badge-success ng-binding']"))
				.getText();
		Thread.sleep(50000);
		System.out.println(testReportExpected);
		String actual = "Tested & Saved";
		if (testReportExpected.equalsIgnoreCase(actual)) {
			System.out.println("Tested & Saved");
		} else {
			System.out.println("in-complete");
		}

	}

	

}
