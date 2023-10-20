Feature: User compares products

  Background:
    Given User navigates to the website
  Scenario: Select two products to compare
    When User searches for product "tablouri"
    And selects 2 products
    And clicks compare button
    Then Products should appear on the page

  Scenario: Select one product to compare
    When User searches for product "tablouri"
    And selects 1 products
    And clicks compare button
    Then Should appear the error message

