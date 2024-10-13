@AddEmployee
Feature: Add employee in Application

  Background:
    Given estoy en la aplicación

  @AddEmployeeSimple
  Scenario Outline: Added new a simple employee in application
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    When me dirijo al menú "PIM"
    Then valido encontarme en la seccion de empleados
    When presiono el botón para agregar un nuevo empleado
    And completo la información del nuevo empleado
      | First Name | Middle Name      | Last Name      |
      | Name Test  | Middle Name Test | Last Name Test |
    And guardo el nuevo empleado
    Then valido que el nuevo empleado se haya creado correctamente
    Examples:
      | user  | pass     |
      | Admin | admin123 |