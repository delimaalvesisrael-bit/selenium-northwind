package app.vercel.northwind.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected final String baseURL = "https://northwind-test-platform.vercel.app/";
    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}
