Meta:
@smoke
@test


Scenario: Open Zap webpage and search for a product, select first product from matrix page and add to cart in Specified browser

Given user is on Zap Homepage
Then user searches for product <productName1>
Then user captures name of first product in the search result
Then user selects the first product in the list
Then user adds the product to Basket
Then user verifies whether the product selected is displayed and as expected in Product details page
Then user adds the product to Basket
Then user verifies MiniCart Overlay on Page
Then user quits the browser


Examples:
|productName1|
|searchString3|
