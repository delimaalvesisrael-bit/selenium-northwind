package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryUtil {

    private static final By INPUT_NAME = By.cssSelector("[data-testid='category-name-input']");
    private static final By INPUT_DESCRIPTION = By.cssSelector("[data-testid='category-description-input']");
    private static final By BTN_SAVE = By.cssSelector("[data-testid='save-category-btn']");
    private static final By BTN_CANCEL = By.cssSelector("[data-testid='cancel-category-btn']");

    public static void preencherFormulario(WebDriver driver, String nome, String descricao) {
        if (nome != null) {
            driver.findElement(INPUT_NAME).sendKeys(nome);
        }
        if (descricao != null) {
            driver.findElement(INPUT_DESCRIPTION).sendKeys(descricao);
        }
    }

    public static void clicarSalvar(WebDriver driver) {
        driver.findElement(BTN_SAVE).click();
    }

    public static void clicarCancelar(WebDriver driver) {
        driver.findElement(BTN_CANCEL).click();
    }
}