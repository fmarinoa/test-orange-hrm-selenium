package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driverManager.DriverManager.getDriver;
import static utils.Waits.WaitUtil.waitElementIsVisibility;

public class PimPage extends BasePage {

    @FindBy(xpath = "//h6[text()='PIM']")
    protected WebElement titlePim;

    // Inicializa los elementos
    public PimPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitTitlePim() {
        waitElementIsVisibility(titlePim, 10);
    }
}
