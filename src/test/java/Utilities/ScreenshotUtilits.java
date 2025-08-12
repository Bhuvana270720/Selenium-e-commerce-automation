package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtilits {
	
	public static String captureScreenshot(WebDriver driver,String screenshot) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/screenshots/" + screenshot + ".png";
		
		File destination = new File(dest);
		Files.createDirectories(destination.getParentFile().toPath());
        Files.copy(Source.toPath(), destination.toPath());

		return dest;
		
	}

}
