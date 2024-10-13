package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static hooks.Hooks.screenShot;
import static steps.StepsController.steps;

public class HomeStepdefs {

    @Then("valido haber iniciado sesión correctamente encontrando <{int}> widgets")
    public void validoHaberIniciadoSesiónCorrectamenteEncontrandoWidgets(int sizeWidgets) {
        steps().homeSteps().validateSizeWidgets(sizeWidgets);
        steps().homeSteps().scrollLatestWidget(sizeWidgets);
    }

    @Then("valido haber iniciado sesión correctamente")
    public void validoHaberIniciadoSesiónCorrectamente() {
        steps().homeSteps().waitDashboard();
        screenShot();
    }

    @When("me dirijo al menú {string}")
    public void meDirijoAlMenú(String menú) {
        steps().homeSteps().clickMeu(menú);
    }
}
