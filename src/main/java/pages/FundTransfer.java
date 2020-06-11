package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FundTransfer {

	WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Fund Transfers")
	private WebElement FundTransfer_btn;
	
	@FindBy(how=How.NAME,using="rbname")
	private WebElement Rec_Bank_Name;
	
	@FindBy(how=How.NAME,using="rname")
	private WebElement Rec_Name;
	
	@FindBy(how=How.NAME,using="accno")
	private WebElement AccNo;
	
	@FindBy(how=How.NAME,using="swift")
	private WebElement swift;
	
	@FindBy(how=How.NAME,using="amt")
	private WebElement Amount;
	
	@FindBy(how=How.ID,using="toption")
	public Select mySelectObj;
	
	@FindBy(how=How.NAME,using="dot")
	private WebElement date;
	
	@FindBy(how=How.NAME,using="desc")
	private WebElement desc;
	
	@FindBy(how=How.NAME,using="submitButton")
	private WebElement submitButton;
	
	@FindBy(how=How.NAME,using="token")
	private WebElement Transf_code;
	
	@FindBy(how=How.XPATH,using="//*[@value='Validate TAC']")
	private WebElement validate_TAC;
	
	@FindBy(how=How.XPATH, using="//input[@id='token']")
	private WebElement entertoken;
	

	public void clickFundTransfer_btn() {
		FundTransfer_btn.click();
	}

   public String verifyPageTitle() {
	   return driver.getTitle();
   }
	
	public void setRec_Bank_Name(String rec_Bank_Name) {
		Rec_Bank_Name.sendKeys(rec_Bank_Name);
	}


	public void setRec_Name(String rec_Name) {
		Rec_Name.sendKeys(rec_Name);
	}


	public void setAccNo(String accNo) {
		AccNo.sendKeys(accNo);
	}

	
	public void setSwift(String swift_no) {
		swift.sendKeys(swift_no);
	}


	public void setAmount(String amount) {
		Amount.sendKeys(amount);
	}

	

	public void setMySelectObj() {
		Select drop=new Select(driver.findElement(By.xpath("//select[@id='toption']")));		   
		   drop.selectByIndex(1);
		   }


	public void setDate(String datevariable) {
		date.sendKeys(datevariable);
	}


	public void setDesc(String description) {
		desc.sendKeys(description);
	}


	public void setToken(String token) {
		entertoken.sendKeys(token);
		
	}
		
	public void clickSubmitButton() {
		submitButton.click(); 
	}

	public void setTransfercode(String pin) {
		Transf_code.sendKeys(pin);;
	}
	
	
	public void setvalidateTAC() {
		validate_TAC.click();
	}
	
	public FundTransfer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


}
