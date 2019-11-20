package com.raqa.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetModelDetails {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.get("https://rauat.modeloncloud.com/umg-admin/");

		driver.findElement(By.id("j_username")).sendKeys("sysadmin");

		driver.findElement(By.id("j_password")).sendKeys("Welcome1");

		driver.findElement(By.xpath("//p[@class='login button']//a//input")).click();

		WebElement user = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//i"));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@class='dropdown notifications-menu']//a[@class='dropdown-toggle']")).click();
		;

		driver.findElement(By.xpath("//ul[@class='menu']/child::li[8]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		WebDriverWait ww = new WebDriverWait(driver, 10);

		ww.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'REIS')]"))));

		//// a[@id='hm_lp_vview']

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@id='hm_lft_sdbar_Models']")).click();

		driver.findElement(By.xpath("//li[@id='umgVersionView']")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*"));

		System.out.println(list.size());

		for (int i = 1; i <= list.size(); i++) {

			System.out.println("===================================" + i + " Row details =====================================");

			String ModelName = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 1 + "]")).getText();

			System.out.println("ModelName  : " + ModelName);

			String Version = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 2 + "]")).getText();

			System.out.println("Version :" + Version);

			String Description = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 3 + "]")).getText();

			System.out.println("Description " + Description);

			String LastUpdateBy = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 4 + "]")).getText();

			System.out.println("LastUpdateBy " + LastUpdateBy);

			String LastUpdateDate = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 5 + "]")).getText();

			System.out.println("LastUpdateDate :" + LastUpdateDate);

			String Status = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 6 + "]")).getText();

			System.out.println("Status :" + Status);

			String ModelType = driver.findElement(By.xpath("//div[@class='ag-body-viewport']/child::*[1]/child::*[" + i + "]/child::*[" + 7 + "]")).getText();

			System.out.println("ModelType :" + ModelType);
		}

	}

}
