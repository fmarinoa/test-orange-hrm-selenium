package pages;

public class Pages {

    public BasePage basePage() {
        return new BasePage();
    }

    public LoginPage loginPage() {
        return new LoginPage();
    }

    public HomePage homePage() {
        return new HomePage();
    }
}
