package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    private final WebDriver driver;

    private final By completeMessage =
            By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CompletePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Получаем сообщение об успешном оформлении заказа")
    public String getCompleteMessage() {
        return driver.findElement(completeMessage).getText();
    }
}
