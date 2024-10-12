package steps;

import pages.Pages;
import utils.Logger.LoggerUtil;

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
}
