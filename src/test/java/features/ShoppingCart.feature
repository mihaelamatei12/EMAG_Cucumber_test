Feature: User select product to be put in shopping cart

  Scenario: User add product in shopping cart
    Given User is on main page
    When User selects an item to be on the shopping list
    And Goes to the shopping cart
    Then The shop cart is not empty
