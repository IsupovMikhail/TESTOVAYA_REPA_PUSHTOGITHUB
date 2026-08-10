package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.Map;

public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
        driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}