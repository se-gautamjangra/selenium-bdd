package com.gautam.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.gautam.utils.AssertionUtils.assertEquals;
import static com.gautam.utils.CommonUtils.clickOnElement;
import static com.gautam.utils.DriverUtils.getDriver;
import static com.gautam.utils.WebElementUtils.createDynamicLocator;


public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCart;

    public void selectHeader(String header) {
        WebElement headers = createDynamicLocator("//a[@class='nav-link'][contains(text(),'%s')]", header);
        clickOnElement(headers);
    }

    public void addToCartProduct() {
        clickOnElement(addToCart);
    }

    public void acceptPopUp() {
        getDriver().switchTo().alert().accept();
    }

}
