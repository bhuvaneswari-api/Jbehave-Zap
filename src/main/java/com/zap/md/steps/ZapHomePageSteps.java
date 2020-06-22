package com.zap.md.steps;

import com.zap.md.methods.InitializeBrowser;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;



public class ZapHomePageSteps {
    @Given("customer is on Amazon Homepage in $browser browser")
    public void customerOnHomePage(@Named("browser") String browserType) throws InterruptedException {
        InitializeBrowser.openSpecifiedBrowser(browserType);
        Thread.sleep(10000);
    }
}
