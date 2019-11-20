package com.raqa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVersion {

	@FindBy(id = "createNewVersionTab") public WebElement createNewVersionTab;
	
	@FindBy(id = "modelName_fv_sel") public WebElement modelName;
	
	@FindBy(xpath = "(//*[@id='modelName_fv_sel'])[1]/child::option[2]")public WebElement ClickOnAutomation;
	
	@FindBy(id = "minorVer_hv") public WebElement minorVersionRadioButton;
	
	@FindBy(id = "majorVersions_hv") public WebElement majorVersionDropDown;
	
	@FindBy(xpath = "//*[@id='majorVersions_hv'])[1]/child::option[2]") public WebElement majerVersionValue;
	
	@FindBy(id = "version_desc_fv") public WebElement versionDescriction;
	
	@FindBy(xpath = "(//*[@tooltip='Upload Document'])[1]") public WebElement modelReleaseNoteBrowseButton;
	
	@FindBy(id = "pr_lng") public WebElement programingLanguageDropDown;
	
	@FindBy(id = "pr_lng_version_old_model") public WebElement programingLanguageVersion;
	
	@FindBy(id = "clr_btn") public WebElement clearButton;
	
	
	public CreateNewVersion(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTheCreateNewVersionTab() {
		createNewVersionTab.click();
	}
	
	public void ClickOnTheMadelName() {
		modelName.click();
	}
	
	public void clickOnTheAutomation() {
		ClickOnAutomation.click();
	}
	
	public void clickOnTheMinorRadioButton() {
		minorVersionRadioButton.click();
	}
	
	public void clickOnMajorVersionDropdown() {
		majorVersionDropDown.click();
		majerVersionValue.click();
	}
	
	public void modelRealeseNoteFileUpload() throws Exception {
		modelReleaseNoteBrowseButton.click();
		
		Robot robot = new Robot();
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection(
				"C:\\Users\\Nagasesha Reddy\\Desktop\\testRealAnalyse.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


		
	}
	
	
	
	
	
}
