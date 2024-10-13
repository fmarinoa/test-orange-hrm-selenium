package steps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepsControllerTest {

    StepsController stepsController;

    StepsControllerTest() {
        stepsController = new StepsController(
                new LoginSteps(),
                new HomeSteps(),
                new PimSteps()
        );
    }

    @Test
    void testLoginStepsInstance() {
        LoginSteps loginSteps1 = stepsController.loginSteps();
        LoginSteps loginSteps2 = stepsController.loginSteps();
        Assertions.assertNotNull(loginSteps1, "LoginSteps no debe ser null");
        Assertions.assertSame(loginSteps1, loginSteps2, "El método loginSteps debe retornar la misma instancia");
    }

    @Test
    void testHomeStepsInstance() {
        HomeSteps homeSteps1 = stepsController.homeSteps();
        HomeSteps homeSteps2 = stepsController.homeSteps();
        Assertions.assertNotNull(homeSteps1, "HomeSteps no debe ser null");
        Assertions.assertSame(homeSteps1, homeSteps2, "El método homeSteps debe retornar la misma instancia");
    }

    @Test
    void testPimStepsInstance() {
        PimSteps pimSteps1 = stepsController.pimSteps();
        PimSteps pimSteps2 = stepsController.pimSteps();
        Assertions.assertNotNull(pimSteps1, "PimSteps no debe ser null");
        Assertions.assertSame(pimSteps1, pimSteps2, "El método pimSteps debe retornar la misma instancia");
    }
}
