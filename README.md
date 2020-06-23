# Jbehave-Zap-Cucumber
This project contains following 6 testcases placed under folder - src/main/resources/com.zap.md.stories/:
* Launch Zap Home Page and verify image and text of four elements in Homepage.
* Search for a product and verify search results
* Verify SideBar navigation in Search results page
* Search for a product and add to cart and verify mini cart overlay
* Modify product quantity and verify product total
* Place Order and Verify

#CommonVariables
Contains all common variables used for all tests, for example AUT url, Text to verify in various elements.

#src/main/java/com.zap.md - ParentFolder for Scripts
Contains 3 folders and 2 java files

#ParentFolder/Elements
Contains java class defining the locators under page wise order in Page Object Model(POM)

#ParentFolder/methods
Contains java class defining all the common methods and for Initializing browser instance

#Flow of Test Run
The flow of test run can be identified with respect to the BDD or Cucumber sentences and method calls done respectively