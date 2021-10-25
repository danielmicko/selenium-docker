package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "confirm-table")
    private WebElement confirmTable;

    @FindBy(xpath = "//font[contains(text(),'Flight Itinerary Page')]")
    private WebElement confirmText;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> confirmUsd;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String getPrice(){
        this.wait.until(driver1 -> this.confirmTable.isDisplayed());
        System.out.println(this.confirmUsd.get(1).getText());
        System.out.println(this.confirmUsd.get(2).getText());
        return this.confirmUsd.get(1).getText();
    }

}
