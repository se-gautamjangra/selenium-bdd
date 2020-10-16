package com.gautam.stepDefinitions;

import com.gautam.pages.CartPage;
import com.gautam.utils.CommonUtils;
import com.gautam.utils.ConfigUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import static com.gautam.utils.AssertionUtils.assertEquals;
import static com.gautam.utils.AssertionUtils.assertTrue;

public class CartPageSteps {
    static final Logger logger = Logger.getLogger(CartPageSteps.class);

    CartPage cartPage = new CartPage();

    static String totalPrice;
    @When("^User remove product \"([^\"]*)\" from CartPage$")
    public void userRemoveProductFromCartPage(String productName) throws Throwable {
        cartPage.removeProductFromCart(productName);
    }

    @Then("^Verify product count in cart is \"([^\"]*)\"$")
    public void verifyProductCountInCartIs(String count) throws Throwable {
        assertEquals(cartPage.getCartProductCount(),Integer.parseInt(count));
    }

    @And("^User click on Place Order$")
    public void userClickOnPlaceOrder() {
        totalPrice = cartPage.getTotalPrice();
        cartPage.placeOrder();
    }

    @And("^User provide details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and purchase products$")
    public void userProvideDetailsAndPurchaseProducts(String name, String country, String city, String card, String month, String year) throws Throwable {
        cartPage.purchaseOrderWithUserDetails(name,country,city,card,month,year);
    }

    @Then("^Verify product price on CartPage$")
    public void verifyProductPriceOnCartPage() {
        String orderDetails = cartPage.getOrderDetails();
        logger.info("Order Details:- " + orderDetails);
        ConfigUtils.updateProperty("product.details",orderDetails,"output.properties");
        assertTrue(orderDetails,totalPrice);
    }

    @And("^User confirm order$")
    public void userConfirmOrder() {
        cartPage.confirmOrder();
    }
}
