package com.mmt_framework_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[@data-cy='closeModal']")
    WebElement closeModal;

    @FindBy(xpath = "//span[text()='Flights']")
    WebElement flightsTab;

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement roundTrip;

    @FindBy(id = "fromCity")
    WebElement fromCity;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromInput;

    @FindBy(id = "toCity")
    WebElement toCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toInput;

    @FindBy(xpath = "//label[@for='travellers']") 
    WebElement travellers;

    @FindBy(xpath = "//li[@data-cy='adults-2']")
    WebElement adults;

    @FindBy(xpath = "//li[@data-cy='travelClass-1']")
    WebElement travelClass;

    @FindBy(xpath = "//button[@data-cy='travellerApplyBtn']")
    WebElement applyButton;

    @FindBy(xpath = "//a[text()='Search']")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
       /* this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);*/
        


        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void closeModal() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeModal)).click();
        } catch (Exception e) {
            System.out.println("Close modal button not found or already closed.");
        }
    }

    public void clickFlightsTab() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", flightsTab);
    }

    public void clickRoundTrip() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roundTrip);
    }

    public void enterFromCity(String fromCityName) {
        fromCity.click();
        fromInput.sendKeys(fromCityName);
        WebElement fromOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(),'" + fromCityName + "')]")));
        fromOption.click();
    }

    public void enterToCity(String toCityName) {
        toCity.click();
        toInput.sendKeys(toCityName);
        WebElement toOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(),'" + toCityName + "')]")));
        toOption.click();
    }

    public void selectDepartureDate(String departureDate) throws Exception {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0, 180)");
         Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='" + departureDate + "']")).click();
    }

    public void selectReturnDate(String returnDate) throws Exception {
        driver.findElement(By.xpath("//div[@aria-label='" + returnDate + "']")).click();
        Thread.sleep(2000);
    }

    public void selectTravellersAndClass() throws InterruptedException {
   
    	/*  ===========================================================
    Departure date and current date keeps on changing so we have to use javascriptexecutor 
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0, 0)");
         Thread.sleep(2000);
    	   ============================================     */
    	
        travellers.click();
        adults.click();
        travelClass.click();
        
        /* ============================================
       js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0, 300)");
     Thread.sleep(2000);
        
        ==============================   */
        
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
        applyButton.click();
    }

    public void clickSearch() {
        searchButton.click();
    }
}