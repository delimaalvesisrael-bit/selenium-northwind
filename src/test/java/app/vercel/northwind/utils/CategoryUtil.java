package app.vercel.northwind.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryUtil {

    private static final String URL_LOGIN = "https://northwind-test-platform.vercel.app/";
    private static final String URL_PRODUCTS = "https://northwind-test-platform.vercel.app/products";
    private static final String URL_CATEGORIAS = "https://northwind-test-platform.vercel.app/categorias";

    public static void realizarLogin(WebDriver driver) {
        driver.get(URL_LOGIN);

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys("admin@qatest.com");
        inputPassword.sendKeys("Teste@123");
        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(URL_PRODUCTS));

        Assertions.assertEquals(URL_PRODUCTS, driver.getCurrentUrl());
    }
    public static void clicarNovaCategoria (WebDriver driver) {
        driver.get(URL_CATEGORIAS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(URL_CATEGORIAS));

        Assertions.assertEquals(URL_CATEGORIAS, driver.getCurrentUrl());
    }
}