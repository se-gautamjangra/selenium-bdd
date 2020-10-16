package com.gautam.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.gautam.utils.AssertionUtils.assertEquals;
import static com.gautam.utils.AssertionUtils.assertPageTitle;
import static com.gautam.utils.CommonUtils.clickOnElement;
import static com.gautam.utils.CommonUtils.scrollToElement;
import static com.gautam.utils.ConfigUtils.getPropertyByKey;
import static com.gautam.utils.DriverUtils.getDriver;
import static com.gautam.utils.WebElementUtils.createDynamicLocator;
import static com.gautam.utils.WebElementUtils.hardWait;


public class HomePage {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindAll({
            @FindBy(xpath = "//h4[@class=\"card-title\"]")
    })
    private List<WebElement> products;

    public void verifyProducts(String productName) {
        scrollToElement(products.get(0));
        assertEquals(products.get(0), productName);
    }

    public void selectCategoryFromHOmePage(String categoryName) {
        WebElement deviceCategory = createDynamicLocator("//a[@id='itemc'][text()='%s']", categoryName);
        clickOnElement(deviceCategory);
    }

    public void selectProduct(String productName) {
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                hardWait(1000);
                clickOnElement(product);
                break;
            }

        }
    }
    public void verifyUserOnHomepage() {
        assertPageTitle(getPropertyByKey("homepage.title"));
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
