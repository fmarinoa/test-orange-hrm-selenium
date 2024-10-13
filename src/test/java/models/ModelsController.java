package models;

public class ModelsController {
    private static ModelsController instance;
    private final Employee employee;

    private ModelsController() {
        this.employee = new Employee();
    }

    public static ModelsController models() {
        if (instance == null) instance = new ModelsController();
        return instance;
    }

    public Employee employee() {
        return employee;
    }
}
