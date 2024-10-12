package driverManager;

public class WebDriverFactory {
    public static WebDriverSetup getWebDriverSetup(String browserName, String browserPath, boolean isHeadless) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriverSetup(browserPath, isHeadless);
            case "edge":
                return new EdgeDriverSetup(browserPath, isHeadless);
            // Otros navegadores...
            default:
                throw new IllegalArgumentException("Navegador no soportado: " + browserName);
        }
    }
}

