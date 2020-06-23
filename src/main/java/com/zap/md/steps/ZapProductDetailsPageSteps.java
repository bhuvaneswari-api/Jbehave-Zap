package com.zap.md.steps;

import com.zap.md.Elements.ProductDetailsPage;
import com.zap.md.methods.CommonMethods;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ZapProductDetailsPageSteps extends ProductDetailsPage {
    private CommonMethods commonMethods = CommonInstance.commonMethods;

    @Then("user verifies whether the product selected is displayed and as expected in Product details page")
    public void verifyProductName(){
        commonMethods.verifyElementDisplayed(ProductDetailsText);
        commonMethods.compareTexts(commonMethods.getElementTextFromPage(ProductDetailsText), commonMethods.getNameOfFirstProduct());
    }

    @Then("user adds the product to Basket")
    public void addProductToBasket(){
        commonMethods.verifyElementDisplayed(AddToBasketButton);
        commonMethods.clickOnElement(AddToBasketButton);
    }

    @Then("user verifies MiniCart Overlay on Page")
    public void verifyMiniCart(){
        commonMethods.verifyVisibility(MiniCartOverLay);
        commonMethods.verifyElementDisplayed(MiniCartOverLay);
        commonMethods.verifyElementDisplayed(MiniCartOverLayHeader);
    }

    @Then("user clicks on Cart icon and Navigates to Cart Page")
    public void navigateToCartPage(){
        commonMethods.clickOnElement(CartIcon);
    }

}
