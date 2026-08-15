package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.BasePage.DATA_TEST_PATTERN;

public class OverviewPage extends BasePage {

    private final WebDriver driver;

    private final By shippingInfo =
            By.cssSelector(DATA_TEST_PATTERN.formatted("shipping-info-value"));

    private final By finishBtn =
            By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));

    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Получаем информацию о доставке")
    public String getShippingInfo() {
        return driver.findElement(shippingInfo).getText();
    }

    @Step("Завершаем оформление заказа")
    public void finish() {
        driver.findElement(finishBtn).click();
    }
}
