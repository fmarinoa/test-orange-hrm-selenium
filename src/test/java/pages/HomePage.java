package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driverManager.DriverManager.getDriver;
import static utils.Scroll.ScrollUtil.scrollToElement;
import static utils.Waits.WaitUtil.waitElementsAreVisibility;
import static utils.Waits.WaitUtil.waitLocatorIsVisibility;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'orangehrm-dashboard-grid')]/*[contains(@class,'orangehrm-dashboard-widget')]")
    protected List<WebElement> dashboardWidgets;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public int getSizeWidgets() {
        return dashboardWidgets.size();
    }

    public void waitDashboard(int timeOut) {
        waitElementsAreVisibility(dashboardWidgets, timeOut);
    }

    public void scrollWidgetByIndex(int index) {
        scrollToElement(dashboardWidgets.get(index));
    }

    public void clickMenuByXPath(String xpath) {
        waitLocatorIsVisibility(By.xpath(xpath), 10);
        click(getDriver().findElement(By.xpath(xpath)));
    }
}
