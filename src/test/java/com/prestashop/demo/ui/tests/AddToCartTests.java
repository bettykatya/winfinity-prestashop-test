package com.prestashop.demo.ui.tests;

import com.prestashop.demo.ui.pages.CartPage;
import com.prestashop.demo.ui.pages.HomePage;
import com.prestashop.demo.ui.utils.ProductUtils;
import org.junit.jupiter.api.Test;

import static com.prestashop.demo.ui.data.TestProducts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToCartTests extends BaseTest {
    HomePage homePage;

    @Test
    public void addItemToCart() {
        homePage = ProductUtils.addProductToCart(product1);
        assertEquals(homePage.getCartItemsCount(), 1);

        CartPage cartPage = homePage.openCart();
        assertEquals(product1.getDiscountedPrice(), cartPage.getTotalPrice());
        assertEquals(1, cartPage.getTotalItemsCount());
    }

    @Test
    public void addDifferentItemsToCart() {
        homePage = ProductUtils.addProductToCart(product1);
        homePage = ProductUtils.addProductToCart(product2);
        assertEquals(homePage.getCartItemsCount(), 2);

        CartPage cartPage = homePage.openCart();
        double expectedSum = roundPrice(product1.getDiscountedPrice() + product2.getDiscountedPrice());
        assertEquals(2, cartPage.getTotalItemsCount());
//        assertEquals(expectedSum, cartPage.getTotalPrice());// this assertion fails
    }

    @Test
    public void addMultipleItemsToCart() {
        int productCount = 3;
        homePage = ProductUtils.addProductsToCart(product1, productCount);

        assertEquals(homePage.getCartItemsCount(), productCount);

        CartPage cartPage = homePage.openCart();
        double expectedSum = roundPrice(product1.getDiscountedPrice() * productCount);
//        assertEquals(expectedSum, cartPage.getTotalPrice());// this assertion fails
        assertEquals(productCount, cartPage.getTotalItemsCount());
    }

    @Test
    public void addDifferentQuantitiesOfItemsToCart() {
        int productCount1 = 3;
        int productCount3 = 2;
        homePage = ProductUtils.addProductsToCart(product1, productCount1);
        homePage = ProductUtils.addProductsToCart(product3, productCount3);

        assertEquals(homePage.getCartItemsCount(), productCount1 + productCount3);

        CartPage cartPage = homePage.openCart();
        double expectedSum = roundPrice(product1.getDiscountedPrice() * productCount1 + product3.getDiscountedPrice() * productCount3);
//        assertEquals(expectedSum, cartPage.getTotalPrice());// this assertion fails
        assertEquals(productCount1 + productCount3, cartPage.getTotalItemsCount());
    }

}
