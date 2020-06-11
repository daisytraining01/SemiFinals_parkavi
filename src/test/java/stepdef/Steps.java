package stepdef;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountDetails;
import pages.AccountStatement;
import pages.AccountSummary;
import pages.FundTransfer;
import pages.LoginPage;
import utility.BrowserConfig;

public class Steps{	
	
//	public static WebDriver driver;
	BrowserConfig bg=new BrowserConfig("chrome");	
	LoginPage lp=new LoginPage(bg.driver);
	AccountDetails ad=new AccountDetails(bg.driver);
	AccountSummary as=new AccountSummary(bg.driver);
	AccountStatement st=new AccountStatement(bg.driver);
	FundTransfer ft=new FundTransfer(bg.driver);
	
	
	@Given("User is able to enter the AccountNumber")
	public void user_is_able_to_enter_the_AccountNumber() {	
//		System.setProperty("webdriver.chrome.driver","src/main/java/newdriver/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://demo.rapidtestpro.com/login.php");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);        
        lp.setAccountNumber("1234556666");
     }

	@Given("User is able to enter the Password")
	public void user_is_able_to_enter_the_Password() throws IOException {	
		
		lp.setPassword("MavDemo@01");
		bg.takeScreenShot("AccountNumber and Password");
	   	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		
		lp.clickLoginButtom();
	   	}

	@Then("User should be navigated to the Login Step{int} page")
	public void user_should_be_navigated_to_the_Login_Step_page(Integer int1) {
		
		String actual=lp.verifyTitle();
		String expected="Online Banking - www.TechZoo.org";
		assertEquals("Login Page Title checked", expected, actual);
			  	}

	@Then("User enters the PIN Number")
	public void user_enters_the_PIN_Number() throws IOException {
		lp.setPinNumber("12345");
		bg.takeScreenShot("PINNumber");
			    }

	@Then("User clicks validate PIN")
	public void user_clicks_validate_PIN() {
		lp.clickValidatePIN();
		
	}
	
	@Given("User is able to enter the Invalid AccountNumber")
	public void user_is_able_to_enter_the_Invalid_AccountNumber() {		
		  lp.setAccountNumber("12345");
	}

	@Given("User is able to enter the Incorrect Password")
	public void user_is_able_to_enter_the_Incorrect_Password() {		
		lp.setPassword("abcdefg");
	 	}

	@Then("User checks error message is displayed")
	public void user_checks_error_message_is_displayed() throws IOException, InterruptedException {
		Thread.sleep(2000);
		bg.takeScreenShot("Login ErrorMsg");
		String expected="Not valid account number or password or Account is not Active. Please try again or contact to support.";
		String actual=lp.loginErrorMsg();
		assertEquals(expected,actual);
		System.out.println("THE ERROR MESSAGE IS: "+actual);
	  	}

	@Given("User clicks Account Summary")
	public void user_clicks_Account_Summary() throws InterruptedException, IOException {
	
	   as.clickAccountSummary();
	   Thread.sleep(3000);
	   bg.takeScreenShot("Account Summary");
	}

	@When("User verify page title")
	public void user_verify_page_title() throws InterruptedException {
		Thread.sleep(3000);
		String actual=as.verifyTitle();
		String expected="Account Sumamry";
		assertEquals("Account Summary Page Title checked", expected, actual);
        System.out.println("THE PAGE TITLE IS: "+actual);
	    	}

	@When("User gets the transaction details")
	public void user_gets_the_transaction_details() {
		String s1 = as.SelectTransactionId();
		String s2=as.SelectTransactiondescription();
		System.out.println("******The Transaction details has been generated*******");
		System.out.println(s1);
		System.out.println(s2);
	   	}

	@Then("User checks available credit balance")
	public void user_checks_available_credit_balance() throws InterruptedException {
	  String balance=as.checkBalance();
	  System.out.println(balance);
	}

	@Given("User clicks Account Details")
	public void user_clicks_Account_Details() throws InterruptedException, IOException {
		ad.ClickAccountdetails();
		Thread.sleep(3000);
		bg.takeScreenShot("Account Details");
	   	}

	@When("User verify Account Details page title")
	public void user_verify_Account_Details_page_title() throws InterruptedException {
		Thread.sleep(2000);
		String actual=ad.verifyTitle();
		String expected="View Account Details";
		assertEquals(expected, actual);
        System.out.println("THE PAGE TITLE IS: "+actual);
	    
	    }
	@Then("User validates UserName and Email id")
	public void user_validates_UserName_and_Email_id() {
		String s1 = "TOUSIF KHAN";
		String s2 = "renishk@maveric-systems.com";
		String str1 = ad.getAccountName();
		String str2 = ad.getEmailId();
		if(s1.equals(str1)&&s2.equals(str2))
		{
			System.out.println("The User name and Email id is validated Successfully");
			System.out.println("The UserName is: "+str1);
			System.out.println("The Email ID is: "+str2);
		}
		else
		{
			System.out.println("Failed");
		}
	}

	@Given("User clicks Account Statement")
	public void user_clicks_Account_Statement() throws InterruptedException, IOException {		
		st.click_Account_Statement();
		Thread.sleep(2000);
	    bg.takeScreenShot("Account Statement");
		   
	   }

	@When("User verify Account Statement page title")
	public void user_verify_Account_Statement_page_title() throws InterruptedException {
		Thread.sleep(2000);
		String actual=st.verifyTitle();
		String expected="Account Statement";
		assertEquals(expected, actual);
        System.out.println("THE PAGE TITLE IS: "+actual);

	}

	@Then("User gets the Account Statement")
	public void user_gets_the_Account_Statement() {
		System.out.println("*******Recent Transaction Details*****");
		System.out.println("Transaction ID is: "+st.AccountStatement_ID());
		System.out.println("Transaction Description is: "+st.AccountStatement_Desc());
		System.out.println("Transaction Amount is: "+st.AccountStatement_Cost());
	}

	@Given("User clicks Fund Transfer")
	public void user_clicks_Fund_Transfer() throws InterruptedException, IOException {
		ft.clickFundTransfer_btn();
		Thread.sleep(200);
		bg.takeScreenShot("Fund Transfer");
	   }

	@When("User verify Fund Transfer page title")
	public void user_verify_Fund_Transfer_page_title() throws InterruptedException {
		Thread.sleep(2000);
		String actual=ft.verifyPageTitle();
		String expected="Fund Transfers";
		assertEquals(expected, actual);
        System.out.println("THE PAGE TITLE IS: "+actual);
        
	  }

	@When("User provides neccessary details for fund transfer")
	public void user_provides_neccessary_details_for_fund_transfer() throws IOException, InterruptedException {
		
		ft.setRec_Bank_Name(bg.readDataFromExcel(1, 0));
		ft.setRec_Name(bg.readDataFromExcel(1, 1));
		ft.setAccNo(bg.readDataFromExcel(1, 2));
		ft.setSwift(bg.readDataFromExcel(1, 3));
		ft.setAmount(bg.readDataFromExcel(1, 4));
		ft.setMySelectObj();
		ft.setDate(bg.readDataFromExcel(1, 5));
		ft.setDesc(bg.readDataFromExcel(1, 6));				
		bg.takeScreenShot("Fund Transfer Details");
		Thread.sleep(2000);
		ft.clickSubmitButton();		
	}

	@Then("User clicks Fund Transfer button")
	public void user_clicks_Fund_Transfer_button() throws IOException, InterruptedException {
		ft.setToken("123456");		
		Thread.sleep(2000);
		bg.takeScreenShot("Transfer Details");
		ft.clickSubmitButton();
	 }

}
