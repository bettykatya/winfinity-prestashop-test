package com.prestashop.demo.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage<CartPage>{
    private static final By TOTAL_PRICE = By.cssSelector(".cart-total .value");
    private static final By TOTAL_ITEMS_COUNT = By.cssSelector(".cart-summary-line .js-subtotal");
    private static final By CHECKOUT_BTN = By.cssSelector(".checkout");


    public double getTotalPrice() {
        return Double.parseDouble(new StringBuilder($(TOTAL_PRICE).getText()).deleteCharAt(0).toString());
    }

    public int getTotalItemsCount() {
        return Integer.parseInt($(TOTAL_ITEMS_COUNT).getText().split(" ")[0]);
    }

    public CheckoutPage goToCheckout() {
        $(CHECKOUT_BTN).click();
        return new CheckoutPage();
    }

}
