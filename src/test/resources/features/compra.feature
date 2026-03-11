
Feature: Compra de productos en la pagina web Demoblaze

  Scenario Outline: Comprar dos productos correctamente

    Given el usuario abre la pagina de Demoblaze
    When el usuario agrega "<producto1>" y "<producto2>" al carrito
    And el usuario completa la compra
    Then la compra deberia ser exitosa

    Examples:
      | producto1 | producto2 |
      | Samsung galaxy s6 | Nokia lumia 1520 |

  Scenario: Comprar productos usando CSV

    Given el usuario abre la pagina de Demoblaze
    When el usuario agrega productos desde csv
    And el usuario completa la compra
    Then la compra deberia ser exitosa