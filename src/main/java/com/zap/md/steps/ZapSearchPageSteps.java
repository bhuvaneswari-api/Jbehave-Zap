package com.zap.md.steps;

import com.zap.md.DataProvider;
import com.zap.md.Elements.SearchPage;
import com.zap.md.methods.CommonMethods;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;



public class ZapSearchPageSteps extends SearchPage {
    private DataProvider dataProvider = CommonInstance.dataProvider;
    private CommonMethods commonMethods = CommonInstance.commonMethods;

    @Then("user verifies Search Bar displays the $expectedText in $attribute")
    public void verifyTextDisplayedInSearchBar(@Named("expectedText") String expectedText, @Named("attribute") String attribute){
        commonMethods.verifyAttributeText(SearchBar, attribute, dataProvider.readFromHashMap(expectedText));
    }

    @Then("user searches for product $productName")
    public void searchProduct(@Named("productName") String  productName){
        commonMethods.typeInTextBox(SearchBar, dataProvider.readFromHashMap(productName));
        commonMethods.pressKeyBoardKeys(SearchBar, "ENTER");
    }

    @Then("user verifies search result has $expectedText with $productName")
    public void verifySearchResult(@Named("expectedText") String expectedText, @Named("productName") String productName){
        String concatenatedExpectedText = dataProvider.readFromHashMap(expectedText)+" \""+dataProvider.readFromHashMap(productName)+"\"";
        commonMethods.verifyElementText(SearchResultHeader, concatenatedExpectedText);
    }

    @Then("user navigates through side bar selection by selecting category $cateogryNumber")
    public void selectSideBarNavigation(@Named("categoryNumber") String categoryNumber){
        switch (categoryNumber){
            case "All":
                commonMethods.clickOnElement(categoryAll);
                break;
            case "1":
                commonMethods.clickOnElement(category1);
                break;
            case "2":
                commonMethods.clickOnElement(category2);
                break;
            case "3":
                commonMethods.clickOnElement(category3);
                break;
        }

    }

    @Then("user captures name of first product in the search result")
    public void getProductDetail(){
        commonMethods.setNameOfFirstProduct(commonMethods.getElementTextFromPage(firstProductName));

    }

    @Then("user selects the first product in the list")
    public void selectProduct(){
        commonMethods.clickOnElement(firstProductInList);
    }
}
