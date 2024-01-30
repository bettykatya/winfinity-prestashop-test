package com.prestashop.demo.ui.pages;

import com.prestashop.demo.common.domain.Product;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage<HomePage> {

    private static final By POPULAR_PRODUCTS_HEADER = By.cssSelector("h2.products-section-title");
    private static final By CART_BTN = By.cssSelector(".blockcart a");
    private static final By CART_ITEMS_COUNT = By.cssSelector(".blockcart .cart-products-count");
    private static final By LOGO = By.cssSelector("#_desktop_logo");

    public HomePage() {
        super($(POPULAR_PRODUCTS_HEADER));
    }

    private By getProduct(int productId) {
        return By.cssSelector(String.format("article[data-id-product='%d'] .product-title", productId));
    }

    public ItemDetailsPage openItemDetails(Product product) {
        $(getProduct(product.getId())).click();
        return new ItemDetailsPage();
    }

    public CartPage openCart() {
        $(CART_BTN).click();
        return new CartPage();
    }

    public int getCartItemsCount() {
        String countTxt = $(CART_ITEMS_COUNT).text();
        return Integer.parseInt(countTxt.substring(1, countTxt.length() - 1));
    }

    public HomePage goHome() {
        $(LOGO).click();
        assertPageElementsLoaded();
        return new HomePage();
    }
}
