package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewtoursPOs {

    private final BillingAdressPage billingAdressPage;
    private final FlightConfirmationPage flightConfirmationPage;
    private final FlightsDetailsPage flightsDetailsPage;
    private final RegistrationConfirmation registrationConfirmation;
    private final RegistrationPage registrationPage;

    public NewtoursPOs(WebDriver driver){
        this.billingAdressPage = PageFactory.initElements(driver,BillingAdressPage.class);
        this.flightConfirmationPage = PageFactory.initElements(driver,FlightConfirmationPage.class);
        this.flightsDetailsPage = PageFactory.initElements(driver,FlightsDetailsPage.class);
        this.registrationConfirmation = PageFactory.initElements(driver,RegistrationConfirmation.class);
        this.registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
    }


    public BillingAdressPage getBillingAdressPage() {
        return billingAdressPage;
    }

    public FlightConfirmationPage getFlightConfirmationPage() {
        return flightConfirmationPage;
    }

    public FlightsDetailsPage getFlightsDetailsPage() {
        return flightsDetailsPage;
    }

    public RegistrationConfirmation getRegistrationConfirmation() {
        return registrationConfirmation;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }
}
