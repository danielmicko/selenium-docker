package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passInput;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confPassInput;

    @FindBy(id = "register-btn")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        //this.wait.until(driver1 -> this.nameInput.isDisplayed());
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
    }

    public void fillUserInformation(String firstName, String lastName){
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
    }

    public void fillUserCredentials(String username, String password){
        this.emailInput.sendKeys(username);
        this.passInput.sendKeys(password);
        this.confPassInput.sendKeys(password);
    }

    public void submit(){
        this.submitBtn.click();
    }

}
