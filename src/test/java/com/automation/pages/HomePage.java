package com.automation.pages;

import com.automation.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    WebElement item1;

    @FindBy(xpath = "//a[@class = 'shopping_cart_link']")
    WebElement cart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement filter;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(xpath = "//select[@class='product_sort_container'] ")
    WebElement sortBtn;
    List<WebElement> pricess = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

    public void clickOnAddToCartBtnOfFirstProduct() {
        item1.click();
    }

    public void clickOnCartIcon() {
        cart.click();
    }

    public void verifyHomePage() {
        assertTrue(cart.isDisplayed());
        assertTrue(filter.isDisplayed());
    }

    public void clickOnHamburgerIcon() {
        burgerIcon.click();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public void clickOnSortButton() {
        sortBtn.click();
    }

    public void selectByPriceHighToLow() {
        Select dropdown = new Select(sortBtn);
        dropdown.selectByIndex(3);
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement price : prices) {
            System.out.println(price.getText());
        }
//        assertEquals(pricess,prices);
    }
    private List<Double> productPrices;
    public void verifyProductAreDisplayedByPriceHighToLow() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        productPrices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            productPrices.add(price);
        }

        List<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        assertTrue(productPrices.equals(sortedPrices));
    }

}


