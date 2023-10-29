# EMAG_Cucumber_test
BDD testing on the site "https://www.emag.ro/". There are 5 test.

## Tests description

### BuyDevice
_Description_: In this scenario, the user wants to buy a device with the specification that it is in the price range.

_Steps_:
1. The user accesses the site.
1. Search for the device in searchbar.
1. Ticks button "Interval pret".
1. Inputs the desired minimum price and the desired high price.
1. Checks if the prices of the products displayed are in range.

### Compare
_Description_: There are 2 cases in this test. First the user selects 2 product to be compared. Second the user select 1 product and verifies if the warning appears.
The aim is to see if the warning appears based on the number of products the user choses.

Scenario 1. _Steps_:
1. Accesses the site.
1. Searches for item.
1. Selects first 2 products displayed
1. Clicks on the button "Compara".
1. The selectet products should appear.

Scenario 2. _Steps_:
1. Accesses the site.
1. Searches for item.
1. Selects first product displayed.
1. Clicks on the button "Compara".
1. Will check if the warning appears.

### DeleteFromWishlist
_Description_: Tests if the product selected for wishlist is deleted from wishlist.

_Steps_:
1. Accesses the site.
1. Select product to be wishlisted.
1. Navigates to wishlist.
1. Deletes the product from wishlist.

### SearchChocolate
_Description_: Tests the search function of a product. 

_Steps_:
1. Accesses the site.
1. Searches for "ciocolata".
1. The product appears on the screen.

### ShoppingCart
_Description_: Check if the shopping cart contains products after the user has selected them

_Steps_:
1. Accesses the site.
1. Selects a product.
1. Goes to the shopping cart.
1. Checks if there is a product in the shopping list.
