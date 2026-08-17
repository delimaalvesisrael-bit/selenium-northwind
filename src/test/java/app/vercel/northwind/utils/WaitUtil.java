package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final Duration TIMEOUT =
            Duration.ofSeconds(5);

    private WaitUtil() {
    }

    public static void aguardarUrl(
            WebDriver driver,
            String url) {

        WebDriverWait wait =
                new WebDriverWait(driver, TIMEOUT);

        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static WebElement aguardarElementoVisivel(
            WebDriver driver,
            By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, TIMEOUT);

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void aguardarElementoInvisivel(
            WebDriver driver,
            By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, TIMEOUT);

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}