package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static hooks.Hooks.screenShot;
import static models.ModelsController.models;
import static steps.StepsController.steps;

public class LoginStepdefs {

    @Given("estoy en la aplicación")
    public void estoyEnLaAplicación() {
        steps().loginSteps().inicarAplicacion();
    }

    @When("escribo el usuario {string}")
    public void escriboElUsuario(String username) {
        steps().loginSteps().writeUsername(username);
        screenShot();
    }

    @And("escribo la contraseña {string}")
    public void escriboLaContraseña(String password) {
        steps().loginSteps().writePassword(password);
        screenShot();
    }

    @And("presiono el botón de inciar sesión")
    public void presionoElBotónDeInciarSesión() {
        steps().loginSteps().clickLogin();
    }

    @Then("debo validar que el mensaje de error {string} sea visible y aparezca {int} veces")
    public void debo_validar_que_el_mensaje_de_error_sea_visible_y_aparezca_veces(String msgError, Integer size) {
        steps().loginSteps().validateSizeMsgError(msgError, size);
        screenShot();
    }

    @And("escribo la contraseña")
    public void escriboLaContraseña() {
        steps().loginSteps().writeHidePassword();
        screenShot();
    }

    @Then("valido encontarme en el formulario de inciar sesión")
    public void validoEncontarmeEnElFormularioDeInciarSesión() {
        steps().loginSteps().waitContentFormLogin();
        screenShot();
    }

    @And("inicio sesión con el usuario creado para el empleado")
    public void inicioSesiónConElUsuarioCreadoParaElEmpleado() {
        steps().loginSteps().writeUsername(models().employee().getUsername());
        screenShot();
        steps().loginSteps().writePassword(models().employee().getPassword());
        screenShot();
        steps().loginSteps().clickLogin();
    }
}
