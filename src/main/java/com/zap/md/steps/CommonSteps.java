package com.zap.md.steps;

import com.zap.md.methods.CommonMethods;
import com.zap.md.methods.InitializeBrowserConnectDriver;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;



public class CommonSteps extends InitializeBrowserConnectDriver{
    private CommonMethods commonMethods = CommonInstance.commonMethods;
    @Given("user is on Zap Homepage")
    public void userOnHomePage(){
        commonMethods.VerifyHomePageTitle();
    }

    @Then("user quits the browser")
    public void closeBrowserSession(){
        commonMethods.closeBrowser();
    }
}
