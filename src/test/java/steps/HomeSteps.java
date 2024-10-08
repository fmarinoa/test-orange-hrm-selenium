package steps;

import pages.Pages;
import utils.Logger.LoggerUtil;

import static hooks.Hooks.getDriver;

public class HomeSteps {

    private final Pages pages;

    public HomeSteps() {
        pages = new Pages();
    }

    public void validateSizeWidgets(int sizeWidgets) {
        final int attemptMax = 5;
        int attempt = 0;

        do {
            pages.homePage().waitDashboard(10);
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
}
