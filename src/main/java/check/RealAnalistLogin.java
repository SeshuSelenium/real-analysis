package check;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raqa.TestBase.TestBase;

import check.LogInPageTest;

public class RealAnalistLogin{

	public WebDriver driver;

	@FindBy(name = "j_username")  WebElement log_In_Id;

	@FindBy(name = "j_password")  WebElement logIn_Password;

	@FindBy(xpath = "//*[@class='login button']/child::a/input") WebElement logIn_Button;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]") WebElement forgot_Password;
	
	@FindBy(xpath = "//span[contains(text(),'CWCOT')]")  WebElement cwcot;

	
//	public RealAnalistLogin(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}

	public String valiDataLoginPageTitle() {
		return driver.getTitle();
	}

	public void realAnalist_login(String enter_user_id, String enter_password) {
		log_In_Id.sendKeys(enter_user_id);
		logIn_Password.sendKeys(enter_password);
		logIn_Button.click();
		System.out.println(cwcot.getText());
		
	}

	public void click_forgotPassword() {
		forgot_Password.click();
	}
	

}
