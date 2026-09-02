package app.vercel.northwind.category;

import app.vercel.northwind.base.BaseTest;
import app.vercel.northwind.utils.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class CategoryTest extends BaseTest {

    private final String MSG_NOME_OBRIGATORIO = "Nome da categoria é obrigatório";
    private final String MSG_DESCRICAO_OBRIGATORIA = "Descrição é obrigatória";
    private final String MSG_NOME_TAMANHO_INVALIDO = "Deve ter entre 2 e 50 caracteres";
    private final String MSG_DESCRICAO_TAMANHO_INVALIDA = "Deve ter entre 10 e 200 caracteres";
    private final String MSG_SUCESSO_CADASTRO = "Categoria cadastrada com sucesso!";

    private final By ERROR_NOME = By.cssSelector("[data-testid='error-category-name']");
    private final By ERROR_DESCRICAO = By.cssSelector("[data-testid='error-category-description']");
    private final By TOAST_SUCESSO = By.id("2");
    private final By INPUT_NOME = By.cssSelector("[data-testid='category-name-input']");

    @BeforeEach
    public void navegarParaGestaoCategorias() {
        LoginUtil.realizarLogin(driver, TestData.EMAIL_VALIDO, TestData.SENHA_VALIDA);
        NavigationUtil.abrirModalNovaCategoria(driver);
    }

    @Test
    @DisplayName("CT001 - Tentar salvar sem preencher nome")
    public void testCT001_TentarSalvarSemNome() throws IOException {
        CategoryUtil.preencherFormulario(driver, null, "Descrição válida para teste de validação.");
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_NOME, 3);
        Assertions.assertEquals(MSG_NOME_OBRIGATORIO, textoErro);

        ScreeshotUtil.capturar(driver, "ct001_nome_obrigatorio");
    }

    @Test
    @DisplayName("CT002 - Tentar salvar sem preencher descrição")
    public void testCT002_TentarSalvarSemDescricao() throws IOException {
        CategoryUtil.preencherFormulario(driver, "Categoria Válida", null);
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_DESCRICAO, 3);
        Assertions.assertEquals(MSG_DESCRICAO_OBRIGATORIA, textoErro);

        ScreeshotUtil.capturar(driver, "ct002_descricao_obrigatoria");
    }

    @Test
    @DisplayName("CT003 - Nome com 1 caractere (abaixo do limite mínimo)")
    public void testCT003_NomeComUmCaractere() throws IOException {
        CategoryUtil.preencherFormulario(driver, "A", "Descrição válida para teste de tamanho.");
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_NOME, 3);
        Assertions.assertEquals(MSG_NOME_TAMANHO_INVALIDO, textoErro);

        ScreeshotUtil.capturar(driver, "ct003_nome_curto");
    }

    @Test
    @DisplayName("CT004 - Nome com 51 caracteres (acima do limite máximo)")
    public void testCT004_NomeComCinquentaEUmCaracteres() throws IOException {
        CategoryUtil.preencherFormulario(driver, "A".repeat(51), "Descrição válida para teste de tamanho.");
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_NOME, 3);
        Assertions.assertEquals(MSG_NOME_TAMANHO_INVALIDO, textoErro);

        ScreeshotUtil.capturar(driver, "ct004_nome_longo");
    }

    @Test
    @DisplayName("CT005 - Descrição com menos de 10 caracteres")
    public void testCT005_DescricaoComMenosDeDezCaracteres() throws IOException {
        CategoryUtil.preencherFormulario(driver, "Categoria Teste", "123456789");
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_DESCRICAO, 3);
        Assertions.assertEquals(MSG_DESCRICAO_TAMANHO_INVALIDA, textoErro);

        ScreeshotUtil.capturar(driver, "ct005_descricao_curta");
    }

    @Test
    @DisplayName("CT006 - Descrição com mais de 200 caracteres")
    public void testCT006_DescricaoComMaisDeDuzentosCaracteres() throws IOException {
        CategoryUtil.preencherFormulario(driver, "Categoria Teste", "B".repeat(201));
        CategoryUtil.clicarSalvar(driver);

        String textoErro = WaitUtil.obterTextoElementoVisivel(driver, ERROR_DESCRICAO, 3);
        Assertions.assertEquals(MSG_DESCRICAO_TAMANHO_INVALIDA, textoErro);

        ScreeshotUtil.capturar(driver, "ct006_descricao_longa");
    }

    @Test
    @DisplayName("CT007 - Cadastro com sucesso")
    public void testCT007_CadastroValido() throws IOException {
        CategoryUtil.preencherFormulario(driver, "Teste Nova Categoria 2.0", "Descrição sucinta para nova categoria.");
        CategoryUtil.clicarSalvar(driver);

        String textoToast = WaitUtil.obterTextoElementoVisivel(driver, TOAST_SUCESSO, 5);
        Assertions.assertEquals(MSG_SUCESSO_CADASTRO, textoToast);

        ScreeshotUtil.capturar(driver, "ct007_cadastro_sucesso");
    }

    @Test
    @DisplayName("CT008 - Cancelar cadastro de categoria")
    public void testCT008_CancelarCadastro() throws IOException {
        CategoryUtil.preencherFormulario(driver, "Categoria Cancelada", null);
        CategoryUtil.clicarCancelar(driver);

        boolean inputInvisivel = WaitUtil.esperarElementoFicarInvisivel(driver, INPUT_NOME, 3);
        Assertions.assertTrue(inputInvisivel);

        ScreeshotUtil.capturar(driver, "ct008_cancelar_cadastro");
    }
}