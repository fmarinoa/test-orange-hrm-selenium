@Login
Feature: Login in application

  Background:
    Given estoy en la aplicación

  @LoginSuccessful
  Scenario Outline: Login successful in application with widgets visibilities
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    Examples:
      | user  | pass     |
      | Admin | admin123 |

  @LoginSuccessfulAndValidateWidgets
  Scenario Outline: Login successful in application with widgets visibilities
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente encontrando <7> widgets
    Examples:
      | user  | pass     |
      | Admin | admin123 |

  @LoginWithoutCredentials
  Scenario Outline: Login without credential
    And presiono el botón de inciar sesión
    Then debo validar que el mensaje de error "<msgError>" sea visible y aparezca <count> veces
    Examples:
      | msgError | count |
      | Required | 2     |

  @LoginWithInvalidCredentials
  Scenario Outline: Login with invalid credentials
    When escribo el usuario "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then debo validar que el mensaje de error "<msgError>" sea visible y aparezca <count> veces
    Examples:
      | user | pass | msgError            | count |
      | asd  | asd  | Invalid credentials | 1     |