package com.prestashop.demo.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemAddedModal extends BasePage<ItemAddedModal> {
    private static final By PROCEED_TO_CHECKOUT_BTN = By.cssSelector(".cart-content-btn a");
    private static final By CONTINUE_SHOPPING_BTN = By.cssSelector(".cart-content-btn button");

    public CartPage proceedToCheckout() {
        $(PROCEED_TO_CHECKOUT_BTN).click();
        return new CartPage();
    }

    public HomePage continueShopping() {
        $(CONTINUE_SHOPPING_BTN).click();
        return new HomePage();
    }
}
