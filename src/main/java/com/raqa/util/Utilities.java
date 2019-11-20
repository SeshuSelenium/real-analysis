package com.raqa.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public static WebDriver driver;
	public static String scrpath = "C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\screenshot\\scr.jpg";

	public static String getStringValue() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String genareated = dtf.format(now);
		return genareated;
	}

	public static void screenshot(String screenshotfilePath) throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtil.copyFile(src, new File(screenshotfilePath));
	}

	public static void fileUpload(String path) throws Exception {
		Robot robot = new Robot();
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection(path);
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
	
	public String renameFile() throws IOException {
		InputStream input = new FileInputStream(
				"C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\src\\main\\java\\com\\raqa\\config\\config1.properties");
		Properties prop = new Properties();
		// load a properties file
		prop.load(input);
		// get the property value and print it out
		String s = prop.getProperty("filePath");
		String s2 = s.substring(0, s.length() - 6);
		File oldfile = new File(s);
		File newfile = new File(s2.substring(0, 52) + System.currentTimeMillis() + ".tar.gz");
		//System.out.println(newfile);
		OutputStream output = new FileOutputStream(
				"C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\src\\main\\java\\com\\raqa\\config\\config1.properties");
		if (oldfile.renameTo(newfile)) {
			System.out.println("Rename succesful");
		} else {
			System.out.println("Rename failed");

		}
		String absolutePath = newfile.getAbsolutePath();
		Properties prop2 = new Properties();
		prop2.setProperty("filePath", absolutePath);
		prop2.store(output, "");
		// load a properties file
		return absolutePath;
	}

	
	

}
