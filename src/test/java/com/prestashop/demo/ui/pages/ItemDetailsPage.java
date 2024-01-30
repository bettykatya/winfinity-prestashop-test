package com.prestashop.demo.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemDetailsPage extends BasePage<ItemDetailsPage>{
    private static final By ADD_TO_CART_BTN = By.cssSelector("button.add-to-cart");

    public ItemAddedModal addToCart() {
        $(ADD_TO_CART_BTN).click();
        return new ItemAddedModal();
    }
}
