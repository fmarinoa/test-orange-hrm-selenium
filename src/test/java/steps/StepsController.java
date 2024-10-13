package steps;

public class StepsController {
    private static StepsController instance;
    private final LoginSteps loginSteps;
    private final HomeSteps homeSteps;
    private final PimSteps pimSteps;

    private StepsController() {
        this.loginSteps = new LoginSteps();
        this.homeSteps = new HomeSteps();
        this.pimSteps = new PimSteps();
    }

    StepsController(LoginSteps loginSteps, HomeSteps homeSteps, PimSteps pimSteps) {
        this.loginSteps = loginSteps;
        this.homeSteps = homeSteps;
        this.pimSteps = pimSteps;
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
}

