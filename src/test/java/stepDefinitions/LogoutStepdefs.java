package stepDefinitions;

import io.cucumber.java.en.And;

import static hooks.Hooks.screenShot;
import static steps.StepsController.steps;

public class LogoutStepdefs {

    @And("cierro sesión")
    public void cierroSesión() {
        steps().logoutSteps().logoutInApp();
    }
}
