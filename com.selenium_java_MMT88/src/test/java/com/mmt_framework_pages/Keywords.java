package com.mmt_framework_pages;




import org.openqa.selenium.WebDriver;

public class Keywords {
    WebDriver driver;
    HomePage homePage;

    public Keywords(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

   

	public void openMakeMyTrip() {
        driver.get("https://www.makemytrip.com/flights/");
    }

    public void closeModal() {
        homePage.closeModal();
    }

    public void clickFlightsTab() {
        homePage.clickFlightsTab();
    }

    public void clickRoundTrip() {
        homePage.clickRoundTrip();
    }

    public void enterFromCity(String fromCity) {
        homePage.enterFromCity(fromCity);
    }

    public void enterToCity(String toCity) {
        homePage.enterToCity(toCity);
    }

    public void selectDepartureDate(String departureDate) throws Exception {
        homePage.selectDepartureDate(departureDate);
    }

    public void selectReturnDate(String returnDate) throws Exception {
        homePage.selectReturnDate(returnDate);
    }

    public void selectTravellersAndClass() throws InterruptedException {
        homePage.selectTravellersAndClass();
    }

    public void clickSearch() {
        homePage.clickSearch();
    }
}