package tests;

import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");
    @Test
    public void checkGoodsAdded(){
        loginPage.open();
        loginPage.login(withAdminPermission());
        for (String goodsName : goodsList) {
            productsPage.addToCart(goodsName);
        }
        productsPage.switchToCart();
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
        assertEquals(cartPage.getProductsNames(), goodsList);
    }
}
