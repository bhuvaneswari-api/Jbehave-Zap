Meta:
@smoke
@test

Scenario: Open Zap webpage and search for laptop in Specified browser

Given user is on Zap Homepage
Then user verifies Search Bar displays the <text1> in <attributeName>
Then user searches for product <productName1>
Then user verifies search result has <expectedText> with <productName1>
Then user quits the browser


Examples:
|text1|attributeName|productName1|expectedText|
|searchText|placeholder|searchString1|searchResultText|
