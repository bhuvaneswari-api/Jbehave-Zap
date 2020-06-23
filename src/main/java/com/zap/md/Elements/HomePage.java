package com.zap.md.Elements;

import com.zap.md.methods.InitializeBrowserConnectDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//This class holds all the locators in CartPage of Zap Website
public class HomePage{
    //creating object for InitializeBrowserConnectDriver Class to use it to get the driver during initElements action in the constructor
    InitializeBrowserConnectDriver initializeBrowserConnectDriver = new InitializeBrowserConnectDriver();
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'text-delivery')]")
    protected WebElement DeliveryText;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'image-delivery')]")
    protected  WebElement DeliveryImage;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'text-pickup')]")
    protected WebElement PickupText;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'image-pickup')]")
    protected  WebElement PickupImage;
    public HomePage(){
        //Above created object is used for getting driver instance, so that the elements can be located in the page during test run
        PageFactory.initElements(initializeBrowserConnectDriver.getDriver(), this);
    }
}
