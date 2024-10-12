package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverSetup implements WebDriverSetup {
    private final String browserPath;
    private final boolean isHeadless;

    public EdgeDriverSetup(String browserPath, boolean isHeadless) {
        this.browserPath = browserPath;
        this.isHeadless = isHeadless;
    }

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.edge.driver", browserPath);
        EdgeOptions options = new EdgeOptions();

        if (isHeadless) {
            options.addArguments("headless");
            options.addArguments("disable-gpu");
        }

        return new EdgeDriver(options);
    }
}
