package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelsControllerTest {
    ModelsController modelsController;

    ModelsControllerTest() {
        modelsController = new ModelsController(
                new Employee()
        );
    }

    @Test
    void testEmployeeModelInstance() {
        Employee employee1 = modelsController.employee();
        Employee employee2 = modelsController.employee();
        Assertions.assertNotNull(employee1, "Employee no debe ser null");
        Assertions.assertSame(employee1, employee2, "El método employee debe retornar la misma instancia");
    }
}
