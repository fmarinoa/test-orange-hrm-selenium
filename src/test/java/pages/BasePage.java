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

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void clickWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
