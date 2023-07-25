package com.automation.steps;

import com.automation.pages.OrderConfirmationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderConfirmationSteps {
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();


    @Then("verify user is on order confirmation page")
    public void verify_user_is_on_order_confirmation_page() {
        orderConfirmationPage.verifyConfirmationPageDisplayed();
    }
}
