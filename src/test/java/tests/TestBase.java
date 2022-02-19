package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;



public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"}) 

	public void startdriver (@Optional("chrome") String browsername) {
	 
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browsername.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@AfterSuite
	public void closedriver() {
		driver.quit();
	}
	
	@AfterMethod
	public void scrrenShotOnFailure(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
 
			System.out.println("Testcase was Failed");
			System.out.println("Taking ScreenShot ....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}

