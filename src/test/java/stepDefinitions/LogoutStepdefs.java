package stepDefinitions;

import io.cucumber.java.en.And;
import static steps.StepsController.steps;

public class LogoutStepdefs {

    @And("cierro sesión")
    public void cierroSesión() {
        steps().logoutSteps().logoutInApp();
    }
}
