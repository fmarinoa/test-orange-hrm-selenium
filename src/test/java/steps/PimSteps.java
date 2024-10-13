package steps;

import io.cucumber.datatable.DataTable;
import utils.Logger.LoggerUtil;

import static models.ModelsController.models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.PagesController.pages;
import static utils.Datatable.DatatableUtil.getValueFromTable;

public class PimSteps {

    public void waitTitlePim() {
        pages().pimPage().waitTitlePim();
        LoggerUtil.logInfo("Me encuentro en la página PIM");
    }

    public void clickAddEmployee() {
        pages().pimPage().clickAddEmployee();
        LoggerUtil.logInfo("Presioné el botón para agregar un nuevo empleado");
    }

    public void waitContentAddEmployee() {
        pages().pimPage().waitContentAddEmployee();
        LoggerUtil.logInfo("Validé que exista el contenido de la página para agregar nuevos empleados");
    }

    public void writeFullNameNewEmployee(DataTable dataTable) {
        LoggerUtil.logInfo("Llenando los datos del nuevo cliente...");

        models().employee().setFirstName(getValueFromTable(dataTable, "First Name"));
        pages().pimPage().writeFirstNameNewEmployee(models().employee().getFirstName());
        LoggerUtil.logInfo("Escribí cómo primer nombre: " + models().employee().getFirstName());

        models().employee().setMiddleName(getValueFromTable(dataTable, "Middle Name"));
        pages().pimPage().writeMiddleNameNewEmployee(models().employee().getMiddleName());
        LoggerUtil.logInfo("Escribí cómo segundo nombre: " + models().employee().getMiddleName());

        models().employee().setLastName(getValueFromTable(dataTable, "Last Name"));
        pages().pimPage().writeLastNameNewEmployee(models().employee().getLastName());
        LoggerUtil.logInfo("Escribí cómo apellido: " + models().employee().getLastName());
    }

    public void saveEmployeeId() {
        models().employee().setId(pages().pimPage().getEmployeeId());
        LoggerUtil.logInfo("Capturé el ID de empleado: " + models().employee().getId());
    }

    public void saveNewEmployee() {
        pages().pimPage().clickBtnSaveNewEmployee();
        LoggerUtil.logInfo("Presioné el botón para guardar el nuevo empleado");
    }

    public void waitContentPersonalDetails() {
        pages().pimPage().waitTitlePersonalDetails();
    }

    public void validateEmployeeName() {
        String expectedName = models().employee().getFirstName() + " " + models().employee().getLastName();
        String currentName = pages().pimPage().getEmployeeName();
        assertEquals(expectedName, currentName, "El nombre actual no coincide con el nombre esperado");
        LoggerUtil.logInfo("Nombre completo validado: " + expectedName);
    }
}
