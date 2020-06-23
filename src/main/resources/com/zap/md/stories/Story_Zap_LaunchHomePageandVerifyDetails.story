Meta: 
@smoke
@test

Scenario: Open Zap webpage in Specified browser

Given user is on Zap Homepage
Then user verifies Delivery and Pickup Icon displayed on Homepage
Then user verifies Delivery Text is displayed and contains <text1>
Then user verifies Pickup Text is displayed and contains <text2>
Then user quits the browser


Examples:
|text1|text2|
|expectedDeliveryText|expectedPickupText|

