package app.vercel.northwind.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryUtil {

    private static final String URL_LOGIN = "https://northwind-test-platform.vercel.app/";
    private static final String URL_PRODUCTS = "https://northwind-test-platform.vercel.app/products";
    private static final String URL_CATEGORIAS = "https://northwind-test-platform.vercel.app/categories";

    public static void realizarLogin(WebDriver driver) {
        driver.get(URL_LOGIN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        inputEmail.sendKeys("admin@qatest.com");
        inputPassword.sendKeys("Teste@123");
        btnLogin.click();
        wait.until(ExpectedConditions.urlToBe(URL_PRODUCTS));
    }

    public static void irParaTelaDeCategorias(WebDriver driver) {
        driver.get(URL_CATEGORIAS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(URL_CATEGORIAS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Gestão de Categorias')]")));
    }

    public static void clicarNovaCategoria(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By btnLocator = By.xpath("//button[contains(.,'Nova Categoria')]");
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='category-description-input'], input[name='name'], [data-testid='category-name-input']")));
    }

    public static WebElement esperarVisivel(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}