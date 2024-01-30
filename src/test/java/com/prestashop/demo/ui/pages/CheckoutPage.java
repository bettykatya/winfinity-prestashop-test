package com.prestashop.demo.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.demo.common.domain.Product;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage extends BasePage<CheckoutPage> {

    private static final By SHOW_DETAILS_TOGGLE = By.cssSelector("[data-target='#cart-summary-product-list']");
    private static final By PRODUCT_QUANTITY = By.cssSelector(".product-quantity");
    private static final By PRODUCT_PRICE = By.cssSelector(".product-price");
    private static final By TOTAL_PRICE = By.cssSelector(".cart-total .value");


    private void expandDetails() {
        SelenideElement toggle = $(SHOW_DETAILS_TOGGLE);
        boolean isExpanded = Boolean.parseBoolean(toggle.getAttribute("aria-expanded"));

        if (!isExpanded) {
            toggle.click();
        }
    }

    private SelenideElement getProductInDetails(Product product) {
        expandDetails();
        return $x(String.format("//li[.//a[text()=\"%s\"]]", product.getName()));
    }

    public double getProductQuantity(Product product) {
        SelenideElement productInDetails = getProductInDetails(product);
        SelenideElement quantityEl = productInDetails.$(PRODUCT_QUANTITY);
        quantityEl.shouldBe(visible);
        return Double.parseDouble(new StringBuilder(quantityEl.getText()).deleteCharAt(0).toString());
    }

    public double getProductPrice(Product product) {
        SelenideElement productInDetails = getProductInDetails(product);
        SelenideElement priceEl = productInDetails.$(PRODUCT_PRICE);
        priceEl.shouldBe(visible);
        return Double.parseDouble(new StringBuilder(priceEl.getText()).deleteCharAt(0).toString());
    }

    public double getTotalPrice() {
        return Double.parseDouble(new StringBuilder($(TOTAL_PRICE).getText()).deleteCharAt(0).toString());
    }
}
