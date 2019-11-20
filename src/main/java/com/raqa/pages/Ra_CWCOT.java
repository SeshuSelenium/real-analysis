package com.raqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ra_CWCOT {
	public Ra_CWCOT(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Summary']") public WebElement summary;
	
	@FindBy(xpath = "//*[text()='Models']") public WebElement models;
	
	@FindBy(xpath = "//*[@class='glyphicon glyphicon-user']") public WebElement TeanetList;
	
	@FindBy(xpath = "//*[@class='menu']/child::li[8]") public WebElement reis;
	
	
	
	
	
	
}
