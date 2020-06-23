Meta:
@smoke
@test

Scenario: Open Zap Homepage, add a product to cart, navigate to cart page, at the cart page increase the quantity to check price increase

Given user is on Zap Homepage
Then user searches for product <productName1>
Then user selects the first product in the list
Then user adds the product to Basket
Then user clicks on Cart icon and Navigates to Cart Page
Then user verifies whether the cart page is opened and header contains <Text1>
Then user gets the product price from <attributeName1>
Then user gets the quantity from <attributeName2> after increment and verifies the product Total
Then user quits the browser


Examples:
|productName1|Text1|attributeName1|attributeName2|
|searchString4|cartPageHeaderText|data-price-raw|value|