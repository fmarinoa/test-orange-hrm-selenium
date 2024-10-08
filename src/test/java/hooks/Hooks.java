package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Logger.LoggerUtil;

public class Hooks {

    private static WebDriver driver;
    private static Scenario scenario;

    @Before
    public void setUp() {
        LoggerUtil.logInfo("Initializing the WebDriver...");
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");

        // Inicializamos el WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @After
    public void tearDown() {
        LoggerUtil.logInfo("Closing the WebDriver...");

        // Agregar la captura de pantalla final si es necesario
        if (scenario.isFailed()) screenShot();

        // Cerramos el WebDriver de manera segura
        if (driver != null) driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void screenShot() {
        try {
            // Llamar al método original para capturar y agregar la captura de pantalla
            byte[] evidence = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(evidence, "image/png", "evidences");
        } catch (Exception e) {
            LoggerUtil.logException("Failed to capture screenshot: ", e);
        }
    }
}
