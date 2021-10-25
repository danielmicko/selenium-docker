package com.newtours.tests;

import com.BaseTest;
import com.newtours.pages.NewtoursPOs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private NewtoursPOs newtoursPOs;
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeClass
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setBookFlightTestClasses(String noOfPassengers, String expectedPrice){
        this.newtoursPOs = new NewtoursPOs(driver);
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPageTest(){
        newtoursPOs.getRegistrationPage().goTo();
        newtoursPOs.getRegistrationPage().fillUserInformation("selenium","docker");
        newtoursPOs.getRegistrationPage().fillUserCredentials("selenium","docker");
        newtoursPOs.getRegistrationPage().submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmation(){
        newtoursPOs.getRegistrationConfirmation().goToFlights();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    public void flightDetailsPage(){
        newtoursPOs.getFlightsDetailsPage().selectPassengerCount(noOfPassengers);
        newtoursPOs.getFlightsDetailsPage().continueToFlights();
    }

    @Test (dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        newtoursPOs.getBillingAdressPage().continueFromFlights();
        newtoursPOs.getBillingAdressPage().nextPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        String actualPrice = newtoursPOs.getFlightConfirmationPage().getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
