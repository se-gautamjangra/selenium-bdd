package com.gautam.stepDefinitions;

import com.gautam.pages.HomePage;
import com.gautam.pages.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage();


    @And("^User Add product to cart$")
    public void userAddProductToCart() {
        productPage.addToCartProduct();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.acceptPopUp();

    }

    @Given("^User navigated to \"([^\"]*)\" page of the application$")
    public void userNavigatedToHomepageOfTheApplication(String header) {
        productPage.selectHeader(header);
    }
}
