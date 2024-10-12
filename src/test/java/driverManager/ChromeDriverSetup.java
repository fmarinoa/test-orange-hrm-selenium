package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverSetup implements WebDriverSetup {
    private final String browserPath;
    private final boolean isHeadless;

    public ChromeDriverSetup(String browserPath, boolean isHeadless) {
        this.browserPath = browserPath;
        this.isHeadless = isHeadless;
    }

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", browserPath);
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
