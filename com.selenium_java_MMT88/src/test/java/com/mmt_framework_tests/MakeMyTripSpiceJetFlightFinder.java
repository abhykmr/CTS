package com.mmt_framework_tests;




import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmt_framework_pages.Keywords;
import com.utility.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MakeMyTripSpiceJetFlightFinder {
	
	
	
   /*   ============================================================================================
    * 
    * Here in this code we can provide the chromedriver path to launch chromebrowser in 3.x version 
    * 
    *  ============================================================================================
    *  WebDriver driver;
    Keywords keywords;

    @BeforeClass
    public void setUp() throws IOException {
        // Set path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src\\test\\resource\\Drivers\\chromedriver.exe");

        // Disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        // Launch browser
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        keywords = new Keywords(driver);
        CaptureScreenShot.captureScreenShot(driver);
    }
    ===================================================================================
    */
	
	  private WebDriver driver;
	    private Keywords keywords;

	    @BeforeClass
	    public void setUp() throws IOException {
	        // Setup ChromeDriver using WebDriverManager
	    //	WebDriverManager 
	    //    WebDriverManager.chromedriver().setup(); // It's not working due to some reason 

	        // Disable notifications
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--remote-allow-origins=*");

	        // Launch browser
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();

	        // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	        // Initialize Keywords and CaptureScreenShot
	        keywords = new Keywords(driver);
	        CaptureScreenShot.captureScreenShot(driver);
	    }

    @Parameters({"departureDate", "returnDate"})
    @Test
    public void findSpiceJetFlights(String departureDate, String returnDate) throws Exception {
        // Read data from Excel file
   
    	  String filepath="src\\test\\resource\\MMT_DATA\\cities.xlsx";
    	String[] cities = ExcelReader.readCities(filepath);
      String fromCity = cities[0];
      String toCity = cities[1];

    	
     /*   kept this code in com.utility package 
      * =====================================================================
      * FileInputStream fis = new FileInputStream("C:\\java_training\\com.selenium_java_MMT88\\src\\test\\resource\\MMT_DATA\\cities.xlsx");
        try (Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1); // Assuming data is in the second row
            Cell fromCityCell = row.getCell(0);
            Cell toCityCell = row.getCell(1);
            String fromCity = fromCityCell.getStringCellValue();
            String toCity = toCityCell.getStringCellValue();
            fis.close();
            ====================================================================
*/
            // Perform actions using keywords
            keywords.openMakeMyTrip();
            Thread.sleep(3000);  // increase this if Internet is slow
            CaptureScreenShot.captureScreenShot(driver);
            keywords.closeModal();
            CaptureScreenShot.captureScreenShot(driver);
            keywords.clickFlightsTab();
            keywords.clickRoundTrip();
            CaptureScreenShot.captureScreenShot(driver);
            keywords.enterFromCity(fromCity);
            keywords.enterToCity(toCity);
            CaptureScreenShot.captureScreenShot(driver);
            keywords.selectDepartureDate(departureDate);
            keywords.selectReturnDate(returnDate);
            CaptureScreenShot.captureScreenShot(driver);
            keywords.selectTravellersAndClass();
            CaptureScreenShot.captureScreenShot(driver);
            keywords.clickSearch();
            CaptureScreenShot.captureScreenShot(driver);

            // Wait for results to load
            Thread.sleep(15000); // increase this if Internet is slow

            // Get and print SpiceJet flight details
            List<WebElement> spiceJetFlights = driver.findElements(
                By.xpath("//span[contains(text(),'SpiceJet')]/ancestor::div[@class='listingCard']")
            );

            for (WebElement flight : spiceJetFlights) {
                System.out.println("------ SpiceJet Flight ------");
                System.out.println(flight.getText());
                System.out.println("-----------------------------\n");
            }

            // Capture screenshot
            CaptureScreenShot.captureScreenShot(driver);      
            }
    

 
    @AfterClass
    public void tearDown() {
        // Close browser
    	System.out.println("=======browser closed ======");
        driver.quit();
    }
}