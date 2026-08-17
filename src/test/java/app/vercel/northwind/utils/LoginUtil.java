package app.vercel.northwind.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUtil {

    private static final String URL_LOGIN =
            "https://northwind-test-platform.vercel.app/";

    private LoginUtil() {
    }

    public static void acessarSistema(
            WebDriver driver,
            String email,
            String senha) {

        driver.get(URL_LOGIN);

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(
                By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(email);
        inputPassword.sendKeys(senha);
        btnLogin.click();
    }
}