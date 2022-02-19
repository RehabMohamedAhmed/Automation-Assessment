package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take screenshot when the testcase fail 
	// static 3shan ast5dm l method de mn 8eer ma create object mn class da
	
	
// l method static 3shan lma agy a3mlha call mosh lazm a5od object mn class (helper) 
	// kfaya eni a3ml Helper.mehodname()
	public static void captureScreenshot (WebDriver driver , String screenshotname) {

		Path dest = Paths.get("./Screenshots",screenshotname+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
	}
}
