package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driverManager.DriverManager.getDriver;
import static utils.Scroll.ScrollUtil.scrollToElement;
import static utils.Waits.WaitUtil.waitElementIsClickable;
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

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]/descendant::input")
    protected WebElement txtEmployeeId;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    protected WebElement titlePersonalDetails;

    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-name']/h6")
    protected WebElement textEmployeeName;

    @FindBy(xpath = "//div[@class='oxd-switch-wrapper']/label/input[@type='checkbox']")
    protected WebElement cbCreateDetailsLogin;

    @FindBy(xpath = "//label[text()='Username']/../../div[2]/input")
    protected WebElement inputNewUserName;

    @FindBy(xpath = "//label[text()='Password']/../../div[2]/input")
    protected WebElement inputNewPassWord;

    @FindBy(xpath = "//label[text()='Confirm Password']/../../div[2]/input")
    protected WebElement inputConfirmPassWord;

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
        scrollToElement(bntSaveNewEmployee);
        click(bntSaveNewEmployee);
    }

    public String getEmployeeId() {
        return getValue(txtEmployeeId);
    }

    public void waitTitlePersonalDetails() {
        waitElementIsVisibility(titlePersonalDetails, 30);
    }

    public String getEmployeeName() {
        while (true) {
            String employeeName = getText(textEmployeeName);
            if (!employeeName.isEmpty()) return employeeName;
        }
    }

    public String getEmployeeFirstName() {
        return getValue(inputFirstNameNewEmployee);
    }

    public String getEmployeeMiddleName() {
        return getValue(inputMiddleNameNewEmployee);
    }

    public String getEmployeeLastName() {
        return getValue(inputLastNameNewEmployee);
    }

    public void clickCheckBoxCreateDetailsLogin() {
        clickWithJs(cbCreateDetailsLogin);
    }

    public void writeUserName(String username) {
        sendKeys(inputNewUserName, username, 10);
    }

    public void writePassWord(String password) {
        sendKeys(inputNewPassWord, password);
    }

    public void writeConfirmPassWord(String password) {
        sendKeys(inputConfirmPassWord, password);
    }
}
