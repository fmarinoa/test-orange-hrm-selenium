package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driverManager.DriverManager.getDriver;
import static hooks.Hooks.screenShot;

public class LogoutPage extends BasePage {

    @FindBy(className = "oxd-userdropdown-tab")
    protected WebElement tabOptionsSession;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[4]/a")
    protected WebElement btnLogout;

    // Inicializa los elementos
    public LogoutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void logoutSession() {
        click(tabOptionsSession);
        screenShot();
        click(btnLogout, 10);
    }

}
