package stepDefinitions;

import io.cucumber.datatable.DataTable;
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
        steps.pimSteps().waitContentAddEmployee();
        screenShot();
    }

    @Then("valido encontarme en la seccion de empleados")
    public void validoEncontarmeEnLaSeccionDeEmpleados() {
        steps.pimSteps().waitTitlePim();
        screenShot();
    }

    @And("completo la información del nuevo empleado")
    public void completoLaInformacionDelNuevoEmpleado(DataTable dataTable) {
        steps.pimSteps().writeFullNameNewEmployee(dataTable);
        screenShot();
    }

    @And("guardo el nuevo empleado")
    public void guardoElNuevoEmpleado() {
        steps.pimSteps().saveNewEmployee();
        screenShot();
    }
}
