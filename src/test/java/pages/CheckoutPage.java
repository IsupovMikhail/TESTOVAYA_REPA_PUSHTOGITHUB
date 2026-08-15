package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.BasePage.DATA_TEST_PATTERN;

public class CheckoutPage extends BasePage {

    private final WebDriver driver;

    private final By firstNameInput =
            By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));

    private final By lastNameInput =
            By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));

    private final By postalCodeInput =
            By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));

    private final By continueBtn =
            By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Заполняем данные покупателя: {firstName} {lastName}, индекс: {postalCode}")
    public void fillCustomerInformation(
            String firstName,
            String lastName,
            String postalCode) {

        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

    @Step("Переходим к обзору заказа")
    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }
}