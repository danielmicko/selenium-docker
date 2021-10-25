package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmation {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='login.php']")
    private WebElement signinLink;

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public RegistrationConfirmation(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToFlights(){
        this.wait.until(driver1 -> this.flightsLink.isDisplayed());
        this.flightsLink.click();

    }

}
