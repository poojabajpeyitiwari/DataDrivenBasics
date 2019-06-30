package com.test.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.objects.GooglePage;
import com.test.resources.Base;

public class GoogleTest extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeMethod
	public void init() throws IOException {
		initializeDriver();
       log.info("driver is initialized");
	}

	@Test(dataProvider = "getData")
	public void googleSearch(String data1, String data2) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url2"));
		GooglePage gp = new GooglePage(driver);
		WebElement searchInputField = gp.getSearch();
		searchInputField.sendKeys(data1);
		searchInputField.sendKeys(Keys.ENTER);
		System.out.println(data2);
		log.info("msg printed successfully");
	}

	/*
	 * @Test public void googleSearch2() { GooglePage gp = new
	 * GooglePage(driver); WebElement searchInputField = gp.getSearch();
	 * searchInputField.sendKeys("kareena kapoor khan");
	 * searchInputField.sendKeys(Keys.ENTER); }
	 */
	@DataProvider()
	public Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream("D:/selenium practise doc/testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet xs = wb.getSheet("Sheet1");
		XSSFRow row = null;
		XSSFCell cell = null;
		int rowCount = xs.getPhysicalNumberOfRows();

		Object[][] data = new Object[rowCount][xs.getRow(0).getPhysicalNumberOfCells()];
		for (int i = 0; i < rowCount; i++) {
			row = xs.getRow(i);
			int colCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < colCount; j++) {
				cell = row.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		}
		/*
		 * data[0][0] = "planets"; data[0][1] = "Hi1";
		 * 
		 * data[1][0] = "kareena kapoor khan"; data[1][1] = "Hi2";
		 * 
		 * data[2][0] = "what is fire tv stick?"; data[2][1] = "Hi3";
		 * 
		 * data[3][0] = "best indian news channel"; data[3][1] = "Hi4";
		 */

		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
