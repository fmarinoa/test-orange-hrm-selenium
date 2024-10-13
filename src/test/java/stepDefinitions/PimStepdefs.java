package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static hooks.Hooks.screenShot;
import static steps.StepsController.steps;

public class PimStepdefs {

    @And("presiono el botón para agregar un nuevo empleado")
    public void presionoElBotónParaAgregarUnNuevoEmpleado() {
        steps().pimSteps().clickAddEmployee();
        steps().pimSteps().waitContentAddEmployee();
        screenShot();
    }

    @Then("valido encontarme en la seccion de empleados")
    public void validoEncontarmeEnLaSeccionDeEmpleados() {
        steps().pimSteps().waitTitlePim();
        screenShot();
    }

    @And("completo la información del nuevo empleado")
    public void completoLaInformacionDelNuevoEmpleado(DataTable dataTable) {
        steps().pimSteps().writeFullNameNewEmployee(dataTable);
        steps().pimSteps().saveEmployeeId();
        screenShot();
    }

    @And("guardo el nuevo empleado")
    public void guardoElNuevoEmpleado() {
        steps().pimSteps().saveNewEmployee();
        screenShot();
    }

    @Then("valido que el nuevo empleado se haya creado correctamente")
    public void validoQueElNuevoEmpleadoSeHayaCreadoCorrectamente() {
        steps().pimSteps().waitContentPersonalDetails();
        steps().pimSteps().validateEmployeeName();
        steps().pimSteps().validateFirstName();
        steps().pimSteps().validateMiddleName();
        steps().pimSteps().validateLastName();
        steps().pimSteps().validateEmployeeId();
        screenShot();
    }
}
