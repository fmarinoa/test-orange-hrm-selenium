package steps;

import io.cucumber.datatable.DataTable;
import models.Employee;
import pages.Pages;
import utils.Logger.LoggerUtil;

import static utils.Datatable.DatatableUtil.getValueFromTable;

public class PimSteps {

    private final Pages pages;

    private final Employee employee;

    public PimSteps() {
        pages = new Pages();
        employee = new Employee();
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

        employee.setFirstName(getValueFromTable(dataTable, "First Name"));
        pages.pimPage().writeFirstNameNewEmployee(employee.getFirstName());
        LoggerUtil.logInfo("Escribí cómo primer nombre: " + employee.getFirstName());

        employee.setMiddleName(getValueFromTable(dataTable, "Middle Name"));
        pages.pimPage().writeMiddleNameNewEmployee(employee.getMiddleName());
        LoggerUtil.logInfo("Escribí cómo segundo nombre: " + employee.getMiddleName());

        employee.setLastName(getValueFromTable(dataTable, "Last Name"));
        pages.pimPage().writeLastNameNewEmployee(employee.getLastName());
        LoggerUtil.logInfo("Escribí cómo apellido: " + employee.getLastName());
    }

    public void saveNewEmployee() {
        pages.pimPage().clickBtnSaveNewEmployee();
        LoggerUtil.logInfo("Presioné el botón para guardar el nuevo empleado");
    }
}
