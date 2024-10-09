package steps;

import pages.Pages;
import utils.Logger.LoggerUtil;

import static hooks.Hooks.getDriver;
import static hooks.Hooks.screenShot;
import static utils.Scroll.ScrollUtil.scrollToElement;

public class HomeSteps {

    private final Pages pages;

    public HomeSteps() {
        pages = new Pages();
    }

    public void validateSizeWidgets(int sizeWidgets) {
        final int attemptMax = 5;
        int attempt = 0;

        do {
            waitDashboard();
            int currentSize = pages.homePage().getSizeWidgets();
            LoggerUtil.logInfo("Encontré " + currentSize + " widgets");
            if (sizeWidgets == currentSize) return;
            LoggerUtil.logInfo("Reintentando...");
            getDriver().navigate().refresh();
            attempt++;
        } while (attempt <= attemptMax);

        throw new RuntimeException("No se se pudo validar la cantidad de widgets en el dashboard después de " + attemptMax + " reintentos");
    }

    public void waitDashboard() {
        pages.homePage().waitDashboard(10);
        LoggerUtil.logInfo("Encontré el dashboard");
    }

    public void scrollLatestWidget(int sizeWidgets) {
        for (int n = 1; n <= 3; n++) {
            if (n == 1) {
                screenShot();
                continue;
            }
            int position = calculatePosition(n);
            if (position <= sizeWidgets) {
                pages.homePage().scrolWidgetByIndex(position - 1);
                LoggerUtil.logInfo("Me desplacé al widget: " + position);
                screenShot();
            } else {
                pages.homePage().scrolWidgetByIndex(position - 1);
                LoggerUtil.logInfo("Me desplacé al widget: " + position);
                screenShot();
                break; // No seguir si se ha llegado al último elemento
            }
        }
    }

    // Método para calcular la posición
    private int calculatePosition(int n) {
        return 3 * (n - 1) + 1; // Lógica de la posición
    }
}
