package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignupPage;

public class SignUpwithDataProviderTest extends TestBase {

	CreateAccountPage createaccountObject;
	HomePage homeObject;
	SignupPage signupObject;
	MyAccountPage myaccountObject;

	@DataProvider (name = "testdata")
	public static Object[][] userData (){

		return new Object[][] {
			{"mohamed188@gmail.com","Mohamed","Ahmed","test@123","4","4","1994","Ahmed","Fakhry","Ahmed fakhry street"
			,"Nasr city","It-solution","cairo","6","12345","21","additional info",
			"022018506","0120073789","Alias"},
			
			{"rm14488@gmail.com","Rehab","Mohamed","test@123","4","4","1994","Mohamed","Abdo","street"
			,"Nasr city","company name","cairo","5","12345","21","additional info",
			"022018506","0120073789","Alias"}
		};
	}

	@Test(priority =1,alwaysRun = true, dataProvider = "testdata")
	public void opencreateaccountpage(
			String email,String csfname,String cslname,String pass,String day, String month,String year,
			String fname,String lname,String company,String address1,
			String address2,String city,String state,String postalcode,
			String country,String addiinfo,String homephone,String mopilephone,String alias
			) {

		homeObject = new HomePage(driver);
		homeObject.opensigninpage();
		createaccountObject = new CreateAccountPage(driver);
		createaccountObject.insertemailaddress(email);
		signupObject = new SignupPage(driver);
		signupObject.signup(csfname, cslname, pass,day,month,year,fname, lname, company, address1,address2,
				city,state, postalcode, country, addiinfo, homephone, mopilephone, alias);

		myaccountObject=new MyAccountPage(driver);
		Assert.assertTrue(myaccountObject.SignOutBtn.isDisplayed());
		myaccountObject = new MyAccountPage(driver);
		myaccountObject.logout();
		Assert.assertTrue(createaccountObject.SignInBtn.isDisplayed());
	}

}
