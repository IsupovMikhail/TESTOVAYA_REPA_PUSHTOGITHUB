package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Isupov Mikhail 123@gmail.com")
public class OverviewTest extends BaseTest {

    @Story("Проверка информации о заказе")
    @Test(description = "Verification of checkout overview")
    @Severity(SeverityLevel.CRITICAL)
    public void checkoutOverview() {

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

        cartPage.checkout();

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

        assertEquals(
                overviewPage.getShippingInfo(),
                "Free Pony Express Delivery!",
                "Shipping information doesn't correspond to the expected"
        );
    }
}
