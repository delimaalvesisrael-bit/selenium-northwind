package app.vercel.northwind.category;

import app.vercel.northwind.base.BaseTest;
import app.vercel.northwind.utils.CategoryUtil;
import app.vercel.northwind.utils.LoginUtil;
import app.vercel.northwind.utils.NavigationUtil;
import app.vercel.northwind.utils.ScreeshotUtil;
import app.vercel.northwind.utils.WaitUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CategoryTest extends BaseTest {

    @Test
    @DisplayName("Deve exibir mensagem de erro ao tentar salvar uma categoria sem informar o nome")
    public void testValidarNomeCategoriaObrigatorio() throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição válida para teste");

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroNome(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Nome da categoria é obrigatório",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_nome_obrigatorio");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao tentar salvar uma categoria sem informar a descrição")
    public void testValidarDescricaoCategoriaObrigatoria() throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "Categoria Teste");

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroDescricao(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Descrição é obrigatória",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_descricao_obrigatoria");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar nome da categoria com apenas 1 caractere")
    public void testValidarNomeCategoriaComUmCaractere() throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "A");

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição válida para teste");

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroNome(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Deve ter entre 2 e 50 caracteres",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_nome_curto");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar nome da categoria com mais de 50 caracteres")
    public void testValidarNomeCategoriaComMaisDeCinquentaCaracteres()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        String nomeInvalido =
                "Categoria com nome contendo mais de cinquenta caracteres";

        CategoryUtil.preencherNome(
                driver,
                nomeInvalido);

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição válida para teste");

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroNome(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Deve ter entre 2 e 50 caracteres",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_nome_longo");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar descrição com menos de 10 caracteres")
    public void testValidarDescricaoCategoriaComMenosDeDezCaracteres()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "Categoria Teste");

        CategoryUtil.preencherDescricao(
                driver,
                "Teste");

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroDescricao(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Deve ter entre 10 e 200 caracteres",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_descricao_curta");
    }

    @Test
    @DisplayName("Deve exibir mensagem de erro ao informar descrição com mais de 200 caracteres")
    public void testValidarDescricaoCategoriaComMaisDeDuzentosCaracteres()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        String descricaoInvalida =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                        "nisi ut aliquip ex ea commodo consequat. " +
                        "Duis aute irure dolor in reprehenderit.";

        CategoryUtil.preencherNome(
                driver,
                "Categoria Teste");

        CategoryUtil.preencherDescricao(
                driver,
                descricaoInvalida);

        CategoryUtil.salvar(driver);

        WebElement message =
                CategoryUtil.obterErroDescricao(driver);

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Deve ter entre 10 e 200 caracteres",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_descricao_longa");
    }

    @Test
    @DisplayName("Deve cadastrar uma categoria com nome e descrição válidos")
    public void testValidarCadastroCategoriaComSucesso()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "Teste Israel");

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição da categoria Teste Israel");

        WebElement inputName =
                CategoryUtil.obterCampoNome(driver);

        WebElement inputDescription =
                CategoryUtil.obterCampoDescricao(driver);

        Assertions.assertEquals(
                "Teste Israel",
                inputName.getAttribute("value"));

        Assertions.assertEquals(
                "Descrição da categoria Teste Israel",
                inputDescription.getAttribute("value"));

        CategoryUtil.salvar(driver);

        WebElement message =
                WaitUtil.aguardarElementoVisivel(
                        driver,
                        By.xpath(
                                "//*[normalize-space(text())=" +
                                        "'Categoria cadastrada com sucesso!']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Categoria cadastrada com sucesso!",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_cadastrada_sucesso");
    }

    @Test
    @DisplayName("Deve fechar o modal e limpar o formulário após cadastrar uma categoria")
    public void testValidarModalFechadoEFormularioLimpo()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "Teste Israel");

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição da categoria Teste Israel");

        CategoryUtil.salvar(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.xpath(
                        "//*[normalize-space(text())=" +
                                "'Categoria cadastrada com sucesso!']"));

        Assertions.assertTrue(
                driver.findElements(
                                By.cssSelector(
                                        "[data-testid='category-name-input']"))
                        .stream()
                        .noneMatch(WebElement::isDisplayed));

        Assertions.assertTrue(
                driver.findElements(
                                By.cssSelector(
                                        "[data-testid='category-description-input']"))
                        .stream()
                        .noneMatch(WebElement::isDisplayed));

        ScreeshotUtil.capturar(
                driver,
                "categoria_modal_fechado");
    }

    @Test
    @DisplayName("Deve fechar o modal ao cancelar o cadastro de categoria")
    public void testValidarCancelamentoCadastroCategoria()
            throws IOException {

        LoginUtil.acessarSistema(
                driver,
                "admin@qatest.com",
                "Teste@123");

        WaitUtil.aguardarUrl(
                driver,
                "https://northwind-test-platform.vercel.app/products");

        NavigationUtil.acessarGestaoDeCategorias(driver);

        WaitUtil.aguardarElementoVisivel(
                driver,
                By.cssSelector("[data-testid='category-name-input']"));

        CategoryUtil.preencherNome(
                driver,
                "Categoria Cancelada");

        CategoryUtil.preencherDescricao(
                driver,
                "Descrição da categoria cancelada");

        CategoryUtil.cancelar(driver);

        WaitUtil.aguardarElementoInvisivel(
                driver,
                By.cssSelector(
                        "[data-testid='category-name-input']"));

        Assertions.assertTrue(
                driver.findElements(
                                By.cssSelector(
                                        "[data-testid='category-name-input']"))
                        .stream()
                        .noneMatch(WebElement::isDisplayed));

        Assertions.assertTrue(
                driver.findElements(
                                By.cssSelector(
                                        "[data-testid='category-description-input']"))
                        .stream()
                        .noneMatch(WebElement::isDisplayed));

        ScreeshotUtil.capturar(
                driver,
                "categoria_cancelada");
    }

    @Test
    @DisplayName("Deve exibir mensagem informando que o usuário precisa estar logado ao tentar cadastrar categoria sem autenticação")
    public void testValidarCadastroCategoriaSemAutenticacao()
            throws IOException {

        NavigationUtil.acessarProdutos(driver);

        WebElement message =
                WaitUtil.aguardarElementoVisivel(
                        driver,
                        By.xpath(
                                "//*[normalize-space(text())=" +
                                        "'Você precisa estar logado']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(
                "Você precisa estar logado",
                message.getText());

        ScreeshotUtil.capturar(
                driver,
                "categoria_sem_autenticacao");
    }
}