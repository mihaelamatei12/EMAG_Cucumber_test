Feature: Search for chocolate

  Scenario: Users wants to buy chocolate
    Given User opens page and search tab
    When User searches for "ciocolata"
    Then Results are showing

