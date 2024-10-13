package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driverManager.DriverManager.getDriver;
import static utils.Waits.WaitUtil.waitLocatorsAreVisibilityAndReturnInWebElements;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    protected WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    protected WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement btnLogin;

    // Inicializa los elementos
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void writeUsername(String username) {
        sendKeys(inputUsername, username, 30);
    }

    public void writePassword(String password) {
        sendKeys(inputPassword, password, 30);
    }

    public void clickBtnLogin() {
        click(btnLogin, 30);
    }

    public List<WebElement> waitMsgError(String xPathMsgError) {
        return waitLocatorsAreVisibilityAndReturnInWebElements(By.xpath(xPathMsgError), 10);
    }
}
