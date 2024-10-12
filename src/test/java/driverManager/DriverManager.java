package driverManager;

import org.openqa.selenium.WebDriver;
import readers.YamlReader;

public class DriverManager {

    private static WebDriver driver;

    private final YamlReader yamlReader = new YamlReader();
    private final String browserName = yamlReader.getBrowserName();
    private final String browserPath = yamlReader.getBrowserPath();
    private final boolean isHeadless = yamlReader.isHeadless();


    public void setUpDriver() {
        driver = WebDriverFactory.getWebDriverSetup(browserName, browserPath, isHeadless).getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
