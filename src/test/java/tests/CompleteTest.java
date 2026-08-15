package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Isupov Mikhail 123@gmail.com")
public class CompleteTest extends BaseTest {

    @Story("Успешное оформление заказа")
    @Test(description = "Verification of successful order completion")
    @Severity(SeverityLevel.BLOCKER)
    public void completeOrder() {

        loginPage.open();
        loginPage.login(withAdminPermission());

        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");

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

        overviewPage.finish();

        assertEquals(
                completePage.getNamePage(),
                "Checkout: Complete!",
                "Name of the page doesn't correspond to the expected"
        );

        assertEquals(
                completePage.getCompleteMessage(),
                "Thank you for your order!",
                "Order completion message doesn't correspond to the expected"
        );
    }
}