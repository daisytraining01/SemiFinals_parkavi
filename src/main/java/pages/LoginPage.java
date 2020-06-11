package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserConfig;


public class LoginPage  {
	WebDriver driver;
	
	@FindBy(how=How.NAME, using="accno")
	private WebElement accountNumber;

	@FindBy(how=How.NAME, using="pass")
	private WebElement password;	
	
	@FindBy(how=How.XPATH, using="//input[@value='Login Now ! ']")
	private WebElement LoginButton;

	@FindBy(how=How.NAME, using="accpin")
	private WebElement pinNumber;
	
	@FindBy(how=How.XPATH, using="//input[@value='Validate PIN ']")
	private WebElement validatePIN;
	
	@FindBy(how=How.XPATH, using="//div[@class='errorMessage']")
	private WebElement loginErrorMsg;
	
	public void setAccountNumber(String acctnum) {
		accountNumber.sendKeys(acctnum);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);		
	}

   public void setPinNumber(String pinnum) {
	   pinNumber.sendKeys(pinnum);
	}

public void clickLoginButtom() {
	   LoginButton.click();	   
   }

   public void clickValidatePIN() {
	   validatePIN.click();
   }
   
   public String verifyTitle() {
	   return driver.getTitle();
   }
   
   public String loginErrorMsg() {
	   return loginErrorMsg.getText();
   }
   
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
