@Login
Feature: Login in application

  Background:
    Given estoy en la aplicación

  @LoginSuccessful
  Scenario Outline: Login successful in application
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    Examples:
      | user  |
      | Admin |

  @LoginSuccessfulAndValidateWidgets
  Scenario Outline: Login successful in application with widgets visibilities
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente encontrando <7> widgets
    Examples:
      | user  |
      | Admin |

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

  @LoginWithOnlyUsername
  Scenario Outline: Login with only username
    When escribo el usuario "<user>"
    And presiono el botón de inciar sesión
    Then debo validar que el mensaje de error "<msgError>" sea visible y aparezca <count> veces
    Examples:
      | user | msgError | count |
      | asd  | Required | 1     |

  @LoginWithOnlyPassword
  Scenario Outline: Login with only password
    When escribo la contraseña "<pass>"
    And presiono el botón de inciar sesión
    Then debo validar que el mensaje de error "<msgError>" sea visible y aparezca <count> veces
    Examples:
      | pass | msgError | count |
      | asd  | Required | 1     |