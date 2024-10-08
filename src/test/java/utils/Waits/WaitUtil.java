package utils.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logger.LoggerUtil;

import java.time.Duration;

import static hooks.Hooks.getDriver;

public class WaitUtil {

    // Método para esperar que un WebElement sea visible
    public static void waitElementIsVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Método para esperar que un WebElement sea clikeable
    public static void waitElementIsClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForSeconds(int seconds) {
        try {
            LoggerUtil.logInfo("Esperando " + seconds + "segundos...");
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
