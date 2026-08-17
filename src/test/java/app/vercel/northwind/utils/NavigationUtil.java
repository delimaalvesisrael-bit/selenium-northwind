package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationUtil {

    private static final String URL_PRODUCTS =
            "https://northwind-test-platform.vercel.app/products";

    private NavigationUtil() {
    }

    public static void acessarProdutos(WebDriver driver) {
        driver.get(URL_PRODUCTS);
    }

    public static void acessarGestaoDeCategorias(WebDriver driver) {

        driver.findElement(
                By.xpath(
                        "(.//*[normalize-space(text()) and " +
                                "normalize-space(.)='Adicionar Produto'])[1]/following::button[1]"
                )
        ).click();

        driver.findElement(
                By.xpath(
                        "(.//*[normalize-space(text()) and " +
                                "normalize-space(.)='Gestão de Categorias'])[1]/following::button[1]"
                )
        ).click();
    }
}