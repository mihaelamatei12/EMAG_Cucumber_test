Feature: User compares products

  Background:
    Given User navigates to the website
  Scenario Outline: Select two products to compare
    When User searches for product "<item>"
    And selects 2 products
    And clicks compare button
    Then Products should appear on the page

    Examples:
      | item     |
      | tablouri |

  Scenario Outline: Select one product to compare
    When User searches for product "<item>"
    And selects 1 products
    And clicks compare button
    Then Should appear the error message

    Examples:
      | item     |
      | tablouri |