package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountStatement {
	
	WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Account Statement")
	private WebElement Account_Statement;
	
	@FindBy(how=How.XPATH,using= "/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr")
	List<WebElement> rownum;
	
	@FindBy(how=How.XPATH,using= "/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr[1]/th")
	List<WebElement> colnum;
	
	@FindBy(how=How.TAG_NAME,using = "tr")
	List<WebElement> rowVals;
	
	@FindBy(how=How.TAG_NAME,using = "th")
	List<WebElement> colHeader ;	

	@FindBy(how=How.XPATH, using ="/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div")
	WebElement trasnactionID;
	
	@FindBy(how=How.XPATH, using ="/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td[3]")
	WebElement transactionDesc;
	
	@FindBy(how=How.XPATH, using ="/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td[4]")
	WebElement cost;
	
	public void click_Account_Statement() {
		Account_Statement.click();
		}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String AccountStatement_Cost() {
		return cost.getText();
	}
	public String AccountStatement_ID() {
		return trasnactionID.getText();
		}
	
	public String AccountStatement_Desc() {
		return transactionDesc.getText();
		}
	
	public void Account_Statement_Data() {
		System.out.println("No of Rows in the Table:"+rownum.size());
		System.out.println("No of Coloumns in the Table:"+colnum.size());
		
		for(int i=0; i<colHeader.size(); i++){
			System.out.format("   |     "+colHeader.get(i).getText());
		}
		System.out.println();
		
		for(int i=0; i<=rownum.size(); i++){
			List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
			for(int j=0; j<=colnum.size(); j++){
					System.out.format("   |   "+colVals.get(j).getText());
				}
			System.out.println();
			}
		
	}
	
	public AccountStatement(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	

}
