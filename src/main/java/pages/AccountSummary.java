package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserConfig;

public class AccountSummary {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//a[text()='Account Summary']")
	private WebElement AccountSummary;

	
	@FindBy(how=How.XPATH, using="//*[@id=\"AccountSummaryPanel\"]/div/div[1]/table/tbody/tr[2]/td[2]/div")
	private WebElement SelectTransactionId;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"AccountSummaryPanel\"]/div/div[1]/table/tbody/tr[2]/td[3]")
	private WebElement SelectTransactiondescription;
	
	@FindBy(how=How.XPATH, using="//strong[contains(text(),'Available Credit Balance')]")
	private WebElement creditBalance;
	
	
	 public void clickAccountSummary() {
		 
		 String href="/view/?v=Summary";
		 List<WebElement> anchors = driver.findElements(By.tagName("a"));	
		 Iterator<WebElement> iter = anchors.iterator();    
		    
		     while(iter.hasNext()) {
		    	 
		           WebElement anchor = iter.next();
		        
		        if(anchor.getAttribute("href").contains(href)) {
		        	
		            anchor.click();
		            break;
		        }
		     }
		  
	   }
	   
	   public String SelectTransactionId() {
		   return SelectTransactionId.getText();
	   }
	   public String SelectTransactiondescription() {
		return SelectTransactiondescription.getText();
		
	   }
	   public String verifyTitle() {
		   return driver.getTitle();
	}
	   public String checkBalance() throws InterruptedException {
		   
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  Thread.sleep(2000);
		   return creditBalance.getText();
	   }
	   
		public AccountSummary(WebDriver driver) {
		   this.driver=driver;
			PageFactory.initElements(driver, this);
		}


}
