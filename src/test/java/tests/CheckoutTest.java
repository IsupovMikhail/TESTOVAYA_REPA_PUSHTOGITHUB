package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.CART;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Isupov Mikhail 123@gmail.com")
public class CheckoutTest extends BaseTest {

    @Story("Заполнение данных для оформления заказа")
    @Test(description = "Verification of checkout information")
    @Severity(SeverityLevel.CRITICAL)
    public void checkoutInformation() {

        loginPage.open();
        loginPage.login(withAdminPermission());

        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");

        assertEquals(
                productsPage.checkCounterValue(),
                3,
                "Number of products doesn't correspond to the expected"
        );

        productsPage.switchToCart();

        assertEquals(
                cartPage.getNamePage(),
                CART.getDisplayName(),
                "Name of the page doesn't correspond to the expected"
        );

        cartPage.checkout();

        assertEquals(
                checkoutPage.getNamePage(),
                "Checkout: Your Information",
                "Name of the page doesn't correspond to the expected"
        );

        checkoutPage.fillCustomerInformation(
                "Mikhail",
                "Isupov",
                "426011"
        );

        checkoutPage.continueCheckout();

        assertEquals(
                overviewPage.getNamePage(),
                "Checkout: Overview",
                "Name of the page doesn't correspond to the expected"
        );
    }
}