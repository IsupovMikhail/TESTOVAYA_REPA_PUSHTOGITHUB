package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginInput = By.xpath("//*[@placeholder='Username']");
    private final By passwordInput = By.xpath("//*[@placeholder='Password']");
    private final By loginBtn = By.cssSelector("#login-button");
    private final By error = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(final String userName, final String password) {
        driver.findElement(loginInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed(){
       return driver.findElement(error).isDisplayed();
    }

    public String getErrorText () {
        return driver.findElement(error).getText();
    }
}


