package check;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.raqa.TestBase.TestBase;
import com.raqa.pages.RealAnalistLogin;

public class LoginDemo{
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup12() {
		
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://rauat.modeloncloud.com/umg-admin/login");
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
