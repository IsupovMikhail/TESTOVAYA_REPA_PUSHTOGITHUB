package tests;

import org.testng.annotations.Test;
import java.util.List;

import static enums.TitleNaming.CART;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");
    @Test
    public void checkGoodsAdded(){
        System.out.println("CartTest.checkGoodsAdded running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(cartPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        for (String goodsName : goodsList) {
            productsPage.addToCart(goodsName);
        }
        productsPage.switchToCart();
        assertEquals(cartPage.getNamePage(), CART.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
        assertEquals(cartPage.getProductsNames(), goodsList);
    }
}
