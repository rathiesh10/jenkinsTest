package org.uttilities;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
   
	public static WebDriver driver;
	public  static void launchChrome() {
		
    	WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();

	}
	 public static void  loadUrl(String url) {
		driver.get(url);
		}
	public static void  winmax() {
		driver.manage().window().maximize();
	}
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}
	public static void  printCurrentUrl() {
	System.out.println(driver.getCurrentUrl());
			}
	//sendkeys
	public static void  fill(WebElement ele , String value) {
		ele.sendKeys(value);

	}
	public static void  btnClick(WebElement ele) {
		ele.click();

	}
	public static void  CloseChrome() {
		driver.close();

	}
	public static void RightClick(WebElement ele) {
	Actions a = new Actions(driver);
    a.contextClick(ele).perform();
	}
	public static String getData(int rowNumber , int cellNumber) throws IOException {
		File f = new File("C:\\Users\\rathiesh10\\eclipse-workspace\\dec13ProjectFramework\\testData\\student data.xlsx");
		  FileInputStream fin = new FileInputStream(f); 
		 Workbook w = new XSSFWorkbook(fin);
		  Sheet s = w.getSheet("Greens");
		  
		  Row row = s.getRow(rowNumber);
		  
		  Cell cell = row.getCell(cellNumber);
		    
		  int cellType = cell.getCellType();
		  
		 String value ="" ;
		  if (cellType==1) {
			     value = cell.getStringCellValue();
			     
		}  else if (cellType==0) {
			   if (DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,yyyy");
		 value = sim.format(d);
		 System.out.println(value);
		 
		 
			}else {
				double d = cell.getNumericCellValue();
				long l = (long)d;
				 value = String.valueOf(l);
				 System.out.println(value);
			
				
			}
		}
		 return value;  
		  
		  
		  
	}
	
	
	
	
	
	
	
	

	
}
