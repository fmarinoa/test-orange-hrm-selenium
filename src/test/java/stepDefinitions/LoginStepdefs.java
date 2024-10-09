package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
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

    @Then("debo validar que el mensaje de error {string} sea visible debajo de los campos de entrada y aparezca {int} veces")
    public void debo_validar_que_el_mensaje_de_error_sea_visible_debajo_de_los_campos_de_entrada_y_aparezca_veces(String msgError, Integer size) {
        steps.loginSteps().validateSizeMsgError(msgError, size);
        screenShot();
    }
}
