package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static hooks.Hooks.getDriver;
import static utils.Waits.WaitUtil.waitElementsAreVisibility;

public class HomePage {

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
}
