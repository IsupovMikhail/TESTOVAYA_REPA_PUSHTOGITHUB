package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class  LoginTest extends BaseTest {

    @Test(description = "Verification of valid authorization", priority = 1)
    public void correctLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        boolean titleDisplayed = productsPage.pageIsOpen();
        String titleName = productsPage.getNamePage();

        assertTrue(titleDisplayed);
        assertEquals(titleName, "Products",
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

    @Test(priority = 2, dataProvider = "logDt")
    public void incorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMsg);
    }
}