package pages;

import org.openqa.selenium.WebElement;

import static manager.DriverManager.getDriver;
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
}
