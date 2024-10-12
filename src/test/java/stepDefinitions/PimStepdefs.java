package stepDefinitions;

import io.cucumber.java.en.*;
import steps.Steps;

import static hooks.Hooks.screenShot;

public class PimStepdefs {

    private final Steps steps;

    public PimStepdefs() {
        steps = new Steps();
    }

    @And("presiono el botón para agregar un nuevo empleado")
    public void presionoElBotónParaAgregarUnNuevoEmpleado() {
        steps.pimSteps().clickAddEmployee();
        screenShot();
    }

    @Then("valido encontarme en la seccion de empleados")
    public void validoEncontarmeEnLaSeccionDeEmpleados() {
        steps.pimSteps().waitTitlePim();
        screenShot();
    }
}
