package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement passengerCount;

    @FindBy(xpath = "//select[@name='fromPort']")
    private WebElement departingFrom;

    @FindBy(xpath = "//select[@name='fromMonth']")
    private WebElement departingMonth;

    @FindBy(xpath = "//select[@name='fromDay']")
    private WebElement departingDay;

    @FindBy(xpath = "//select[@name='toPort']")
    private WebElement arrivingIn;

    @FindBy(xpath = "//select[@name='toMonth']")
    private WebElement returningMonth;

    @FindBy(xpath = "//select[@name='toDay']")
    private WebElement returningDay;

    @FindBy(id = "findFlights")
    private WebElement flightsBtn;

    public FlightsDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengerCount(String count){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengerCount));
        Select select = new Select(this.passengerCount);
        select.selectByValue(count);
    }

    public void selectDepartingFrom(String from){
        Select select = new Select(this.departingFrom);
        select.selectByValue(from);
    }

    public void selectDepartingMonth(String month){
        Select select = new Select(this.departingMonth);
        select.selectByValue(month);
    }

    public void selectDepartingDay(String day){
        Select select = new Select(this.departingDay);
        select.selectByValue(day);
    }

    public void selectArrivingTo(String to){
        Select select = new Select(this.arrivingIn);
        select.selectByValue(to);
    }

    public void selectArrivingMonth(String month){
        Select select = new Select(this.returningMonth);
        select.selectByValue(month);
    }

    public void selectArrivingDay(String day){
        Select select = new Select(this.returningDay);
        select.selectByValue(day);
    }

    public void continueToFlights(){
        this.flightsBtn.click();
    }

}
