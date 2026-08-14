package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Интернет-магазин")
@Feature("Авторизация")
@Owner("Isupov Mikhail 123@gmail.com")
public class  LoginTest extends BaseTest {
    @Story("Успешная авторизация")
    @Test(description = "Подтверждение успешной авторизации", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("TESTOVAYA_REPA")
    @Issue("TESTOVAYA_REPA")
    public void correctLogin() {
        System.out.println("LoginTest.correctLogin running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        boolean titleDisplayed = productsPage.pageIsOpen();

        assertTrue(titleDisplayed);
        assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
    }

    @DataProvider(name = "logDt")
    public Object[][] loginData() {
        return new Object[][]{
            {withInvalidLogin(),
                    "Epic sadface: Username and password do not match any user in this service"},
            {lockedPermission(),
                    "Epic sadface: Sorry, this user has been locked out."},
            {withEmptyLogin(),
                    "Epic sadface: Username is required"},
            {withEmptyPassword(),
                    "Epic sadface: Password is required"}
        };
    }

    @Story("Безуспешная авторизация")
    @Test(priority = 2, dataProvider = "logDt")
    @Severity(SeverityLevel.BLOCKER)
    public void incorrectLogin(User user, String errorMsg) {
        System.out.println("LoginTest.incorrectLogin running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMsg);
    }
}
