@Login
Feature: Login in application

  Background:
    Given estoy en la aplicación

  @LoginSuccessful
  Scenario Outline: Login successful in application with widgets visibilities
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente encontrando <7> widgets
    Examples:
      | user  | pass     |
      | Admin | admin123 |