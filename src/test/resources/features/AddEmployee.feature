@AddEmployee
Feature: Add employee in Application

  Background:
    Given estoy en la aplicación

  @AddEmployeeSimple
  Scenario Outline: Added new a simple employee in application
    When escribo el usuario "<user>"
    And escribo la contraseña
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
      | user  |
      | Admin |

  @AddEmployeeWhitLoginDetails
  Scenario Outline: Added new a simple employee in application
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    When me dirijo al menú "PIM"
    Then valido encontarme en la seccion de empleados
    When presiono el botón para agregar un nuevo empleado
    And completo la información del nuevo empleado
      | First Name | Middle Name      | Last Name      |
      | Name Test  | Middle Name Test | Last Name Test |
    And habilito crear los detalles de login
    And completo los detalles del login
      | Username | Password     |
      | UserTest | PassWord#123 |
    And guardo el nuevo empleado
    Then valido que el nuevo empleado se haya creado correctamente
    Examples:
      | user  |
      | Admin |

  @AddEmployeeWhitLoginDetailsAndLogin
  Scenario Outline: Added new a simple employee in application
    When escribo el usuario "<user>"
    And escribo la contraseña
    And presiono el botón de inciar sesión
    Then valido haber iniciado sesión correctamente
    When me dirijo al menú "PIM"
    Then valido encontarme en la seccion de empleados
    When presiono el botón para agregar un nuevo empleado
    And completo la información del nuevo empleado
      | First Name | Middle Name      | Last Name      |
      | Name Test  | Middle Name Test | Last Name Test |
    And habilito crear los detalles de login
    And completo los detalles del login
      | Username | Password     |
      | UserTest4 | PassWord#123 |
    And guardo el nuevo empleado
    Then valido que el nuevo empleado se haya creado correctamente
    When cierro sesión
    And valido encontarme en el formulario de inciar sesión
    And inicio sesión con el usuario creado para el empleado
    Then valido haber iniciado sesión correctamente
    Examples:
      | user  |
      | Admin |

