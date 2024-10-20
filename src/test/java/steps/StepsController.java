package steps;

public class StepsController {
    private static StepsController instance;
    private final LoginSteps loginSteps;
    private final HomeSteps homeSteps;
    private final PimSteps pimSteps;
    private final LogoutSteps logoutSteps;

    private StepsController() {
        this.loginSteps = new LoginSteps();
        this.homeSteps = new HomeSteps();
        this.pimSteps = new PimSteps();
        this.logoutSteps = new LogoutSteps();
    }

    StepsController(LoginSteps loginSteps, HomeSteps homeSteps, PimSteps pimSteps, LogoutSteps logoutSteps) {
        this.loginSteps = loginSteps;
        this.homeSteps = homeSteps;
        this.pimSteps = pimSteps;
        this.logoutSteps = logoutSteps;
    }

    public static StepsController steps() {
        if (instance == null) instance = new StepsController();
        return instance;
    }

    public LoginSteps loginSteps() {
        return loginSteps;
    }

    public HomeSteps homeSteps() {
        return homeSteps;
    }

    public PimSteps pimSteps() {
        return pimSteps;
    }

    public LogoutSteps logoutSteps() {
        return logoutSteps;
    }
}

