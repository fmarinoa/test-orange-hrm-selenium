package pages;

public class PagesController {
    private static PagesController instance;
    private final BasePage basePage;
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final PimPage pimPage;

    private PagesController() {
        this.basePage = new BasePage();
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.pimPage = new PimPage();
    }

    PagesController(BasePage basePage, LoginPage loginPage, HomePage homePage, PimPage pimPage) {
        this.basePage = new BasePage();
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.pimPage = new PimPage();
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
}
