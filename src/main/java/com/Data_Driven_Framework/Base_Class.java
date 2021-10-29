package com.Data_Driven_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver; // -----> null

	public static WebDriver get_Driver(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (type.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void ClickOnElement(WebElement element) {
		element.click();
	}

	public static void InputValueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void geturl(String url) {
		driver.get(url);
	}

	public static void dropdown(WebElement element, String type, String value) {
		Select s = new Select(element);

		switch (type) {
		case "byIndex":
			s.selectByIndex(Integer.parseInt(value));
			break;
		case "byValue":
			s.selectByValue(value);
			break;
		case "byVisibleText":
			s.selectByVisibleText(value);
			break;
		}

//		if (type.equalsIgnoreCase("byIndex")) {
//			int parseInt = Integer.parseInt(value);
//			s.selectByIndex(parseInt);
//
//		} else if (type.equalsIgnoreCase("byValue")) {
//			s.selectByValue(value);
//
//		} else if (type.equalsIgnoreCase("byVisibleText")) {
//			s.selectByVisibleText(value);
//		}
	}

	public static void Action_class(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static void iframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void Screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filename);
		FileUtils.copyFile(src, dest);
	}

	public static void JavascriptExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static void Particular_Data_Frame_Excel(String path, int row_index, int cell_index) throws IOException {

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheetAt = w.getSheetAt(0);
		Row row = sheetAt.getRow(row_index);
		Cell cell = row.getCell(cell_index);
		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {
//			Value = cell.getStringCellValue();
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
//			value = doub(numericCellValue);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
