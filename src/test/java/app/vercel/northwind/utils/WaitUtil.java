package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final int TEMPO_ESPERA = 5;

    public static void esperarUrl(
            WebDriver driver,
            String url
    ) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TEMPO_ESPERA)
        );

        wait.until(
                ExpectedConditions.urlToBe(url)
        );
    }

    public static WebElement esperarElementoVisivel(
            WebDriver driver,
            By locator
    ) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TEMPO_ESPERA)
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement esperarElementoClicavel(
            WebDriver driver,
            By locator
    ) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TEMPO_ESPERA)
        );

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static Boolean esperarElementoInvisivel(
            WebDriver driver,
            By locator
    ) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TEMPO_ESPERA)
        );

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
}
