package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler; 

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.nio.file.Files;


public class Screenshot {

	
	 public static String takeScreenshot(WebDriver driver, String scenarioName) throws IOException{
	
		 String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		 String screenshotName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
		 String screenshotPath = "target/Screenshot/" + screenshotName;
		 
		 
		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File(screenshotPath);

		 
		 try {
		Files.createDirectories(dest.getParentFile().toPath());
		Files.copy(src.toPath(), dest.toPath());
			 } catch (IOException e) {
			System.out.println("Screenshot save failed: " + e.getMessage());
		}

		return screenshotPath;
		
		
	 }}
	        