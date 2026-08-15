package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By checkoutBtn =
            By.cssSelector(DATA_TEST_PATTERN.formatted("checkout"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем список названий товаров в корзине")
    public ArrayList<String> getProductsNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".inventory_item_name")));

        List<WebElement> allProductsNames =
                driver.findElements(By.cssSelector(".inventory_item_name"));

        ArrayList<String> names = new ArrayList<>();

        for (WebElement productBlock : allProductsNames) {
            names.add(productBlock.getText());
        }

        return names;
    }

    @Step("Переходим к оформлению заказа")
    public void checkout() {
        driver.findElement(checkoutBtn).click();
    }
}