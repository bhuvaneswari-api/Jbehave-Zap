package com.zap.md.steps;

import com.zap.md.DataProvider;
import com.zap.md.Elements.HomePage;
import com.zap.md.methods.CommonMethods;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;


public class ZapHomePageSteps extends HomePage{
    private DataProvider dataProvider = CommonInstance.dataProvider;
    private CommonMethods commonMethods = CommonInstance.commonMethods;
    @Then("user verifies Delivery and Pickup Icon displayed on Homepage")
    public void verifyDeliveryIcon(){
        commonMethods.verifyElementDisplayed(DeliveryImage);
        commonMethods.verifyElementDisplayed(PickupImage);
    }

    @Then("user verifies Delivery Text is displayed and contains $expectedText")
    public void verifyDeliveryText(@Named("expectedText") String expectedText){
        commonMethods.verifyElementDisplayed(DeliveryText);
        commonMethods.verifyElementText(DeliveryText, dataProvider.readFromHashMap(expectedText));
    }

    @Then("user verifies Pickup Text is displayed and contains $expectedText")
    public void verifyPickupText(@Named("expectedText") String expectedText){
        commonMethods.verifyElementDisplayed(PickupText);
        commonMethods.verifyElementText(PickupText, dataProvider.readFromHashMap(expectedText));
    }

}
