package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory or OR(object repository)
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	// initializing page elements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// actions
	public String geturl(){
		return driver.getTitle();

	}
	
	public void enterlogindetails(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
	}
	
	public void clickonsubmit(){
		loginbtn.click();
	}
	
}
