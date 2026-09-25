package app.vercel.northwind.category;

import app.vercel.northwind.base.BaseTest;
import app.vercel.northwind.utils.CategoryUtil;
import app.vercel.northwind.utils.ScreeshotUtil;
import app.vercel.northwind.utils.TestData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class BuscarCategorias extends BaseTest{
    @BeforeEach
    public void setupTest() {
        CategoryUtil.realizarLogin(driver);
        //   NavigationUtil.abrirModalCadastroCategoria(driver);
        CategoryUtil.clicarNovaCategoria(driver);
    }

    @Test
    @DisplayName("Deve exibir as categorias de acrodo com a pesquisa realizada")
    public void testBuscaCategorias() throws  IOException, InterruptedException {
        WebElement cpBuscaCategorias = driver.findElement(By.cssSelector("[placeholder='Buscar categorias...']"));
        cpBuscaCategorias.sendKeys(TestData.NOME_CATEGORIA);

        Assertions.assertTrue(cpBuscaCategorias.isDisplayed());
        Assertions.assertEquals(TestData.NOME_CATEGORIA, cpBuscaCategorias.getText());

        ScreeshotUtil.capturar(driver,"CategoriaTesteIsrael");
    }
}
