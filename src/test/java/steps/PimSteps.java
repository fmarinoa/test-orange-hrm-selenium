package steps;

import io.cucumber.datatable.DataTable;
import utils.Logger.LoggerUtil;

import static models.ModelsController.models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.PagesController.pages;
import static utils.Datatable.DatatableUtil.getValueFromTable;
import static utils.Waits.WaitUtil.waitForSeconds;

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
        assertEquals(expectedName, currentName, "El nombre completo actual no coincide con el esperado");
        LoggerUtil.logInfo("Nombre completo validado: " + expectedName);
    }

    public void validateFirstName() {
        String expectedName = models().employee().getFirstName();
        String currentName = pages().pimPage().getEmployeeFirstName();
        assertEquals(expectedName, currentName, "El primer nombre actual no coincide con el esperado");
        LoggerUtil.logInfo("Primer nombre validado: " + expectedName);
    }

    public void validateMiddleName() {
        String expectedName = models().employee().getMiddleName();
        String currentName = pages().pimPage().getEmployeeMiddleName();
        assertEquals(expectedName, currentName, "El segundo nombre actual no coincide con el esperado");
        LoggerUtil.logInfo("Segundo nombre validado: " + expectedName);
    }

    public void validateLastName() {
        String expectedName = models().employee().getLastName();
        String currentName = pages().pimPage().getEmployeeLastName();
        assertEquals(expectedName, currentName, "El apellido actual no coincide con el esperado");
        LoggerUtil.logInfo("Apellido validado: " + expectedName);
    }

    public void validateEmployeeId() {
        String expectedName = models().employee().getId();
        String currentName = pages().pimPage().getEmployeeId();
        assertEquals(expectedName, currentName, "El apellido actual no coincide con el esperado");
        LoggerUtil.logInfo("Apellido validado: " + expectedName);
    }

    public void checkCreateDetailsLogin() {
        pages().pimPage().clickCheckBoxCreateDetailsLogin();
        LoggerUtil.logInfo("Habilité el check box Create Details Login");
    }

    public void writeDetailsLogin(DataTable dataTable) {
        LoggerUtil.logInfo("Llenando los datos del nuevo login");

        models().employee().setUsername(getValueFromTable(dataTable, "Username"));
        pages().pimPage().writeUserName(models().employee().getUsername());
        LoggerUtil.logInfo("Escribí cómo nuevo usuario: " + models().employee().getUsername());

        models().employee().setPassword(getValueFromTable(dataTable, "Password"));
        pages().pimPage().writePassWord(models().employee().getPassword());
        LoggerUtil.logInfo("Escribí cómo nueva contraseña: " + models().employee().getPassword());

        pages().pimPage().writeConfirmPassWord(models().employee().getPassword());
        LoggerUtil.logInfo("Confirmé la nueva contraseña: " + models().employee().getPassword());
    }

    public void writeEmployeeId(String employeeId) {
        models().employee().setId(employeeId);
        pages().pimPage().writeEmployeeId(employeeId);
        LoggerUtil.logInfo("Escribí el id de empleado: " + employeeId);
        pages().pimPage().clickBtnSearch();
        LoggerUtil.logInfo("Presioné el botón Search");
    }

    public void waitContentExactlyRows(int expectedRows) {
        final int ATTEMPTS_MAX = 5;

        for (int i = 0; i < ATTEMPTS_MAX; i++) {
            int currentRows = pages().pimPage().getSizeRows();
            if (currentRows == expectedRows) {
                LoggerUtil.logInfo("Se encontró la cantidad de filas esperadas en la lista de empleados: " + expectedRows);
                return;
            }
            waitForSeconds(1);
        }

        throw new RuntimeException("El listado de empleado no tuvo un solo resultado luego de " + ATTEMPTS_MAX + " intentos");
    }

    public void scrollToTableEmployeeList() {
        pages().pimPage().scrollToTableEmployeeList();
        LoggerUtil.logInfo("Me desplacé hasta la tabla del listado de empleados");
    }

    public void validateEmployeeIdInTableEmployeeList(String employeeId) {
        String currentEmployeeId = pages().pimPage().getEmployeeIdInTableEmployeeList();
        assertTrue(currentEmployeeId.contains(employeeId), employeeId + " no se encuentra en el Id del cliente de la prinera fila en el listado de empleados");
    }
}
