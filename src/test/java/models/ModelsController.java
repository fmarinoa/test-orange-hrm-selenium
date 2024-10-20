package models;

public class ModelsController {
    private static ModelsController instance;
    private final Employee employee;

    private ModelsController() {
        this.employee = new Employee();
    }

    ModelsController(Employee employee) {
        this.employee = employee;
    }

    public static ModelsController models() {
        if (instance == null) instance = new ModelsController();
        return instance;
    }

    public Employee employee() {
        return employee;
    }
}
