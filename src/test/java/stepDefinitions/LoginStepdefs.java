package stepDefinitions;

import io.cucumber.java.en.Given;

import steps.Steps;

public class LoginStepdefs {

    private final Steps steps;

    public LoginStepdefs() {
        steps = new Steps();
    }

    @Given("estoy en la aplicación")
    public void estoyEnLaAplicación() {
        steps.loginSteps().inicarAplicacion();
    }
}
