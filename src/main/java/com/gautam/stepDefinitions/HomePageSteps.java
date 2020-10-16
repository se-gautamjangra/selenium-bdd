package com.gautam.stepDefinitions;

import com.gautam.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
    HomePage homepage = new HomePage();


    @Given("^User is on Homepage of the application$")
    public void userIsOnHomepage() {
        homepage.verifyUserOnHomepage();
    }


    @When("^User selects \"([^\"]*)\" from homepage$")
    public void user_selects_from_homepage(String itemName) {
        homepage.selectCategoryFromHOmePage(itemName);
    }


    @Then("^Verify \"([^\"]*)\" present on homepage$")
    public void verifyPresentOnLoginPage(String productName) throws Throwable {
        homepage.verifyProducts(productName);
    }

    @When("^User selects product \"([^\"]*)\" from homepage$")
    public void userSelectsProductFromHomepage(String itemName) throws Throwable {
        homepage.selectProduct(itemName);
    }

}
