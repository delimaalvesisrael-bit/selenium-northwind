package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryUtil {

    private CategoryUtil() {
    }

    public static WebElement obterCampoNome(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='category-name-input']"));
    }

    public static WebElement obterCampoDescricao(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='category-description-input']"));
    }

    public static WebElement obterBotaoSalvar(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='save-category-btn']"));
    }

    public static WebElement obterBotaoCancelar(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='cancel-category-btn']"));
    }

    public static WebElement obterErroNome(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='error-category-name']"));
    }

    public static WebElement obterErroDescricao(WebDriver driver) {
        return driver.findElement(
                By.cssSelector("[data-testid='error-category-description']"));
    }

    public static void preencherNome(
            WebDriver driver,
            String nome) {

        obterCampoNome(driver).sendKeys(nome);
    }

    public static void preencherDescricao(
            WebDriver driver,
            String descricao) {

        obterCampoDescricao(driver).sendKeys(descricao);
    }

    public static void salvar(WebDriver driver) {
        obterBotaoSalvar(driver).click();
    }

    public static void cancelar(WebDriver driver) {
        obterBotaoCancelar(driver).click();
    }
}