Feature: User puts a product in wishlist and then deletes it

  Scenario: User deletes from wishlist
    Given User is o main page, selects a product to be wishlisted
    And goes to the wishlist page
    When User deletes product from wishlist
    Then the product will be deleted