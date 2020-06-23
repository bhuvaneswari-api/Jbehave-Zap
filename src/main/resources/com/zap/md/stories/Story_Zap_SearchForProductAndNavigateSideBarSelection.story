Meta:
@smoke
@test

Scenario: Open Zap webpage and search for Telephone and Navigate sidebar selection in Specified browser

Given user is on Zap Homepage
Then user searches for product <productName1>
Then user verifies search result has <expectedText> with <productName1>
Then user navigates through side bar selection by selecting category <category1>
Then user navigates through side bar selection by selecting category <category2>
Then user navigates through side bar selection by selecting category <category3>
Then user navigates through side bar selection by selecting category <category4>
Then user quits the browser


Examples:
|productName1|expectedText|category2|category1|category3|category4|
|searchString2|searchResultText|All|1|2|3|