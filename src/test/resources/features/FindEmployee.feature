@FindEmployee
Feature: Find employee in Application

  Background:
    Given estoy en la aplicación

  @FindEmployeeSimple
  Scenario Outline: Find employee in application and validate employee id in table employee list
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    When me dirijo al menú "PIM"
    Then valido encontarme en la seccion de empleados
    When busco al empleado con ID "<employee_id>"
    Then valido que haya <1> resultado(s) en el listado de empleados
    And valido que el ID del empleado en la listado de empleados sea "<employee_id>"
    Examples:
      | user  | employee_id |
      | Admin | 0312        |