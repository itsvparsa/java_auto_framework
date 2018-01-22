package step_definations;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class step_defs extends TestBase{
	LoginPage loginpage;
	
	public step_defs(){
		super();
	}
	
	@Given("^I navigate to heroku site$")
	public void Inavigatetoherokusite() throws Throwable {
		initialization();
		loginpage = new LoginPage();
		String title = loginpage.geturl();
		Assert.assertEquals(title, "The Internet");
	}
	
	@And("^I enter login details$")
	public void Ienterlogindetails() throws Throwable {
		loginpage.enterlogindetails(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@When("^I click on login button$")
	public void Iclickonloginbutton() throws Throwable {
		loginpage.clickonsubmit();	
	}
	
	@Then("^I am logged in$")
	public void Iamloggedin() throws Throwable {
	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	
	}
}
