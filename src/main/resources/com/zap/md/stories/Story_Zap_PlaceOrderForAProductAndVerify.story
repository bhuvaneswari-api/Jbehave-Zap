Meta:
@smoke
@test

Scenario: Open Zap Homepage, add a product to cart, navigate to cart page, enter user details and place order

Given user is on Zap Homepage
Then user searches for product <productName1>
Then user selects the first product in the list
Then user adds the product to Basket
Then user clicks on Cart icon and Navigates to Cart Page
When user enters the <Name>, <Email>, <Telephone>, <Address> for Checkout
Then user places order and verifies whether the order is placed and displays <message>
Then user quits the browser


Examples:
|productName1|Name|Email|Telephone|Address|message|
|searchString5|userName|userEmail|userNumber|userAddress|OrderSuccessMessage|