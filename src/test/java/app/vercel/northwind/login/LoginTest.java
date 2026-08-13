package app.vercel.northwind.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    @Test
    public void testValidarCamposObgtsVazios() throws Exception {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='password-error']")).
                        isDisplayed(),"Email e senha são obrigatórios");
    }

    @Test
    public void testValidarFormatoEmailInvalido () throws Exception {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).sendKeys("teste.com");
        driver.findElement(By.name("password")).sendKeys("Teste@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='email-error']")).
                        isDisplayed(),"Formato de email inválido. Use: nome@dominio.com");
    }

    @Test
    public void ValidarUsuarioNaoCadastrado() throws Exception {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).sendKeys("qateste@teste.com");
        driver.findElement(By.name("password")).sendKeys("Teste@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(
                driver.findElement(By.cssSelector("[data-testid='email-error']")).
                        isDisplayed(),"Usuário não encontrado. Verifique o email ou cadastre-se.");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}


