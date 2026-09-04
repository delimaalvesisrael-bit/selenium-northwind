package app.vercel.northwind.category;

import app.vercel.northwind.base.BaseTest;
import app.vercel.northwind.utils.CategoryUtil;
import app.vercel.northwind.utils.NavigationUtil;
import app.vercel.northwind.utils.ScreeshotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CategoryTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        CategoryUtil.realizarLogin(driver);
        NavigationUtil.abrirModalCadastroCategoria(driver);
        CategoryUtil.clicarNovaCategoria(driver);
    }

    @Test
    @DisplayName("Deve exibir mensagem de obrigatoriedade ao tentar salvar categoria sem preencher o nome")
    public void testValidarNomeCategoriaObrigatorio() throws IOException {
        WebElement btnNovaCategoria = driver.findElement(By.cssSelector("[data-testid='add-category-btn'"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        btnNovaCategoria.click();
        inputDescricao.sendKeys("Descrição válida para teste de categoria");
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-name']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Nome da categoria é obrigatório", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_nome_obrigatorio");
    }

    @Test
    @DisplayName("Deve exibir mensagem de obrigatoriedade ao tentar salvar categoria sem preencher a descrição")
    public void testValidarDescricaoCategoriaObrigatoria() throws IOException {
        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys("Categoria Teste");
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-description']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Descrição é obrigatória", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_descricao_obrigatoria");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar nome da categoria com apenas um caractere")
    public void testValidarNomeCategoriaComUmCaractere() throws IOException {
        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys("A");
        inputDescricao.sendKeys("Descrição válida para categoria de teste");
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-name']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Deve ter entre 2 e 50 caracteres", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_nome_um_caractere");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar nome da categoria com mais de cinquenta caracteres")
    public void testValidarNomeCategoriaComMaisCinquentaCaracteres() throws IOException {
        String nomeInvalido = "Categoria com nome contendo mais de cinquenta caracteres para teste";

        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys(nomeInvalido);
        inputDescricao.sendKeys("Descrição válida para categoria de teste");
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-name']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Deve ter entre 2 e 50 caracteres", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_nome_maior_cinquenta");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar descrição com menos de dez caracteres")
    public void testValidarDescricaoCategoriaComMenosDezCaracteres() throws IOException {
        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys("Categoria Teste");
        inputDescricao.sendKeys("Teste");
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-description']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Deve ter entre 10 e 200 caracteres", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_descricao_menor_dez");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar descrição com mais de duzentos caracteres")
    public void testValidarDescricaoCategoriaComMaisDuzentosCaracteres() throws IOException {
        String descricaoInvalida = "A".repeat(201);

        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys("Categoria Teste");
        inputDescricao.sendKeys(descricaoInvalida);
        btnSalvar.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='error-category-description']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Deve ter entre 10 e 200 caracteres", message.getText());

        ScreeshotUtil.capturar(driver, "categoria_descricao_maior_duzentos");
    }

    @Test
    @DisplayName("Deve cadastrar uma nova categoria com sucesso ao informar dados válidos")
    public void testCadastrarCategoriaComSucesso() throws IOException {
        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnSalvar = driver.findElement(By.cssSelector("[data-testid='save-category-btn']"));

        inputNome.sendKeys("Teste Nova Categoria Israel");
        inputDescricao.sendKeys("Descrição sucinta para criação de nova categoria do Israel");
        btnSalvar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[text()='Categoria cadastrada com sucesso!']")
                )
        );

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Categoria cadastrada com sucesso!", message.getText());

        Assertions.assertTrue(
                driver.findElements(By.cssSelector("[data-testid='category-name-input']")).isEmpty()
        );

        ScreeshotUtil.capturar(driver, "categoria_cadastrada_sucesso");
    }

    @Test
    @DisplayName("Deve fechar o modal de cadastro ao cancelar a criação da categoria")
    public void testCancelarCadastroCategoria() throws IOException {
        WebElement inputNome = driver.findElement(By.cssSelector("[data-testid='category-name-input']"));
        WebElement inputDescricao = driver.findElement(By.cssSelector("[data-testid='category-description-input']"));
        WebElement btnCancelar = driver.findElement(By.cssSelector("[data-testid='cancel-category-btn']"));

        inputNome.sendKeys("Categoria Teste");
        inputDescricao.sendKeys("Descrição válida para teste do cancelamento da categoria");
        btnCancelar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean modalFechado = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("[data-testid='category-name-input']")
                )
        );

        Assertions.assertTrue(modalFechado);

        ScreeshotUtil.capturar(driver, "cadastro_categoria_cancelado");
    }
}