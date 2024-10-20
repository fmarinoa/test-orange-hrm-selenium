package pages;

public class PagesController {
    private static PagesController instance;
    private final BasePage basePage;
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final PimPage pimPage;
    private final LogoutPage logoutPage;

    private PagesController() {
        this.basePage = new BasePage();
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.pimPage = new PimPage();
        this.logoutPage = new LogoutPage();
    }

    PagesController(BasePage basePage, LoginPage loginPage, HomePage homePage, PimPage pimPage, LogoutPage logoutPage) {
        this.basePage = basePage;
        this.loginPage = loginPage;
        this.homePage = homePage;
        this.pimPage = pimPage;
        this.logoutPage = logoutPage;
    }

    public static PagesController pages() {
        if (instance == null) instance = new PagesController();
        return instance;
    }

    public BasePage basePage() {
        return basePage;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public HomePage homePage() {
        return homePage;
    }

    public PimPage pimPage() {
        return pimPage;
    }

    public LogoutPage logoutPage() {
        return logoutPage;
    }
}
