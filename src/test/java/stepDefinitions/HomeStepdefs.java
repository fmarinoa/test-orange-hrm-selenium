package stepDefinitions;

import io.cucumber.java.en.Then;
import steps.Steps;

public class HomeStepdefs {

    private final Steps steps;

    public HomeStepdefs() {
        steps = new Steps();
    }

    @Then("valido haber iniciado sesión correctamente encontrando <{int}> widgets")
    public void validoHaberIniciadoSesiónCorrectamenteEncontrandoWidgets(int sizeWidgets) {
        steps.homeSteps().validateSizeWidgets(sizeWidgets);
    }
}
