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
    }
}
