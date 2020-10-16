package com.gautam.pages;


import com.gautam.utils.WebElementUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.gautam.utils.CommonUtils.clickOnElement;
import static com.gautam.utils.CommonUtils.sendKeysTo;
import static com.gautam.utils.DriverUtils.getDriver;
import static com.gautam.utils.WebElementUtils.createDynamicLocator;


public class CartPage {
    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrder;
    @FindAll({
            @FindBy(xpath = "//tr[@class=\"success\"]")
    })
    private List<WebElement> cartProducts;

    @FindBy(xpath = "//h3[@class=\"panel-title\"]")
    private WebElement totalPrice;

    @FindBy(xpath = "//input[@id=\"name\"]")
    private WebElement orderName;

    @FindBy(xpath = "//input[@id=\"country\"]")
    private WebElement orderCountry;

    @FindBy(xpath = "//input[@id=\"city\"]")
    private WebElement orderCity;

    @FindBy(xpath = "//input[@id=\"card\"]")
    private WebElement orderCard;
    @FindBy(xpath = "//input[@id=\"month\"]")
    private WebElement orderMonth;

    @FindBy(xpath = "//input[@id=\"year\"]")
    private WebElement orderYear;

    @FindBy(xpath = "//button[@onclick=\"purchaseOrder()\"]")
    private WebElement orderPurchase;

    @FindBy(xpath = "//p[@class=\"lead text-muted \"]")
    private WebElement orderDetails;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement confirmOrder;

    public void removeProductFromCart(String product) {
        WebElement deleteProduct = createDynamicLocator("//tr[@class=\"success\"]/td[text()='%s']/following-sibling::td/a", product);
        clickOnElement(deleteProduct);
    }

    public void placeOrder() {
        clickOnElement(placeOrder);
    }

    public int getCartProductCount() {
        return cartProducts.size();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void purchaseOrderWithUserDetails(String name, String country, String city, String card, String month, String year) {
        sendKeysTo(orderName, name);
        sendKeysTo(orderCountry, country);
        sendKeysTo(orderCity, city);
        sendKeysTo(orderCard, card);
        sendKeysTo(orderMonth, month);
        sendKeysTo(orderYear, year);
        clickOnElement(orderPurchase);
    }

    public String getOrderDetails() {
        return orderDetails.getText();
    }

    public void confirmOrder() {
        clickOnElement(confirmOrder);
    }
}
