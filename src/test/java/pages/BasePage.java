package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static driverManager.DriverManager.getDriver;
import static utils.Waits.WaitUtil.waitElementIsClickable;
import static utils.Waits.WaitUtil.waitElementIsVisibility;

public class BasePage {

    public void getUrl(String url) {
        getDriver().get(url);
    }

    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void sendKeys(WebElement element, String value, int timeOut) {
        waitElementIsVisibility(element, timeOut);
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(WebElement element, int timeOut) {
        waitElementIsClickable(element, timeOut);
        click(element);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getTextNotEmpty(WebElement element, int timeoutInSeconds) {
        long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000L;

        while (System.currentTimeMillis() < endTime) {
            String elementText = element.getText();
            if (!elementText.isEmpty()) {
                return elementText;
            }
            try {
                // Dormir por un corto tiempo antes de volver a intentar
                Thread.sleep(500); // medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si se agota el tiempo, devolver null o lanzar una excepción
        throw new RuntimeException("El texto no fue encontrado antes de que se agotara el tiempo.");
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public String getValueNotNull(WebElement element, int timeoutInSeconds) {
        long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000L;

        while (System.currentTimeMillis() < endTime) {
            String elementAttribute = element.getAttribute("value");
            if (elementAttribute != null) {
                return elementAttribute;
            }
            try {
                // Dormir por un corto tiempo antes de volver a intentar
                Thread.sleep(500); // medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si se agota el tiempo, devolver null o lanzar una excepción
        throw new RuntimeException("El valor no fue encontrado antes de que se agotara el tiempo.");
    }

    public void clickWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
