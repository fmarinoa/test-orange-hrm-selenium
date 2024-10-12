package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import manager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Logger.LoggerUtil;

public class Hooks {

    private static DriverManager driverManager;

    private static Scenario scenario;

    public Hooks() {
        driverManager = new DriverManager();
    }

    @Before
    public void setUp() {
        LoggerUtil.logInfo("Initializing the WebDriver...");
        driverManager.setUpDriver();
        driverManager.maximizeWindow();
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
        if (DriverManager.getDriver() != null) driverManager.quitDriver();
    }

    public static void screenShot() {
        try {
            // Llamar al método original para capturar y agregar la captura de pantalla
            byte[] evidence = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(evidence, "image/png", "evidences");
        } catch (Exception e) {
            LoggerUtil.logException("Failed to capture screenshot: ", e);
        }
    }
}
