package com.raqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RA_REIS {
	
	@FindBy(id = "hm_lft_sdbar_Models") public WebElement models;
	
	@FindBy( id = "hm_lp_smp") public WebElement add;
	
	@FindBy(id = "hm_lp_vview") public WebElement manage;
	
	public RA_REIS(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public void modelsMadule() {
		manage.click();
	}
	
	public void clickOnTheAdd() {
		add.click();
	}
	
	public void clickOnTheManage() {
		manage.click();
	}
	
}
