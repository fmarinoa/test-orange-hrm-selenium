package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driverManager.DriverManager.getDriver;
import static utils.Waits.WaitUtil.waitElementIsVisibility;

public class PimPage extends BasePage {

    @FindBy(xpath = "//h6[text()='PIM']")
    protected WebElement titlePim;

    @FindBy(xpath = "//a[text()='Add Employee']")
    protected WebElement btnAddEmployee;

    @FindBy(xpath = "//h6[text()='Add Employee']")
    protected WebElement titleAddEmployee;

    @FindBy(className = "orangehrm-employee-container")
    protected WebElement formAddEmployee;

    @FindBy(xpath = "//*[@name='firstName']")
    protected WebElement inputFirstNameNewEmployee;

    @FindBy(xpath = "//*[@name='middleName']")
    protected WebElement inputMiddleNameNewEmployee;

    @FindBy(xpath = "//*[@name='lastName']")
    protected WebElement inputLastNameNewEmployee;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement bntSaveNewEmployee;

    // Inicializa los elementos
    public PimPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitTitlePim() {
        waitElementIsVisibility(titlePim, 10);
    }

    public void clickAddEmployee() {
        click(btnAddEmployee);
    }

    public void waitContentAddEmployee() {
        waitElementIsVisibility(titleAddEmployee, 10);
        waitElementIsVisibility(formAddEmployee, 10);
    }

    public void writeFirstNameNewEmployee(String firstName) {
        sendKeys(inputFirstNameNewEmployee, firstName);
    }

    public void writeMiddleNameNewEmployee(String middleName) {
        sendKeys(inputMiddleNameNewEmployee, middleName);
    }

    public void writeLastNameNewEmployee(String lastName) {
        sendKeys(inputLastNameNewEmployee, lastName);
    }

    public void clickBtnSaveNewEmployee() {
        click(bntSaveNewEmployee);
    }
}
