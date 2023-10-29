Feature: Buy device within price range

  Scenario Outline: User wants to buy a device
    Given User opens main page
    When User searches for device "<device>"
    And User checks for Interval pret
    And wants the price to be between "<minPrice>" and "<maxPrice>"
    Then The prices should be in the range "<minPrice>" and "<maxPrice>"

    Examples:
    | device    | minPrice  | maxPrice |
    |televizor| 1000      | 5000     |
    |telefon  | 2000      | 6000     |
