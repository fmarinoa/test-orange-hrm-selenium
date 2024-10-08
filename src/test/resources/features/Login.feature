@Login
Feature: Login in application

  Background:
    Given estoy en la aplicación

  @LoginSuccessful
  Scenario Outline: Login successful in application
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    Examples:
      | user  | pass     |
      | Admin | admin123 |