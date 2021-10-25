package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingAdressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "reserveFlights")
    private WebElement continueBtn;

    @FindBy(id = "input_53_addr_line1")
    private WebElement adress;

    @FindBy(id = "input_53_city")
    private WebElement city;

    @FindBy(id = "buyFlights")
    private WebElement nextBtn;

    @FindBy(id = "confirm-table")
    private WebElement confirmTable;

    public BillingAdressPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void continueFromFlights(){
        this.continueBtn.click();
        this.wait.until(driver1 -> nextBtn.isDisplayed());
    }

    public void fillBillingAdress(String adress, String city){
        this.adress.sendKeys(adress);
        this.city.sendKeys(city);
    }

    public void nextPage(){
        this.nextBtn.click();
        this.wait.until(driver1 -> this.confirmTable.isDisplayed());
    }

}
