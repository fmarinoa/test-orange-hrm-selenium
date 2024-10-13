package steps;

import io.cucumber.datatable.DataTable;
import pages.Pages;
import utils.Logger.LoggerUtil;

import static utils.Datatable.DatatableUtil.getValueFromTable;

public class PimSteps {

    private final Pages pages;

    public PimSteps() {
        pages = new Pages();
    }

    public void waitTitlePim() {
        pages.pimPage().waitTitlePim();
        LoggerUtil.logInfo("Me encuentro en la página PIM");
    }

    public void clickAddEmployee() {
        pages.pimPage().clickAddEmployee();
        LoggerUtil.logInfo("Presioné el botón para agregar un nuevo empleado");
    }

    public void waitContentAddEmployee() {
        pages.pimPage().waitContentAddEmployee();
        LoggerUtil.logInfo("Validé que exista el contenido de la página para agregar nuevos empleados");
    }

    public void writeFullNameNewEmployee(DataTable dataTable) {
        LoggerUtil.logInfo("Llenando los datos del nuevo cliente...");
        String firstName = getValueFromTable(dataTable, "First Name");
        String middleName = getValueFromTable(dataTable, "Middle Name");
        String lastName = getValueFromTable(dataTable, "Last Name");
        pages.pimPage().writeFirstNameNewEmployee(firstName);
        LoggerUtil.logInfo("Escribí cómo primer nombre: " + firstName);
        pages.pimPage().writeMiddleNameNewEmployee(middleName);
        LoggerUtil.logInfo("Escribí cómo segundo nombre: " + middleName);
        pages.pimPage().writeLastNameNewEmployee(lastName);
        LoggerUtil.logInfo("Escribí cómo apellido: " + lastName);
    }

    public void saveNewEmployee() {
        pages.pimPage().clickBtnSaveNewEmployee();
        LoggerUtil.logInfo("Presioné el botón para guardar el nuevo empleado");
    }
}
