Feature: User wants to put an item in favorites list

  Scenario: User select favorite an item
    Given User is o main page
    When User selects item to be favorite
    And goes to the page with favorite things selected
    Then On favorite page to appear the favored item