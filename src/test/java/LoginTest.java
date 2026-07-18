import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
   // 1. Открыть нужный браузер
   // 2. Зайти на нужный сайт: saucedemo.com

    @Test
    public void zipCode4digits (){
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("1337");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.CONTROL+"A");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("9999");
        browser.findElement(By.cssSelector("[value='Continue']")).click();
        boolean isErrorDisplayed = browser.findElement(By.cssSelector(".error_message")).isDisplayed();
        String errorMessage = browser.findElement(By.cssSelector(".error_message")).getText();

        assertTrue(isErrorDisplayed);
        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");

    //    browser.quit();

    }

    @Test
    public void zipCode5digits (){
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("17377");
        browser.findElement(By.cssSelector("[value='Continue']")).click();
        browser.findElement(By.cssSelector("[value='Register']")).isDisplayed();

 }