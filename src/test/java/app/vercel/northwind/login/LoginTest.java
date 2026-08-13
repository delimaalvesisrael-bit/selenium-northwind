package app.vercel.northwind.login;

import app.vercel.northwind.base.BaseTest;
import app.vercel.northwind.utils.ScreeshotUtil;
import app.vercel.northwind.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidarCamposObgtsVazios() throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.click();
        inputPassword.click();
        btnLogin.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='password-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.MSG_CAMPOS_OBRIGATORIOS, message.getText());

        ScreeshotUtil.capturar(driver,"campos_obrigatorios");

    }

    @Test
    public void testValidarFormatoEmailInvalido () throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(TestData.EMAIL_INVALIDO);
        inputPassword.sendKeys(TestData.SENHA_INVALIDA);
        btnLogin.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='email-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.MSG_EMAIL_INVALIDO, message.getText());

        ScreeshotUtil.capturar(driver,"email_invalido");

    }

    @Test
    public void testValidarUsuarioNaoCadastrado() throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(TestData.EMAIL_INEXISTENTE);
        inputPassword.sendKeys(TestData.SENHA_VALIDA);
        btnLogin.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='email-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.MSG_USER_NOTFOUND, message.getText());

        ScreeshotUtil.capturar(driver,"usuario_nao_cadastrado");
    }

    @Test
    public void testValidarSenhaIncorreta() throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(TestData.EMAIL_VALIDO);
        inputPassword.sendKeys(TestData.SENHA_INVALIDA);
        btnLogin.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='password-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.MSG_SENHA_INVALIDA, message.getText());

        ScreeshotUtil.capturar(driver,"senha_incorreta");

    }
    @Test
    public void testValidarSenhaComMenosSeisCarateres() throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(TestData.EMAIL_VALIDO);
        inputPassword.sendKeys(TestData.SENHA_CURTA);
        btnLogin.click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='email-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.MSG_SENHA_CURTA, message.getText());

        ScreeshotUtil.capturar(driver,"senha_curta");
    }

    @Test
    public void testValidarLoginComSucesso () throws IOException {
        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(TestData.EMAIL_VALIDO);
        inputPassword.sendKeys(TestData.SENHA_VALIDA);

        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://northwind-test-platform.vercel.app/products"));

        Assertions.assertEquals("https://northwind-test-platform.vercel.app/products",
                driver.getCurrentUrl());
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals(TestData.TITULO_HOME_PAGE, message.getText());

        ScreeshotUtil.capturar(driver,"home_page");
    }
}


