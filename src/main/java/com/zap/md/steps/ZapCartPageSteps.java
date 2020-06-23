package com.zap.md.steps;

import com.zap.md.DataProvider;
import com.zap.md.Elements.CartPage;
import com.zap.md.methods.CommonMethods;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ZapCartPageSteps extends CartPage {
    private CommonMethods commonMethods = CommonInstance.commonMethods;
    private DataProvider dataProvider = CommonInstance.dataProvider;
    @Then("user verifies whether the cart page is opened and header contains $expectedText")
    public void verifyCartPage(@Named("expectedText") String expectedText){
        commonMethods.verifyElementDisplayed(cartPageHeader);
        commonMethods.verifyElementText(cartPageHeader, dataProvider.readFromHashMap(expectedText));
    }

    @Then("user gets the product price from $attribute")
    public void getProductIdPrice(@Named("attribute") String attribute){
        commonMethods.setProductPrice(commonMethods.getAttributeText(ProductPrice, attribute));
    }

    @Then("user gets the quantity from $attribute after increment and verifies the product Total")
    public void increaseQuantityTotal(@Named("attribute") String attribute){
        commonMethods.clickOnElement(IncrementButton);
        String productTotal = String.valueOf(Integer.parseInt(commonMethods.getAttributeText(quantityBox, attribute))*Integer.parseInt(commonMethods.getProductPrice()));
        commonMethods.verifyElementText(ProductTotal, productTotal);

    }

    @When("user enters the $name, $email, $telephone, $address for Checkout")
    public void enterUserDetails(@Named("name") String name, @Named("email") String email,
                                 @Named("telephone") String telephone, @Named("address") String address){
        commonMethods.typeInTextBox(UserNameField, dataProvider.readFromHashMap(name));
        commonMethods.typeInTextBox(UserEmailField, dataProvider.readFromHashMap(email));
        commonMethods.typeInTextBox(UserTeleField, dataProvider.readFromHashMap(telephone));
        commonMethods.typeInTextBox(UserAddressField, dataProvider.readFromHashMap(address));
    }

    @Then("user places order and verifies whether the order is placed and displays $message")
    public void placeOrderAndVerify(@Named("message") String message){
        commonMethods.clickOnElement(PlaceOrderButton);
        commonMethods.verifyVisibility(OrderSuccessMessage);
        commonMethods.verifyElementContainsText(OrderSuccessMessage, dataProvider.readFromHashMap(message));

    }
}
