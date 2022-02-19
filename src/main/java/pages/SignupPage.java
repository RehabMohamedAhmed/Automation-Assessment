package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends PageBase {

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "id_gender2")
	WebElement genderradiobutton;

	@FindBy(id = "customer_firstname")
	WebElement csfnametext;

	@FindBy(id = "customer_lastname")
	WebElement cslnametext;

	@FindBy(id = "passwd")
	WebElement passtext;

	@FindBy(id = "days")
	WebElement daysdropdown;

	@FindBy(id = "months")
	WebElement monthsdropdown;

	@FindBy(id = "years")
	WebElement yearsdropdown;

	@FindBy(id = "newsletter")
	WebElement newslettercheckbox;

	@FindBy(id = "optin")
	WebElement optincheckbox;

	@FindBy(id = "firstname")
	WebElement fnametext;

	@FindBy(id = "lastname")
	WebElement lnametext;

	@FindBy(id = "company")
	WebElement companytext;

	@FindBy(id = "address1")
	WebElement address1text;

	@FindBy(id = "address2")
	WebElement address2text;

	@FindBy(id = "city")
	WebElement citytext;

	@FindBy(id = "id_state")
	WebElement statedropdown;

	@FindBy(id = "postcode")
	WebElement postcodetext;	

	@FindBy(id = "id_country")
	WebElement countrydropdown;

	@FindBy(id = "other")
	WebElement additionalArea;

	@FindBy(id = "phone")
	WebElement phonetext;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobiletext;

	@FindBy(id = "alias")
	WebElement aliastext;

	@FindBy(id = "submitAccount")
	WebElement submitbtn;



	public void signup(
			String csfname, String cslname , String pass,String day, String month, String year ,String fname, String lname,
			String company,String address1,String address2, String city, String state,
			String postalcode, String country, String Addinfo, String hphone,
			String mphone, String alias
			){
		genderradiobutton.click();
		SetText(csfnametext, csfname);
		SetText(cslnametext, cslname);
		SetText(passtext, pass);
		selectvalue(daysdropdown, day);
		selectvalue(monthsdropdown, month);
		selectvalue(yearsdropdown, year);
		newslettercheckbox.click();
		optincheckbox.click();
		SetText(fnametext, fname);
		SetText(lnametext, lname);
		SetText(companytext, company);
		SetText(address1text, address1);
		SetText(address2text, address2);
		SetText(citytext, city);
		selectvalue(statedropdown, state);
		SetText(postcodetext, postalcode);
		selectvalue(countrydropdown, country);
		SetText(additionalArea, Addinfo);
		SetText(phonetext, hphone);
		SetText(phone_mobiletext, mphone);
		SetText(aliastext, alias);
		ClickButton(submitbtn);
	}
}
