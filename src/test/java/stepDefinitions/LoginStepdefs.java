package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import steps.Steps;

import static hooks.Hooks.screenShot;

public class LoginStepdefs {

    private final Steps steps;

    public LoginStepdefs() {
        steps = new Steps();
    }

    @Given("estoy en la aplicación")
    public void estoyEnLaAplicación() {
        steps.loginSteps().inicarAplicacion();
    }

    @When("escribo el usuario {string}")
    public void escriboElUsuario(String username) {
        steps.loginSteps().writeUsername(username);
        screenShot();
    }

    @And("escribo la contraseña {string}")
    public void escriboLaContraseña(String password) {
        steps.loginSteps().writePassword(password);
        screenShot();
    }

    @And("presiono el botón de inciar sesión")
    public void presionoElBotónDeInciarSesión() {
        steps.loginSteps().clickLogin();
    }
}
