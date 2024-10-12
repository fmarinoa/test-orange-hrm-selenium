@AddEmployee
Feature: Add employee in Application

  Background:
    Given estoy en la aplicación

  @LoginSuccessful
  Scenario Outline: Added new a simple employee in application
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    When me dirijo al menú "PIM"
    And presiono el botón para agregar un nuevo empleado
    And completo la información del nuevo empleado
      | FirstName | MiddleName     | LastName     |
      | NameTest  | MiddleNameTest | LastNameTest |
    And guardo el nuevo empleado
    Then valido que el nuevo empleado se haya creado correctamente
    Examples:
      | user  | pass     |
      | Admin | admin123 |