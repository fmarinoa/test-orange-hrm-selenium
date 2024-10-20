@Logout
Feature: Login and Logout in application

  Background:
    Given estoy en la aplicación

  @LoginAndLogoutSuccessful
  Scenario Outline: Login and logout successful in application
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    And cierro sesión
    Examples:
      | user  |
      | Admin |