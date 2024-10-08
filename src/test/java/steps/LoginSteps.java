package steps;

import pages.Pages;
import readers.YamlReader;

public class LoginSteps {

    private final Pages pages;

    public LoginSteps() {
        pages = new Pages();
    }

    public void inicarAplicacion() {
        pages.basePage().getUrl(new YamlReader().getEnv());
    }
}
