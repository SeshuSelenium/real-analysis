package com.raqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenentSelection {
	
	@FindBy(xpath = "//*[@class='dropdown notifications-menu']/a/i") public WebElement tenentButton;
	
	@FindBy(xpath = "//*[@class='menu']/child::li[8]") public WebElement clickOnREIS;
	
	@FindBy(xpath = "//*[text()='Yes") public WebElement clickYesInPop_up;
	
	@FindBy(xpath = "//*[text()='No']") public WebElement clickNoInPop_up;
	
	public TenentSelection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTenentIcan() {
		
		tenentButton.click();
	}
	
	public void clickOnReis() {
		clickOnREIS.click();
	}
	
	public void clickOnYesInPop_up() {
		clickYesInPop_up.click();
	}
	
	public void clickOnNoPop_up() {
		clickNoInPop_up.click();
	}
}
