package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        homePage.verifyHomePage();
    }

    @When("user click on add to cart button of first item")
    public void user_click_on_add_to_cart_button_of_first_item() {
        homePage.clickOnAddToCartBtnOfFirstProduct();
    }

    @When("click on cart icon")
    public void click_on_cart_icon() {
        homePage.clickOnCartIcon();
    }

    @When("verify user is on hamburger menu")
    public void verifyUserIsOnHamburgerMenu() {
        homePage.clickOnHamburgerIcon();
    }

    @And("click on logout link")
    public void clickOnLogoutLink() {
        homePage.clickOnLogoutLink();
    }

    @When("user click on sort button")
    public void userClickOnSortButton() {
        homePage.clickOnSortButton();
    }

    @And("select the product by price high to low")
    public void selectTheProductByPriceHighToLow() {
        homePage.selectByPriceHighToLow();

    }

    @Then("verify products are displayed by price high to low")
    public void verifyProductsAreDisplayedByPriceHighToLow() {
         homePage.verifyProductAreDisplayedByPriceHighToLow();
    }
}