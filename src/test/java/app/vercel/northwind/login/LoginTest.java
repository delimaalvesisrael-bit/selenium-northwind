package app.vercel.northwind.login;

import app.vercel.northwind.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidarCamposObgtsVazios() throws Exception {
        driver.get(baseURL);
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement message = driver.findElement(By.cssSelector("[data-testid='password-error']"));

        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertEquals("Email e senha são obrigatórios", message.getText());

    }

    @Test
    public void testValidarFormatoEmailInvalido () throws Exception {
        driver.get(baseURL);
        driver.findElement(By.name("email")).sendKeys("teste.com");
        driver.findElement(By.name("password")).sendKeys("Teste@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='email-error']")).
                        isDisplayed(),"Formato de email inválido. Use: nome@dominio.com");
    }

    @Test
    public void ValidarUsuarioNaoCadastrado() throws Exception {
        driver.get(baseURL);
        driver.findElement(By.name("email")).sendKeys("qateste@teste.com");
        driver.findElement(By.name("password")).sendKeys("Teste@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='email-error']")).
                        isDisplayed(),"Usuário não encontrado. Verifique o email ou cadastre-se.");
    }

    @Test
    public void ValidarSenhaIncorreta () throws Exception {
        driver.get(baseURL);
        driver.findElement(By.name("email")).sendKeys("admin@qatest.com");
        driver.findElement(By.name("password")).sendKeys("teste123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='password-error']")).
                        isDisplayed(),"Email ou senha inválidos.");
    }
}


