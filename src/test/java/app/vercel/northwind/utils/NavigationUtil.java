package app.vercel.northwind.utils;

import org.junit.jupiter.api.Assertions;
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

    //Guarda a aba atual
        String janelaAtual = driver.getWindowHandle();

        btnAdicionarProduto.click();

    // Aguardar abertura da nova aba
        wait.until(driver1 ->
                !driver.getWindowHandles().isEmpty());

    //Troca para a nova aba
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaAtual)) {
                driver.switchTo().window(janela);
                break;
            }
        }

        //Confirma que chegou em /categories
        wait.until(
                ExpectedConditions.urlContains("/categories")
        );

        WebElement btnAdicionarCategoria = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-testid='add-category-btn']")
                )
        );
        btnAdicionarCategoria.click();
    }


}