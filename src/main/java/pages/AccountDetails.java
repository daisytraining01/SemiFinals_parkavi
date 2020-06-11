package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserConfig;

public class AccountDetails {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Account Details']")
	private WebElement ClickAccountdetails;

	@FindBy(how = How.XPATH, using = "//input[@name='rbname']")
	private WebElement getAccountName;

	@FindBy(how = How.XPATH, using = "//span/input[@name='rname']")
	private WebElement getEmailId;

	public String getAccountName() {
		return getAccountName.getAttribute("value");
	}

	public String getEmailId() {
		return getEmailId.getAttribute("value");
	}

	public void ClickAccountdetails() {
		ClickAccountdetails.click();
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public AccountDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
