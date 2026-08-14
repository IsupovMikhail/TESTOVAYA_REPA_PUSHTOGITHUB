package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div"+
            "[@class='inventory_item']//child::*[text()='Add to cart']";
    private final By counter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By addToCartBtn = By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(final String goodsName) {
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(goods).click();
    }

    @Step("Добавляем в корзину товар под индексом")
    public void addToCart(int goodsIndex){
        driver.findElements(addToCartBtn).get(goodsIndex).click();
    }

    @Step("Проверяем количество товаров в корзине")
    public int checkCounterValue() {
        return Integer.parseInt(driver.findElement(counter).getText());
    }

    @Step("Проверяем цвет каунтера товаров в корзине")
    public String checkCounterColour() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    @Step("Переходим в корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}