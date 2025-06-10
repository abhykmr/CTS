package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {

	  public static void captureScreenShot(WebDriver driver1) throws IOException {
	        File src = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
	        try {
	            File dest = new File("src\\test\\resource\\MMT_scrrenshots\\" + timestamp() + " " + "make_my_trip.png");
	            FileUtils.copyFile(src, dest);
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public static String timestamp() {
	        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	    }

}
