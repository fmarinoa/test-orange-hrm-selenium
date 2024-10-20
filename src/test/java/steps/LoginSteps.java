package steps;

import org.openqa.selenium.WebElement;
import readers.PropertiesReader;
import readers.YamlReader;
import utils.Logger.LoggerUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.PagesController.pages;

public class LoginSteps {

    public void inicarAplicacion() {
        String env = new YamlReader().getEnvironment();
        LoggerUtil.logInfo("Abriendo el ambiente: " + env);
        pages().basePage().getUrl(env);
    }

    public void writeUsername(String username) {
        pages().loginPage().writeUsername(username);
        LoggerUtil.logInfo("Escribí el usuario: " + username);
    }

    public void writePassword(String password) {
        pages().loginPage().writePassword(password);
        LoggerUtil.logInfo("Escribí la contraseña: " + password);
    }

    public void clickLogin() {
        pages().loginPage().clickBtnLogin();
        LoggerUtil.logInfo("Presioné el botón de login");
    }

    public void validateSizeMsgError(String msgError, Integer size) {
        List<WebElement> element = waitMsgError(msgError);
        assertEquals(size, element.size(), "El mensaje de error no se muestra la cantidad de veces esperada");
        LoggerUtil.logInfo("El mensaje de error apareció " + size + " veces");
    }

    public List<WebElement> waitMsgError(String msgError) {
        String xPathMsgError = "//*[text()='" + msgError + "']";
        LoggerUtil.logInfo("XPath ha converitir en un elemento de mensaje de error: " + xPathMsgError);
        return pages().loginPage().waitMsgError(xPathMsgError);
    }

    public void writeHidePassword() {
        String password = new PropertiesReader().getProperty("password");
        pages().loginPage().writePassword(password);
        LoggerUtil.logInfo("Escribí la contraseña: " + password);
    }

    public void waitContentFormLogin() {
        pages().loginPage().waitContentFormLogin();
        LoggerUtil.logInfo("Estoy en el formulario de Login");
    }
}
