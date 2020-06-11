package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class BrowserConfig {
	
	public static WebDriver driver;
	public String path = "src/main/java/drivers/";
	
    public BrowserConfig(String browserName) {
        String browser = browserName.toLowerCase();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/main/java/newdriver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://demo.rapidtestpro.com/login.php");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", path + "IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;

            default:
                System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
    }
    
    public void takeScreenShot(String sc) throws IOException {
    	
       TakesScreenshot scr= ((TakesScreenshot)driver);
	    
	    File source= scr.getScreenshotAs(OutputType.FILE);
	    
	    File desc= new File("src/main/java/screenshots/"+sc+".jpg");
	    
	    FileUtils.copyFile(source,desc);

    }
   
    public String readDataFromExcel(int rownum,int columnnum) throws IOException {
    		
    		String filename="src/main/java/data/SampleData.xlsx";	
    		String cellvalue="";
    		
    		FileInputStream fio=new FileInputStream(filename);
    		
    		
    		XSSFWorkbook workbook=new XSSFWorkbook(fio);//open the workbook
    		
    		XSSFSheet sheet=workbook.getSheetAt(0);//get the sheet at index 0
    		
    		Row row=sheet.getRow(rownum);//get the row number
    		
    		Cell col=row.getCell(columnnum);//get the cell number
    		
    		if (col.getCellType() == Cell.CELL_TYPE_STRING) {		
    			
    			 cellvalue=col.getStringCellValue();
    			}
    			else if(col.getCellType() == Cell.CELL_TYPE_NUMERIC) {
    				
    			 cellvalue=NumberToTextConverter.toText(col.getNumericCellValue());
    			}
    			return cellvalue;	    		
    	}
    
  }
