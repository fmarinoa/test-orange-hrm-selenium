package steps;

import pages.Pages;
import readers.YamlReader;
import utils.Logger.LoggerUtil;

public class LoginSteps {

    private final Pages pages;

    public LoginSteps() {
        pages = new Pages();
    }

    public void inicarAplicacion() {
        String env = new YamlReader().getEnv();
        LoggerUtil.logInfo("Abriendo el ambiente: " + env);
        pages.basePage().getUrl(env);
    }

    public void writeUsername(String username) {
        pages.loginPage().writeUsername(username);
        LoggerUtil.logInfo("Escribí el usuario: " + username);
    }

    public void writePassword(String password) {
        pages.loginPage().writePassword(password);
        LoggerUtil.logInfo("Escribí la contraseña: " + password);
    }

    public void clickLogin() {
        pages.loginPage().clickBtnLogin();
        LoggerUtil.logInfo("Presioné el botón de login");
    }
}
