package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Sign out")
	public WebElement SignOutBtn;

	
	public void logout() {
		ClickButton(SignOutBtn);
	}
}
