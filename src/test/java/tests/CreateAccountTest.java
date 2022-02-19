package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignupPage;

public class CreateAccountTest extends TestBase{

	
	
	String email= "jil9iug@gmail.com";
	String csfname = "rehab";
	String cslname = "mohamed";
	String pass = "test@123";
	String index_of_days="4";
	String index_of_months="4";
	String index_of_years="1994";
	String fname = "ahmed";
	String lname = "fhakry";
	String address1 = "AhmedFajrystreet";
	String address2="Nasr city";
	String company ="Itsolution";
	String city = "cairo";
	String state="4";
	String postalcode = "12345";
	String country ="21";
	String addiinfo = "additional info";
	String homephone = "022018506";
	String mopilephone = "0120073789";
	String alias = "Alias";

	
	CreateAccountPage createaccountObject;
	HomePage homeObject;
	SignupPage signupObject;
	MyAccountPage myaccountObject;
	
	
	@Test(priority =1,alwaysRun = true)
	public void opencreateaccountpage() {
	
		homeObject = new HomePage(driver);
		homeObject.opensigninpage();
		createaccountObject = new CreateAccountPage(driver);
		createaccountObject.insertemailaddress(email);
		signupObject = new SignupPage(driver);
		signupObject.signup(csfname, cslname, pass,index_of_days,index_of_months,index_of_years,fname, lname, company, address1,address2, city,state, postalcode, country, addiinfo, homephone, mopilephone, alias);
	    
		myaccountObject=new MyAccountPage(driver);
		Assert.assertTrue(myaccountObject.SignOutBtn.isDisplayed());

		
	}	
    @Test(dependsOnMethods ="opencreateaccountpage")
    public void logout() {
    	myaccountObject = new MyAccountPage(driver);
    	myaccountObject.logout();
		Assert.assertTrue(createaccountObject.SignInBtn.isDisplayed());
}
}
