package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagesControllerTest {

    PagesController pagesController;

    PagesControllerTest() {
        pagesController = new PagesController(
                new BasePage(),
                new LoginPage(),
                new HomePage(),
                new PimPage()
        );
    }

    @Test
    void testBasePageInstance() {
        BasePage basePage1 = pagesController.basePage();
        BasePage basePage2 = pagesController.basePage();
        Assertions.assertNotNull(basePage1, "BasePage no debe ser null");
        Assertions.assertSame(basePage1, basePage2, "El método basePage debe retornar la misma instancia");
    }

    @Test
    void testLoginPageInstance() {
        LoginPage loginPage1 = pagesController.loginPage();
        LoginPage loginPage2 = pagesController.loginPage();
        Assertions.assertNotNull(loginPage1, "LoginPage no debe ser null");
        Assertions.assertSame(loginPage1, loginPage2, "El método loginPage debe retornar la misma instancia");
    }

    @Test
    void testHomePageInstance() {
        HomePage homePage1 = pagesController.homePage();
        HomePage HomePage2 = pagesController.homePage();
        Assertions.assertNotNull(homePage1, "HomePage no debe ser null");
        Assertions.assertSame(homePage1, HomePage2, "El método homePage debe retornar la misma instancia");
    }

    @Test
    void testPimPageInstance() {
        PimPage pimPage1 = pagesController.pimPage();
        PimPage pimPage2 = pagesController.pimPage();
        Assertions.assertNotNull(pimPage1, "PimPage no debe ser null");
        Assertions.assertSame(pimPage1, pimPage2, "El método pimPage debe retornar la misma instancia");
    }
}
