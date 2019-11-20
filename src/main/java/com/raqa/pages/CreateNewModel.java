package com.raqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewModel {

	@FindBy(id = "createNewModelTab") public WebElement creatNewModelTab;
	
	@FindBy(id = "modelName_fv") public WebElement modelName;
	
	@FindBy(id = "model_desc_fv") public WebElement modelDescription;
	
	@FindBy(xpath = "(//div[@class='btn btn-primary btn-sm btn-file ng-scope'])[1]") public WebElement modelReleseNotesBrowsButton;
	
	@FindBy(id = "pr_lng") public WebElement programingLanguageDropDown;
	
	@FindBy(id = "pr_lng_version_new_model") public WebElement programingLang_version_DropDown;
	
	@FindBy(id = "add_artifacts_btn") public WebElement next_add_artifacts_btn;
	
	@FindBy(id = "clr_btn") public WebElement clearButton;

	@FindBy(xpath = "(//*[@tooltip= 'Upload tar.gz/zip file'])[1]") public WebElement r_model_ZipBrowseButton;
	
	@FindBy(xpath = "(//*[@tooltip= 'Upload .csv file'])[1]") public WebElement manifestFileBrowseButton;
	
	@FindBy(xpath = "(//*[@tooltip= 'Upload .xslx or .xml file'])[1]") public WebElement model_Io_DefinationBrowseButton;
	
	@FindBy(name = "checksum") public WebElement check_SumTextBox;
	
	@FindBy(id = "saveVersionBtn") public WebElement validate_and_save;
	
	@FindBy(id = "clr_btn_1") public WebElement clearButtonForModel;
}
