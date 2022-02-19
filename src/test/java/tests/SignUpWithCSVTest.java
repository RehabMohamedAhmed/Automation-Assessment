package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignupPage;

public class SignUpWithCSVTest extends TestBase {

	CreateAccountPage createaccountObject;
	HomePage homeObject;
	SignupPage signupObject;
	MyAccountPage myaccountObject;
	
	CSVReader reader;

	@Test(priority =1,alwaysRun = true)
	public void opencreateaccountpage() throws Exception, IOException{

		String csvfilepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\RegistrationData.csv";
		reader= new CSVReader(new FileReader(csvfilepath));
		String[] csvcell;    

		while ((csvcell=reader.readNext())!= null) {

			String email=csvcell[0];
			String csfname=csvcell[1];
			String cslname=csvcell[2];
			String pass=csvcell[3];
			String day=csvcell[4];
			String month=csvcell[5];
			String year=csvcell[6];
			String fname=csvcell[7];
			String lname=csvcell[8];
			String company=csvcell[9];
			String address1=csvcell[10];
			String address2=csvcell[11];
			String city=csvcell[12];
			String state=csvcell[13];
			String postalcode=csvcell[14];
			String country=csvcell[15];
			String addiinfo=csvcell[16];
			String homephone=csvcell[17];
			String mopilephone=csvcell[18];
			String alias=csvcell[19];
				
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
	}}
}
