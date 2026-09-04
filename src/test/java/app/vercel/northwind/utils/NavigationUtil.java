package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationUtil {

    public static void abrirModalCadastroCategoria(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement btnAdicionarProduto = driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Adicionar Produto'])[1]/following::button[1]")
        );
        btnAdicionarProduto.click();

        WebElement btnAdicionarCategoria = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-testid='add-category-btn']")
                )
        );
        btnAdicionarCategoria.click();
    }
}