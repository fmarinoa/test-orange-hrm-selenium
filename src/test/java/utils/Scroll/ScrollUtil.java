package utils.Scroll;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static driverManager.DriverManager.getDriver;


public class ScrollUtil {

    // Método para hacer scroll hacia arriba hasta el principio de la página
    public static void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
    }

    // Método para hacer scroll hacia abajo
    public static void scrollToBottom() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Método para hacer scroll hasta un elemento específico
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Método para hacer scroll hacia abajo una cantidad específica de píxeles
    public static void scrollDown(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + pixels + ");");
    }

    // Método para hacer scroll hacia arriba una cantidad específica de píxeles
    public static void scrollUp(int pixels) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,-" + pixels + ");");
    }
}
