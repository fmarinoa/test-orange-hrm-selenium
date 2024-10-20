package steps;

import utils.Logger.LoggerUtil;

import static pages.PagesController.pages;

public class LogoutSteps {

    public void logoutInApp() {
        pages().logoutPage().logoutSession();
        LoggerUtil.logInfo("Cerré sesión");
    }
}
