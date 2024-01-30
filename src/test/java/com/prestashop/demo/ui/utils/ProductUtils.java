package com.prestashop.demo.ui.utils;

import com.prestashop.demo.common.domain.Product;
import com.prestashop.demo.ui.pages.HomePage;

public class ProductUtils {

    public static HomePage addProductToCart(Product productToAdd) {
        HomePage homePage = new HomePage().open();
        return homePage.openItemDetails(productToAdd).addToCart().continueShopping().goHome();
    }

    public static HomePage addProductsToCart(Product productToAdd, int productCount) {
        for (int i = 0; i < productCount; i++) {
            addProductToCart(productToAdd);
        }
        return new HomePage();
    }
}
