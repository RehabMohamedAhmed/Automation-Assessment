package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Sign in")
	public WebElement SignInBtn;
	
	@FindBy(id = "email_create")
	WebElement emailaddresstxt;

	@FindBy( id = "SubmitCreate")
	WebElement createaccountbtn;
	
	
	
	public void insertemailaddress(String emailaddressvalue) {
		SetText(emailaddresstxt, emailaddressvalue);
		ClickButton(createaccountbtn);
	}
	
}
