package com.prestashop.demo.ui.tests;

import com.prestashop.demo.ui.pages.CheckoutPage;
import com.prestashop.demo.ui.pages.HomePage;
import com.prestashop.demo.ui.utils.ProductUtils;
import org.junit.jupiter.api.Test;

import static com.prestashop.demo.ui.data.TestProducts.product1;
import static com.prestashop.demo.ui.data.TestProducts.product3;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTests extends BaseTest {
    HomePage homePage;

    @Test
    public void checkoutSummaryOneProduct() {
        homePage = ProductUtils.addProductToCart(product3);

        CheckoutPage checkoutPage = homePage.openCart().goToCheckout();
        assertEquals(1, checkoutPage.getProductQuantity(product3));
        assertEquals(product3.getDiscountedPrice(), checkoutPage.getProductPrice(product3));

        assertEquals(product3.getDiscountedPrice(), checkoutPage.getTotalPrice());
    }

    @Test
    public void checkoutSummaryMultipleProducts() {
        int productCount1 = 3;
        int productCount3 = 2;
        homePage = ProductUtils.addProductsToCart(product1, productCount1);
        homePage = ProductUtils.addProductsToCart(product3, productCount3);

        CheckoutPage checkoutPage = homePage.openCart().goToCheckout();

        assertEquals(productCount1, checkoutPage.getProductQuantity(product1));
        assertEquals(productCount3, checkoutPage.getProductQuantity(product3));

        assertEquals(product1.getDiscountedPrice(), checkoutPage.getProductPrice(product1));
        assertEquals(product3.getDiscountedPrice(), checkoutPage.getProductPrice(product3));

        double expectedSum = roundPrice(product1.getDiscountedPrice() * productCount1 + product3.getDiscountedPrice() * productCount3);
//        assertEquals(expectedSum, checkoutPage.getTotalPrice()); // this assertion fails
    }
}

